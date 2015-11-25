package com.revosoft.web.authentication;

import com.revosoft.netty.server.Config;
import com.revosoft.netty.server.http.NettyServer;
import com.revosoft.netty.server.http.routing.WebRouter;
import com.revosoft.web.authentication.web.routing.AuthenticationWebRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NettyServerConfig {

    @Value("${netty.port}")
    private int port;

    @Autowired
    private WebRouter router;

    @Bean
    public WebRouter bookerWebRouter() {
        return new AuthenticationWebRouter();
    }

    @Bean
    public NettyServer nettyServer() {
        return new NettyServer(new Config(), router, port);
    }

}
