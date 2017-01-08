package com.tender.service;

import com.tender.entity.Tender;

import java.util.LinkedList;

/**
 * Created by Денис on 06.01.2017.
 */
public interface TenderService {
    LinkedList<Tender> showTenders();
}
