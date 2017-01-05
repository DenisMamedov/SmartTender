package com.tender.main;

import com.tender.connection.DataSource;
import com.tender.dao.TenderDAO;
import com.tender.dao.factory.MySqlDAOFactory;
import com.tender.entity.Tender;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        Connection connection = DataSource.getConnection();

        TenderDAO tenderDAO = new MySqlDAOFactory(connection).getTenderDAO();

        for (Tender tender : tenderDAO.selectTender()){
            System.out.println(tender);
        }

        DataSource.returnConnection(connection);


}
}
