package com.tender.dao;

import com.tender.entity.Tender;

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
}
