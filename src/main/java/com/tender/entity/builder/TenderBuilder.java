package com.tender.entity.builder;

import com.tender.entity.Category;
import com.tender.entity.Company;
import com.tender.entity.Status;
import com.tender.entity.Tender;

import java.util.Date;

/**
 * Created by Денис on 04.01.2017.
 */
public class TenderBuilder {

    private String tenderName;
    private Company company;
    private Category category;
    private Date endDate;
    private Status status;

    public TenderBuilder setTenderName(String tenderName) {
        this.tenderName = tenderName;
        return this;
    }

    public TenderBuilder setCompany(Company company) {
        this.company = company;
        return this;
    }

    public TenderBuilder setCategory(Category category) {
        this.category = category;
        return this;
    }

    public TenderBuilder setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public TenderBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Tender createTender(){
        return new Tender(tenderName, company, category, endDate, status);
    }
}
