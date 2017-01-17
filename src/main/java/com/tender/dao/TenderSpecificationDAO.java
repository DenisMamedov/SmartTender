package com.tender.dao;

import com.tender.entity.TenderSpecification;

import java.util.LinkedList;

/**
 * Created by Денис on 13.01.2017.
 */
public interface TenderSpecificationDAO {

    LinkedList<TenderSpecification> selectTenderSpecificationByTenderId(int id);
}
