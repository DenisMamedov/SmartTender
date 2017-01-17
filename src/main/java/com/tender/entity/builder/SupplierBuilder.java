package com.tender.entity.builder;

import com.tender.entity.Supplier;

/**
 * Created by Денис on 04.01.2017.
 */
public class SupplierBuilder {

    private String supplierName;
    private Integer okpo;
    private String address;
    private String contactName;
    private String contactPhone;
    private String email;
    private String password;
    private String role;

    public SupplierBuilder setSupplierName(String supplierName) {
        this.supplierName = supplierName;
        return this;
    }

    public SupplierBuilder setOkpo(Integer okpo) {
        this.okpo = okpo;
        return this;
    }

    public SupplierBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public SupplierBuilder setContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public SupplierBuilder setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
        return this;
    }

    public SupplierBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public SupplierBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public SupplierBuilder setRole(String role) {
        this.role = role;
        return this;
    }

    public Supplier createSupplier() {
        return new Supplier(supplierName, okpo, address, contactName, contactPhone, email, password, role);
    }
}
