package com.example.authservice.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {

    @Value("${MYSQL_HOST:localhost}")
    private String mysqlHost;
    
    @Value("${MYSQL_PORT:3306}")
    private int mysqlPort;
    
    @Value("${MYSQL_DB_NAME:clientsatisfaction}")
    private String mysqlDbName;
    
    @Value("${MYSQL_USER:root}")
    private String mysqlUser;
    
    @Value("${MYSQL_PASSWORD:mploki78)P}")
    private String mysqlPassword;
    

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + mysqlDbName);
        dataSource.setUsername(mysqlUser);
        dataSource.setPassword(mysqlPassword);
        return dataSource;
    }
}