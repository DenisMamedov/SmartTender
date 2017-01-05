package com.tender.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Денис on 02.01.2017.
 */
public class JdbcConnectionPool {

    private List<Connection> availableConnections = new ArrayList<>();

    public JdbcConnectionPool(){

        initializeConnectionPool();
    }

    private Connection createNewConnection(){

        Configuration config = Configuration.getInstance();
        Connection connection = null;
        try{
            Class.forName(config.DB_DRIVER);
            connection = DriverManager.getConnection(config.DB_URL, config.DB_USER_NAME, config.DB_PASSWORD);
        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    private void initializeConnectionPool(){

        while (!ConnectionPollIsFull()){
            availableConnections.add(createNewConnection());
        }
    }

    private synchronized boolean ConnectionPollIsFull(){

        boolean isFull = true;
        final int MAX_POOL_SIZE = Configuration.getInstance().DB_MAX_CONNECTIONS;
        if (availableConnections.size() < MAX_POOL_SIZE){
            isFull = false;
        }
        return isFull;
    }

    public synchronized Connection getConnectionFromPool(){

        Connection connection = null;
        if(availableConnections.size() > 0)
        {
            connection = availableConnections.get(0);
            availableConnections.remove(0);
        }
        return connection;
    }

    public synchronized void returnConnectionToPool(Connection connection){

        availableConnections.add(connection);
    }

    public void closeConnection(Connection connection){
        try{
            if(connection != null){
                connection.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
