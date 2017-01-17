package com.tender.service;

import com.tender.dao.OfferDAO;
import com.tender.dao.TenderDAO;
import com.tender.dao.TenderSpecificationDAO;
import com.tender.dao.factory.MySqlDAOFactory;
import com.tender.entity.Offer;
import com.tender.entity.Supplier;
import com.tender.entity.Tender;
import com.tender.entity.TenderSpecification;

import java.sql.Connection;
import java.util.*;

/**
 * Created by Денис on 02.01.2017.
 */
public class TenderServiceImpl implements TenderService {

    private Connection connection;

    public TenderServiceImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public LinkedList<Tender> showTenders() {

        TenderDAO tenderDAO = new MySqlDAOFactory(connection).getTenderDAO();
        return tenderDAO.selectTender();
    }

    @Override
    public Set<String> getAllCompany(LinkedList<Tender> tenders) {

        Set<String> companyNames = new LinkedHashSet<>();

        for (Tender tender : tenders) {
            companyNames.add(tender.getCompany().getCompanyName());
        }

        return companyNames;
    }

    @Override
    public Set<String> getAllCategory(LinkedList<Tender> tenders) {

        Set<String> categoryNames = new LinkedHashSet<>();

        for (Tender tender : tenders) {
            categoryNames.add(tender.getCategory().getCategoryName());
        }

        return categoryNames;
    }

    @Override
    public LinkedList<Tender> searchTenderByContext(String context) {

        TenderDAO tenderDAO = new MySqlDAOFactory(connection).getTenderDAO();

        return tenderDAO.searchTenderByContext(context);
    }

    @Override
    public LinkedList<Tender> searchTenderByCategoryName(String name, LinkedList<Tender> list) {

        Iterator<Tender> iterator = list.iterator();

        while (iterator.hasNext()) {
            String categoryName = iterator.next().getCategory().getCategoryName();
            if (!categoryName.equals(name))
                iterator.remove();
        }

        return list;
    }

    @Override
    public LinkedList<Tender> searchTenderByCompanyName(String name, LinkedList<Tender> list) {

        Iterator<Tender> iterator = list.iterator();

        while (iterator.hasNext()) {
            String categoryName = iterator.next().getCompany().getCompanyName();
            if (!categoryName.equals(name))
                iterator.remove();
        }

        return list;
    }

    @Override
    public LinkedList<TenderSpecification> showTenderDetails(int id) {

        TenderSpecificationDAO tenderSpecificationDAO = new MySqlDAOFactory(connection).getTenderSpecificationDAO();

        return tenderSpecificationDAO.selectTenderSpecificationByTenderId(id);
    }

    @Override
    public int saveOffer(Map<Integer, Offer> offerMap) {

        int result;
        if (offerMap.size() == 0) result = 0;
        else{
            OfferDAO offerDAO = new MySqlDAOFactory(connection).getOfferDAO();
            result = offerDAO.insertOffer(offerMap);
        }

        return result;
    }

    @Override
    public int updateOffer(Map<Integer, Offer> offerMap, int supplierId, int tenderId) {

        int result = 0;
        if (offerMap.size()==0) result=0;
        else{
        OfferDAO offerDAO = new MySqlDAOFactory(connection).getOfferDAO();

        Map<Integer, Offer> existingOffer = offerDAO.selectOfferByTenderIdAndSupplierId(tenderId, supplierId);
        Map<Integer, Offer> listToUpdate = new HashMap<>();
        Map<Integer, Offer> listToSave = new HashMap<>();

            for(Map.Entry firstEntry : offerMap.entrySet()){
                Integer key = (Integer)firstEntry.getKey();
                Offer value = (Offer)firstEntry.getValue();
//                for (Map.Entry secondEntry : existingOffer.entrySet()){
//                    Integer secondKey = (Integer)secondEntry.getKey();
                    if (existingOffer.containsKey(key)){
                        listToUpdate.put(key, value);
                    }
                    else {
                        listToSave.put(key, value);
                    }
            }

        if (listToUpdate.size() > 0) result = offerDAO.updateOffer(listToUpdate, supplierId, tenderId);
        if (listToSave.size() > 0) result = offerDAO.insertOffer(listToSave);
        }

        return result;
    }

    @Override
    public LinkedList<Tender> getHistory(Supplier supplier, String status) {

        TenderDAO tenderDAO = new MySqlDAOFactory(connection).getTenderDAO();

        return tenderDAO.selectTenderBySupplierId(supplier.getId(), status);
    }

    @Override
    public Map<Integer, Offer> showTenderDetailsFromHistory(int tenderId, Supplier supplier) {

        int supplierId = supplier.getId();
        OfferDAO offerDAO = new MySqlDAOFactory(connection).getOfferDAO();

        return offerDAO.selectOfferByTenderIdAndSupplierId(tenderId, supplierId);
    }

    @Override
    public Map<Integer, Double> getBestPrices(int tenderId) {

        OfferDAO offerDAO = new MySqlDAOFactory(connection).getOfferDAO();

        return offerDAO.selectMinimalPrices(tenderId);
    }
}
