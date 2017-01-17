package com.tender.dao;

import com.tender.entity.Tender;

import java.sql.ResultSet;
import java.util.LinkedList;

/**
 * Created by Денис on 24.12.2016.
 */
public interface TenderDAO {

    Tender findTender(int id);

    LinkedList<Tender> selectTender();

    LinkedList<Tender> searchTenderByContext(String context);

    LinkedList<Tender> selectTenderBySupplierId(int id, String status);

    Tender createEntity(ResultSet result);
}
