package com.tender.dao.factory;

import com.tender.dao.*;

import java.sql.Connection;

/**
 * Created by Денис on 24.12.2016.
 */
public abstract class DAOFactory {

    public abstract TenderDAO getTenderDAO();

    public abstract CompanyDAO getCompanyDAO();

    public abstract CategoryDAO getCategoryDAO();

    public abstract StatusDAO getStatusDAO();

    public abstract SupplierDAO getSupplierDAO();

    public static DAOFactory getDAOFactory(Connection connection) {
        return new MySqlDAOFactory(connection);
    }
}
