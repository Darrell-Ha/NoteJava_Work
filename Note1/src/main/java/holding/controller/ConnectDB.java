package holding.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    private static final String LINK_DB ="jdbc:mysql://localhost:3306/testspring";
    private static final String USER_DB ="root";
    private static final String PASSWORD="159753";
    //// Eager Initialization ///
    private static final ConnectDB connectDB = new ConnectDB();

    private ConnectDB(){

    }
    public static ConnectDB getInstance(){
        return connectDB;
    }
    public Connection getConnectionDB(){
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
