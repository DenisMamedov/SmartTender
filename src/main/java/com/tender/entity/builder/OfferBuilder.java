package com.tender.entity.builder;

import com.tender.entity.Offer;
import com.tender.entity.Supplier;
import com.tender.entity.Tender;

import java.sql.Timestamp;

/**
 * Created by Денис on 04.01.2017.
 */
public class OfferBuilder {

    private Supplier supplier;
    private Tender tender;
    private Integer lotId;
    private Double price;
    private Integer termOfDelivery;
    private String conditionOfPayment;
    private String additionalInfo;
    private Timestamp timeset;
    private String conditionOfDelivery;
    private Integer guarantee;

    public OfferBuilder setSupplier(Supplier supplier) {
        this.supplier = supplier;
        return this;
    }

    public OfferBuilder setTender(Tender tender) {
        this.tender = tender;
        return this;
    }

    public OfferBuilder setLotId(Integer lotId) {
        this.lotId = lotId;
        return this;
    }

    public OfferBuilder setPrice(Double price) {
        this.price = price;
        return this;
    }

    public OfferBuilder setTermOfDelivery(Integer termOfDelivery) {
        this.termOfDelivery = termOfDelivery;
        return this;
    }

    public OfferBuilder setConditionOfPayment(String conditionOfPayment) {
        this.conditionOfPayment = conditionOfPayment;
        return this;
    }

    public OfferBuilder setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    public OfferBuilder setTimeset(Timestamp timeset) {
        this.timeset = timeset;
        return this;
    }

    public OfferBuilder setConditionOfDelivery(String conditionOfDelivery) {
        this.conditionOfDelivery = conditionOfDelivery;
        return this;
    }

    public OfferBuilder setGuarantee(Integer guarantee) {
        this.guarantee = guarantee;
        return this;
    }

    public Offer createOffer(){
        return new Offer(supplier, tender, lotId, price, termOfDelivery, conditionOfPayment, additionalInfo, timeset, conditionOfDelivery, guarantee);
    }
}
