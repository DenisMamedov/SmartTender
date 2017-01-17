package com.tender.dao;

import com.tender.entity.Supplier;

import java.util.ArrayList;

/**
 * Created by Денис on 10.01.2017.
 */
public interface SupplierDAO {

    int insertSupplier(Supplier supplier);
    boolean deleteSupplier(int id);
    Supplier findSupplierByLoginAndPassword(String login, String password);
    boolean updateSupplier(Supplier supplier);
    ArrayList<Supplier> selectSupplier();
}
