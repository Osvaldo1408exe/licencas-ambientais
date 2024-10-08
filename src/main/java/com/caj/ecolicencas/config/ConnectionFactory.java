package com.caj.ecolicencas.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException{
        String url = "jdbc:postgresql://localhost:5432/ecolicencas";
        String user = "postgres";
        String password = "321";

        return DriverManager.getConnection(url,user,password);
    }


}
