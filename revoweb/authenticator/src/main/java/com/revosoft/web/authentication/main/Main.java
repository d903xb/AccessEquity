package com.revosoft.web.authentication.main;

import com.revosoft.web.authentication.*;
import com.revosoft.web.database.repository.TokenRepository;
import com.revosoft.web.database.repository.config.TokenRepositoryConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main (final String[] args) {

        if(args.length != 1) {
            log.error("Please specify location of config file AuthServer.json");
            System.exit(1);
        }
        else {
            System.setProperty("propertyfile.location", args[0]);
        }

        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(
                        PropertiesConfig.class,
                        DatabaseConfig.class,
                        TokenRepositoryConfig.class,
                        JmsConfig.class,
                        NettyServerConfig.class,
                        ServiceConfig.class);

         log.info("RevoWebAuthenticator started successfully.");


    }
}

