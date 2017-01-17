package com.tender.service;

import com.tender.dao.SupplierDAO;
import com.tender.dao.factory.MySqlDAOFactory;
import com.tender.entity.Supplier;

import java.sql.Connection;

/**
 * Created by Денис on 11.01.2017.
 */
public class UserServiceImpl implements UserService {

    private Connection connection;

    public UserServiceImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String getRoleFromSession(Supplier supplier) {
        return "user";
    }

    @Override
    public int registration(Supplier supplier) {
        SupplierDAO supplierDAO = new MySqlDAOFactory(connection).getSupplierDAO();
        return supplierDAO.insertSupplier(supplier);
    }
}
