package com.tender.dao;

import com.tender.entity.TenderSpecification;

import java.util.LinkedList;

/**
 * Created by Денис on 13.01.2017.
 */
public interface TenderSpecificationDAO {

    int insertTenderSpecification(TenderSpecification tenderSpec);
    boolean deleteTenderSpecification(int id);
    TenderSpecification findTenderSpecification(int id);
    boolean updateTenderSpecification(TenderSpecification tenderSpec);
    LinkedList<TenderSpecification> selectTenderSpecificationByTenderId(int id);
}
