package com.tender.entity;

import java.util.Objects;

/**
 * Created by Денис on 03.01.2017.
 */
public class Company extends AbstractEntity {

    private String companyName;
    private String address;
    private String contactName;
    private String contactPhone;

    public Company(String companyName, String address, String contactName, String contactPhone) {
        this.companyName = companyName;
        this.address = address;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) &&
                Objects.equals(companyName, company.companyName) &&
                Objects.equals(address, company.address) &&
                Objects.equals(contactName, company.contactName) &&
                Objects.equals(contactPhone, company.contactPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, address, contactName, contactPhone);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                '}';
    }
}
