package com.tender.dao.factory;

import com.tender.dao.CategoryDAO;
import com.tender.dao.CompanyDAO;
import com.tender.dao.StatusDAO;
import com.tender.dao.TenderDAO;
import com.tender.dao.impl.MySqlCompanyDAO;
import com.tender.dao.impl.MySqlStatusDAO;
import com.tender.dao.impl.MySqlTenderDAO;
import com.tender.dao.impl.MySqlCategoryDAO;

import java.sql.Connection;

/**
 * Created by Денис on 24.12.2016.
 */
public class MySqlDAOFactory extends DAOFactory {

    private Connection connection;

    public MySqlDAOFactory(Connection connection){
        this.connection = connection;
    }

    public TenderDAO getTenderDAO(){
        return new MySqlTenderDAO(connection);
    }

    public CompanyDAO getCompanyDAO(){
        return new MySqlCompanyDAO(connection);
    }

    public CategoryDAO getCategoryDAO(){
        return new MySqlCategoryDAO(connection);
    }

    public StatusDAO getStatusDAO(){
        return new MySqlStatusDAO(connection);
    }

}
