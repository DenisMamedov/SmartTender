package com.tender.dao;

import com.tender.entity.Offer;

import java.util.Map;

/**
 * Created by Денис on 13.01.2017.
 */
public interface OfferDAO {

    int insertOffer(Map<Integer, Offer> offerMap);

    int updateOffer(Map<Integer, Offer> offerMap, int supplier_id, int tender_id);

    Map<Integer, Offer> selectOfferByTenderIdAndSupplierId(int tenderId, int supplierId);

    Map<Integer, Double> selectMinimalPrices(int tenderId);
}
