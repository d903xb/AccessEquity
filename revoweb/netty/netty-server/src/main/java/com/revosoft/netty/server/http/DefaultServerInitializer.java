package com.revosoft.netty.server.http;

import com.revosoft.netty.server.http.routing.WebRouter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import com.revosoft.netty.server.Config;

public class DefaultServerInitializer extends ChannelInitializer<SocketChannel> {

	private final Config conf;

	private final EventExecutorGroup executor;
	private final WebRouter router;
	public DefaultServerInitializer(Config conf, WebRouter router) {
		this.conf = conf;
		this.router = router;
		this.executor = new DefaultEventExecutorGroup(
				conf.getTaskThreadPoolSize());
	}

	@Override
	public void initChannel(SocketChannel ch) throws Exception {
		// Create a default pipeline implementation
		final ChannelPipeline p = ch.pipeline();

		// Uncomment the following line if you want HTTPS
		// SSLEngine engine =
		// SecureChatSslContextFactory.getServerContext().createSSLEngine();
		// engine.setUseClientMode(false);
		// p.addLast("ssl", new SslHandler(engine));
		p.addLast("httpDecoder", new HttpRequestDecoder());
		// Don't want to handle HttpChunks
		p.addLast("httpAggregator",
				new HttpObjectAggregator(conf.getClientMaxBodySize()));
		p.addLast("httpDecoderAux", new RequestDecoder());
		p.addLast("httpEncoder", new HttpResponseEncoder());
		// Automatic content compression
//		p.addLast("httpDeflater", new HttpContentCompressor());
		p.addLast("httpEncoderAux", new ResponseEncoder());
		p.addLast("httpPayloadEncoder", new JacksonJsonResponseEncoder());
		p.addLast("httpPayloadDecoder", new FormPayloadDecoder());
		p.addLast("handler", new DefaultHandler(executor, router));
		p.addLast("httpExceptionHandler", new DefaultExceptionHandler());
	}
}
