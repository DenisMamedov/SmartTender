package com.tender.service;

import com.tender.connection.ConnectionPool;

import java.sql.Connection;
import java.util.HashMap;

/**
 * Created by Денис on 06.01.2017.
 */
public class ServiceManager {

    private static ServiceManager instance = new ServiceManager();
    private HashMap<Class, Object> map = new HashMap<>();

    private ServiceManager() {
        ConnectionPool connectionPoll = ConnectionPool.getInstance();
        Connection connection = connectionPoll.getConnection();
        map.put(TenderService.class, new TenderServiceImpl(connection));
        map.put(LoginService.class, new LoginServiceImpl(connection));
        map.put(UserService.class, new UserServiceImpl(connection));

    }

    public static Object getService(Class serviceClass) {
        return instance.map.get(serviceClass);
    }
}
