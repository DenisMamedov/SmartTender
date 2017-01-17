package com.tender.dao.impl;

import com.tender.dao.TenderDAO;
import com.tender.dao.TenderSpecificationDAO;
import com.tender.dao.factory.MySqlDAOFactory;
import com.tender.entity.TenderSpecification;
import com.tender.entity.builder.TenderSpecificationBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Денис on 13.01.2017.
 */
public class MySqlTenderSpecificationDAO implements TenderSpecificationDAO {

    private static final String SELECT_TENDER_SPEC_BY_TENDER_ID = "SELECT * FROM tender_specification WHERE tender_id = ?";

    private Connection connection;
    private TenderDAO tenderDAO;

    public MySqlTenderSpecificationDAO(Connection connection) {
        this.connection = connection;
        this.tenderDAO = MySqlDAOFactory.getDAOFactory(connection).getTenderDAO();
    }

    @Override
    public int insertTenderSpecification(TenderSpecification tenderSpec) {
        return 0;
    }

    @Override
    public boolean deleteTenderSpecification(int id) {
        return false;
    }

    @Override
    public TenderSpecification findTenderSpecification(int id) {
        return null;
    }

    @Override
    public boolean updateTenderSpecification(TenderSpecification tenderSpec) {
        return false;
    }

    @Override
    public LinkedList<TenderSpecification> selectTenderSpecificationByTenderId(int id) {
        LinkedList<TenderSpecification> list = new LinkedList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_TENDER_SPEC_BY_TENDER_ID);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                TenderSpecification tenderSpec = new TenderSpecificationBuilder()
                        .setTender(tenderDAO.findTender(id))
                        .setLotId(result.getInt("lot_id"))
                        .setSpecification(result.getString("specification"))
                        .setQuantity(result.getInt("quantity"))
                        .setInformation(result.getString("information"))
                        .createTenderSpecification();
                list.add(tenderSpec);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return list;
    }
}
