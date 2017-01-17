package com.tender.service;

import com.tender.entity.Offer;
import com.tender.entity.Supplier;
import com.tender.entity.Tender;
import com.tender.entity.TenderSpecification;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Created by Денис on 06.01.2017.
 */
public interface TenderService {
    LinkedList<Tender> showTenders();

    Set<String> getAllCompany(LinkedList<Tender> tenders);

    Set<String> getAllCategory(LinkedList<Tender> tenders);

    LinkedList<Tender> searchTenderByContext(String context);

    LinkedList<TenderSpecification> showTenderDetails(int id);

    int saveOffer(Map<Integer, Offer> offerMap);

    int updateOffer(Map<Integer, Offer> offerList, int supplierId, int tenderId);

    LinkedList<Tender> getHistory(Supplier supplier, String status);

    Map<Integer, Offer> showTenderDetailsFromHistory(int tenderId, Supplier supplier);

    Map<Integer, Double> getBestPrices(int tenderId);

    LinkedList<Tender> searchTenderByCategoryName(String name, LinkedList<Tender> list);

    LinkedList<Tender> searchTenderByCompanyName(String name, LinkedList<Tender> list);
}
