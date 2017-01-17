package com.tender.entity;

import java.util.Objects;

/**
 * Created by Денис on 04.01.2017.
 */
public class Supplier extends AbstractEntity {

    private String supplierName;
    private Integer okpo;
    private String address;
    private String contactName;
    private String contactPhone;
    private String email;
    private String password;
    private String role;

    public Supplier(String supplierName, Integer okpo, String address, String contactName,
                    String contactPhone, String email, String password, String role){
        this.supplierName = supplierName;
        this.okpo = okpo;
        this.address = address;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getOkpo() {
        return okpo;
    }

    public void setOkpo(Integer okpo) {
        this.okpo = okpo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(supplierName, supplier.supplierName) &&
                Objects.equals(okpo, supplier.okpo) &&
                Objects.equals(address, supplier.address) &&
                Objects.equals(contactName, supplier.contactName) &&
                Objects.equals(contactPhone, supplier.contactPhone) &&
                Objects.equals(email, supplier.email) &&
                Objects.equals(password, supplier.password) &&
                Objects.equals(role, supplier.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierName, okpo, address, contactName, contactPhone, email, password, role);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierName='" + supplierName + '\'' +
                ", okpo=" + okpo +
                ", address='" + address + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
