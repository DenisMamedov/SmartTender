package com.tender.connection;

import com.tender.config.Config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Денис on 07.01.2017.
 */
public class ConnectionPool {

    private static ConnectionPool instance = null;
    private static final String TOMCAT_JNDI_NAME="java:comp/env/";
    private DataSource pool;
    private String DATASOURCE = Config.getInstance().getProperty(Config.DATASOURCE);

    public ConnectionPool() {
        initialPool();
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    private void initialPool(){
        try{
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup(TOMCAT_JNDI_NAME);
            this.pool = (DataSource)envContext.lookup(DATASOURCE);
        }catch(NamingException e){
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection(){
        Connection connection = null;
        try {
            connection = pool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
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
