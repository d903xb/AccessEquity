package main.java.com.revosoft.web.database.local;
import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Server;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.revosoft.web.database.liquibase.LiquibaseConfig;
import java.sql.SQLException;


@Slf4j
public class LocalDatabase {

    private static String port = "9092";
    public static void main(final String[] args) throws SQLException {

        Server.createTcpServer("-tcpPort", port, "-tcpAllowOthers").start();

        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(
                        DatabaseConfig.class,
                        LiquibaseConfig.class);

        log.info("Local Database started successfully.");

    }

}