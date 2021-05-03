package holding.controller;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class ConnectDB_Bean {
    private static final String LINK_DB ="jdbc:mysql://localhost:3306/testspring";
    private static final String USER_DB ="root";
    private static final String PASSWORD="159753";

    @Bean
    Connection getConnection(){
        Connection connect = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(LINK_DB,USER_DB,PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connect;
    }

}
