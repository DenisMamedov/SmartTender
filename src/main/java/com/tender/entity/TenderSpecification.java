package com.tender.entity;

import java.util.Objects;

/**
 * Created by Денис on 04.01.2017.
 */
public class TenderSpecification extends AbstractEntity {

    private Tender tender;
    private Integer lotId;
    private String specification;
    private Integer quantity;
    private String information;

    public TenderSpecification(Tender tender, Integer lotId, String specification, Integer quantity, String information){
        this.tender = tender;
        this.lotId = lotId;
        this.specification = specification;
        this.quantity = quantity;
        this.information = information;
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

    public String getSpecification(){
        return  specification;
    }

    public void setSpecification(String specification){
        this.specification = specification;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TenderSpecification that = (TenderSpecification) o;
        return Objects.equals(tender, that.tender) &&
                Objects.equals(lotId, that.lotId) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(information, that.information);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tender, lotId, quantity, information);
    }
}
