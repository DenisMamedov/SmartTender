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

    private static final String FIND_TENDER = "SELECT * FROM tender WHERE id = ?";

    private static final String SELECT_ALL_TENDERS_BY_SUPPLIER_ID = "SELECT t.id, t.tender_name, t.company_id, t.category_id, t.end_date, t.status_id, s.status FROM tender t " +
            "JOIN company co ON t.company_id=co.id " +
            "JOIN category ca ON t.category_id=ca.id " +
            "JOIN status s ON t.status_id=s.id " +
            "JOIN offer o ON t.id=o.tender_id " +
            "WHERE o.supplier_id=? AND s.status = ? GROUP BY o.tender_id";

    private static final String SEARCH_TENDER_BY_CONTEXT = "SELECT t.id, t.tender_name, t.company_id, co.company_name, co.address, co.contact_name, co.contact_phone, ca.category_name, t.category_id, t.end_date, t.status_id FROM tender t " +
            "JOIN company co ON t.company_id=co.id " +
            "JOIN category ca ON t.category_id=ca.id " +
            "JOIN status s ON t.status_id=s.id " +
            "WHERE co.company_name LIKE ? OR " +
            "t.id LIKE ? OR " +
            "t.tender_name LIKE ? OR " +
            "ca.category_name LIKE ? OR " +
            "co.address LIKE ?";

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
        Tender tender = null;
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_TENDER);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                tender = createEntity(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tender;
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
            list.add(createEntity(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public LinkedList<Tender> searchTenderByContext(String context) {
        LinkedList<Tender> list = new LinkedList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SEARCH_TENDER_BY_CONTEXT);
            for(int i = 1; i <=5; i++){
                statement.setString(i, "%" + context + "%");
            }
            System.out.println();
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Tender tender = createEntity(result);
                list.add(tender);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public LinkedList<Tender> selectTenderBySupplierId(int id, String status) {
        LinkedList<Tender> list = new LinkedList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_TENDERS_BY_SUPPLIER_ID);
            statement.setInt(1, id);
            statement.setString(2, status);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                list.add(createEntity(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Tender createEntity(ResultSet result) {
        Tender tender = null;
        try {
            tender = new TenderBuilder()
                    .setTenderName(result.getString("tender_name"))
                    .setCategory(categoryDAO.findCategory(result.getInt("category_id")))
                    .setCompany(companyDAO.findCompany(result.getInt("company_id")))
                    .setEndDate(DateTimeParser.parseDate(result.getDate("end_date")))
                    .setStatus(statusDAO.findStatus(result.getInt("status_id")))
                    .createTender();
            tender.setId(result.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tender;
    }
}
