package com.tender.service;

import com.tender.dao.TenderDAO;
import com.tender.dao.factory.MySqlDAOFactory;
import com.tender.entity.Tender;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Денис on 02.01.2017.
 */
public class TenderServiceImpl implements TenderService {

    private Connection connection;

    public TenderServiceImpl(Connection connection){
        this.connection = connection;
    }

    public LinkedList<Tender> showTenders(){

        TenderDAO tenderDAO = new MySqlDAOFactory(connection).getTenderDAO();
        LinkedList<Tender> tenders = tenderDAO.selectTender();
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenders;
    }
}
