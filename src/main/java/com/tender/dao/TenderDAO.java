package com.tender.dao;

import com.tender.entity.Tender;

import java.sql.ResultSet;
import java.util.LinkedList;

/**
 * Created by Денис on 24.12.2016.
 */
public interface TenderDAO {

    int insertTender(Tender tender);
    boolean deleteTender(int id);
    Tender findTender(int id);
    boolean updateTender(Tender tender);
    LinkedList<Tender> selectTender();
    LinkedList<Tender> searchTenderByContext(String context);
    LinkedList<Tender> selectTenderBySupplierId(int id, String status);
    Tender createEntity(ResultSet result);
}
