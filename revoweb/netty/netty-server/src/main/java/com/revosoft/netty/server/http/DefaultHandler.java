package com.revosoft.netty.server.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import com.revosoft.netty.server.http.routing.WebRouter;
import com.revosoft.netty.server.http.message.FullDecodedRequest;
import com.revosoft.netty.server.http.message.Response;

public class DefaultHandler extends
		SimpleChannelInboundHandler<FullDecodedRequest> {

	private final EventExecutorGroup executor;
	private final WebRouter router;

	public DefaultHandler(EventExecutorGroup executor,
						  WebRouter router) {
		super(false);
		this.executor = executor;
		this.router = router;
	}

	private boolean authenticateRequest(FullDecodedRequest decodedRequest) {
		for(Map.Entry<String,String> entry : decodedRequest.getRequest().getHttpRequest().headers().entries()){
			if(entry.getKey().equals("REVO-TOKEN")) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected void channelRead0(final ChannelHandlerContext ctx,
			final FullDecodedRequest decodedRequest) throws Exception {

		System.out.println("authenticating request:");

		if (!authenticateRequest(decodedRequest)) {
			//ctx.fireExceptionCaught(new Exception("UNAUTHORIZED"));
			ctx.writeAndFlush(new Response(decodedRequest.getRequest(),
					"UNAUTHORIZED_TOKEN"));
			return;
		}

		Callable<? extends Object> callable = new Provider(
				decodedRequest.getPath(), decodedRequest.getValueJson(), router);

		final Future<? extends Object> future = executor.submit(callable);

		future.addListener(new GenericFutureListener<Future<Object>>() {
			@Override
			public void operationComplete(Future<Object> future)
					throws Exception {
				if (future.isSuccess()) {
					ctx.writeAndFlush(new Response(decodedRequest.getRequest(),
							future.get()));
				} else {
					ctx.fireExceptionCaught(future.cause());
				}
			}
		});
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		super.channelInactive(ctx);
		// TODO(adolgarev): cancel submitted tasks,
		// that works only for not in progress tasks
		// if (future != null && !future.isDone()) {
		// future.cancel(true);
		// }
	}

}
