package com.tender.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Денис on 04.01.2017.
 */
public class Offer extends AbstractEntity {

    private Supplier supplier;
    private Tender tender;
    private Integer lotId;
    private Double price;
    private Integer termOfDelivery;
    private String conditionOfPayment;
    private String additionalInfo;
    private Timestamp timeset;
    private String conditionOfDelivery;
    private Double guarantee;

    public Offer(Supplier supplier, Tender tender, Integer lotId, Double price, Integer termOfDelivery,
                 String conditionOfPayment, String additionalInfo, Timestamp timeset, String conditionOfDelivery,
                 Double guarantee) {
        this.supplier = supplier;
        this.tender = tender;
        this.lotId = lotId;
        this.price = price;
        this.termOfDelivery = termOfDelivery;
        this.conditionOfPayment = conditionOfPayment;
        this.additionalInfo = additionalInfo;
        this.timeset = timeset;
        this.conditionOfDelivery = conditionOfDelivery;
        this.guarantee = guarantee;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Tender getTender() {
        return tender;
    }

    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public Integer getLotId() {
        return lotId;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTermOfDelivery() {
        return termOfDelivery;
    }

    public void setTermOfDelivery(Integer termOfDelivery) {
        this.termOfDelivery = termOfDelivery;
    }

    public String getConditionOfPayment() {
        return conditionOfPayment;
    }

    public void setConditionOfPayment(String conditionOfPayment) {
        this.conditionOfPayment = conditionOfPayment;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Timestamp getTimeset() {
        return timeset;
    }

    public void setTimeset(Timestamp timeset) {
        this.timeset = timeset;
    }

    public String getConditionOfDelivery() {
        return conditionOfDelivery;
    }

    public void setConditionOfDelivery(String conditionOfDelivery) {
        this.conditionOfDelivery = conditionOfDelivery;
    }

    public Double getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(Double guarantee) {
        this.guarantee = guarantee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Objects.equals(supplier, offer.supplier) &&
                Objects.equals(tender, offer.tender) &&
                Objects.equals(lotId, offer.lotId) &&
                Objects.equals(price, offer.price) &&
                Objects.equals(termOfDelivery, offer.termOfDelivery) &&
                Objects.equals(conditionOfPayment, offer.conditionOfPayment) &&
                Objects.equals(additionalInfo, offer.additionalInfo) &&
                Objects.equals(timeset, offer.timeset) &&
                Objects.equals(conditionOfDelivery, offer.conditionOfDelivery) &&
                Objects.equals(guarantee, offer.guarantee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplier, tender, lotId, price, termOfDelivery, conditionOfPayment, additionalInfo, timeset, conditionOfDelivery, guarantee);
    }
}
