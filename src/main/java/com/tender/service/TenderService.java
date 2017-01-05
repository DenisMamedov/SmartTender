package com.tender.service;

import com.tender.connection.DataSource;
import com.tender.dao.TenderDAO;
import com.tender.dao.factory.MySqlDAOFactory;
import com.tender.entity.Tender;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by Денис on 02.01.2017.
 */
public class TenderService {

    private Connection connection = DataSource.getConnection();

    public LinkedList showTenders(){
        TenderDAO tenderDAO = new MySqlDAOFactory(connection).getTenderDAO();
        LinkedList<Tender> tenders = tenderDAO.selectTender();
        DataSource.returnConnection(connection);
        return tenders;
    }
}
