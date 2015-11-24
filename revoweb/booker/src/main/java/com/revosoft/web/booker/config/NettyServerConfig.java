package com.revosoft.web.booker.config;

import com.revosoft.netty.server.Config;
import com.revosoft.netty.server.http.NettyServer;
import com.revosoft.netty.server.http.routing.WebRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.revosoft.web.booker.web.routing.BookerWebRouter;

@Configuration
public class NettyServerConfig {

    @Value("${netty.port}")
    private int port;

    @Autowired
    private WebRouter router;

    @Bean
    public WebRouter bookerWebRouter() {
        return new BookerWebRouter();
    }

    @Bean
    public NettyServer nettyServer() {
        return new NettyServer(new Config(), router, port);
    }

}
