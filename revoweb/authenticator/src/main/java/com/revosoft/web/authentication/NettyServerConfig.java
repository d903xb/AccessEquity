package com.revosoft.web.authentication;

import com.revosoft.netty.server.Config;
import com.revosoft.netty.server.http.NettyServer;
import com.revosoft.netty.server.http.routing.WebRouter;
import com.revosoft.web.authentication.web.routing.AuthenticationWebRouter;
import com.revosoft.web.database.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;

@Configuration
public class NettyServerConfig {

    @Value("${netty.port}")
    private int port;


    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private WebRouter router;


    @Bean
    public WebRouter authWebRouter() {
        return new AuthenticationWebRouter(tokenRepository);
    }

    @Bean
    public NettyServer nettyServer() {
        return new NettyServer(new Config(), router, port);
    }

}
