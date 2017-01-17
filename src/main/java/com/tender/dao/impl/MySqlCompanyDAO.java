package com.tender.dao.impl;

import com.tender.dao.CompanyDAO;
import com.tender.entity.Company;
import com.tender.entity.builder.CompanyBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Денис on 03.01.2017.
 */
public class MySqlCompanyDAO implements CompanyDAO {

    public static final String FIND_COMPANY = "SELECT * FROM company WHERE id = ?";

    private Connection connection;

    public MySqlCompanyDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Company findCompany(int id) {
        Company company = null;
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_COMPANY);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            result.next();
            company = new CompanyBuilder()
                    .setCompanyName(result.getString("company_name"))
                    .setAddress(result.getString("address"))
                    .setContactName(result.getString("contact_name"))
                    .setContactPhone(result.getString("contact_phone"))
                    .createCompany();
            company.setId(result.getInt("id"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return company;
    }

}
