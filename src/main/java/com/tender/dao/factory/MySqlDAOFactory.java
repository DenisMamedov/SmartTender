package com.tender.dao.factory;

import com.tender.dao.*;
import com.tender.dao.impl.*;

import java.sql.Connection;

/**
 * Created by Денис on 24.12.2016.
 */
public class MySqlDAOFactory extends DAOFactory {

    private Connection connection;

    public MySqlDAOFactory(Connection connection) {
        this.connection = connection;
    }

    public TenderDAO getTenderDAO() {
        return new MySqlTenderDAO(connection);
    }

    public CompanyDAO getCompanyDAO() {
        return new MySqlCompanyDAO(connection);
    }

    public CategoryDAO getCategoryDAO() {
        return new MySqlCategoryDAO(connection);
    }

    public StatusDAO getStatusDAO() {
        return new MySqlStatusDAO(connection);
    }

    public SupplierDAO getSupplierDAO() {
        return new MySqlSupplierDAO(connection);
    }

    public TenderSpecificationDAO getTenderSpecificationDAO() {
        return new MySqlTenderSpecificationDAO(connection);
    }

    public OfferDAO getOfferDAO() {
        return new MySqlOfferDAO(connection);
    }

}
