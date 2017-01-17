package com.tender.service;

import com.tender.dao.SupplierDAO;
import com.tender.dao.factory.MySqlDAOFactory;
import com.tender.entity.Supplier;

import java.sql.Connection;

/**
 * Created by Денис on 11.01.2017.
 */
public class LoginServiceImpl implements LoginService {
    private Connection connection;

    public LoginServiceImpl(Connection connection){
        this.connection = connection;
    }
    @Override
    public Supplier login(String email, String password) {

        SupplierDAO supplierDAO = new MySqlDAOFactory(connection).getSupplierDAO();
        Supplier supplier = supplierDAO.findSupplierByLoginAndPassword(email, password);

        return supplier;
    }
}
