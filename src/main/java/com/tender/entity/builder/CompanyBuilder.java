package com.tender.entity.builder;

import com.tender.entity.Company;

/**
 * Created by Денис on 04.01.2017.
 */
public class CompanyBuilder {

    private String companyName;
    private String address;
    private String contactName;
    private String contactPhone;

    public CompanyBuilder setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public CompanyBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public CompanyBuilder setContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public CompanyBuilder setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
        return this;
    }

    public Company createCompany(){
        return new Company(companyName, address, contactName, contactPhone);
    }
}
