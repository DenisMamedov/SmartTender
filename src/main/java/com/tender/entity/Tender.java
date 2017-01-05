package com.tender.entity;

import java.util.Date;
import java.util.Objects;

/**
 * Created by Денис on 24.12.2016.
 */
public class Tender extends AbstractEntity{

    private String tenderName;
    private Company company;
    private Category category;
    private Date endDate;
    private Status status;

    public Tender(String tenderName, Company company, Category category, Date endDate, Status status){
        this.tenderName = tenderName;
        this.company = company;
        this.category = category;
        this.endDate = endDate;
        this.status = status;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tender that = (Tender) o;
        return  Objects.equals(id, that.id) &&
                Objects.equals(tenderName, that.tenderName) &&
                Objects.equals(company, that.company) &&
                Objects.equals(category, that.category) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenderName, company, category, endDate, status);
    }

    @Override
    public String toString() {
        return "Tender{" +
                "id=" + id +
                ", tenderName='" + tenderName + '\'' +
                ", company=" + company +
                ", category=" + category +
                ", endDate=" + endDate +
                ", status=" + status +
                '}';
    }
}
