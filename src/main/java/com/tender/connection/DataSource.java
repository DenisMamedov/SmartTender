package com.tender.connection;

import java.sql.Connection;

/**
 * Created by Денис on 02.01.2017.
 */
public class DataSource {

    private static JdbcConnectionPool pool = new JdbcConnectionPool();

    public static Connection getConnection(){
        return pool.getConnectionFromPool();
    }

    public static void returnConnection(Connection connection){
        pool.closeConnection(connection);
        pool.returnConnectionToPool(connection);
    }
}
