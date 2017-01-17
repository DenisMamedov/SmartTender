package com.tender.entity.builder;

import com.tender.entity.Tender;
import com.tender.entity.TenderSpecification;

/**
 * Created by Денис on 04.01.2017.
 */
public class TenderSpecificationBuilder {

    private Tender tender;
    private Integer lotId;
    private String specification;
    private Integer quantity;
    private String information;

    public TenderSpecificationBuilder setTender(Tender tender) {
        this.tender = tender;
        return this;
    }

    public TenderSpecificationBuilder setSpecification(String specification) {
        this.specification = specification;
        return this;
    }

    public TenderSpecificationBuilder setLotId(Integer lotId) {
        this.lotId = lotId;
        return this;
    }

    public TenderSpecificationBuilder setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public TenderSpecificationBuilder setInformation(String information) {
        this.information = information;
        return this;
    }

    public TenderSpecification createTenderSpecification(){
        return new TenderSpecification(tender, lotId, specification, quantity, information);
    }
}
