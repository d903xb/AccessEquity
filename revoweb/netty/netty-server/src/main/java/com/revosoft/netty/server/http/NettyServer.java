package com.revosoft.netty.server.http;

import com.revosoft.netty.server.Config;
import com.revosoft.netty.server.http.routing.WebRouter;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyServer {

	private final Config conf;
	private final WebRouter router;
	private final int port;

	public NettyServer(Config conf, WebRouter router, int port) {
		this.conf = conf;
		this.router = router;
		this.port = port;
	}

	public void run() {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(new DefaultServerInitializer(conf, router))
					.option(ChannelOption.SO_BACKLOG, conf.getBacklog())
					.option(ChannelOption.SO_REUSEADDR, true);

			Channel ch = b.bind(port).sync().channel();
			log.info("Netty server started on port ("+ port + ") using router (" + router + ")");
			ch.closeFuture().sync();

		}
		catch (InterruptedException e)
		{
			log.info(e.getMessage());
		}
		finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

}
