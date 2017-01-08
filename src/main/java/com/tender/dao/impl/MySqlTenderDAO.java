package com.tender.dao.impl;

import com.tender.dao.CategoryDAO;
import com.tender.dao.CompanyDAO;
import com.tender.dao.StatusDAO;
import com.tender.parser.DateTimeParser;
import com.tender.dao.TenderDAO;
import com.tender.dao.factory.MySqlDAOFactory;
import com.tender.entity.Tender;
import com.tender.entity.builder.TenderBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Денис on 24.12.2016.
 */
public class MySqlTenderDAO implements TenderDAO {
    private static final String SELECT_ALL_TENDERS = "SELECT * FROM tender";
    private CompanyDAO companyDAO;
    private CategoryDAO categoryDAO;
    private StatusDAO statusDAO;
    private Connection connection;

    public MySqlTenderDAO(Connection connection){
        this.connection = connection;
        this.companyDAO = MySqlDAOFactory.getDAOFactory(connection).getCompanyDAO();
        this.categoryDAO = MySqlDAOFactory.getDAOFactory(connection).getCategoryDAO();
        this.statusDAO = MySqlDAOFactory.getDAOFactory(connection).getStatusDAO();
    }

    @Override
    public int insertTender(Tender tender) {
        return 0;
    }

    @Override
    public boolean deleteTender(int id) {
        return false;
    }

    @Override
    public Tender findTender(int id) {
        return null;
    }

    @Override
    public boolean updateTender(Tender tender) {
        return false;
    }

    @Override
    public LinkedList<Tender> selectTender() {
        LinkedList<Tender> list = new LinkedList<>();
        try {
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_TENDERS);
        ResultSet result = statement.executeQuery();
            while (result.next()){
            Tender tender = new TenderBuilder()
                    .setTenderName(result.getString("tender_name"))
                    .setCategory(categoryDAO.findCategory(result.getInt("category_id")))
                    .setCompany(companyDAO.findCompany(result.getInt("company_id")))
                    .setEndDate(DateTimeParser.parseDate(result.getDate("end_date")))
                    .setStatus(statusDAO.findStatus(result.getInt("status_id")))
                    .createTender();
            tender.setId(result.getInt("id"));
            list.add(tender);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
