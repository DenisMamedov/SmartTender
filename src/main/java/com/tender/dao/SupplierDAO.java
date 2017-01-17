package com.tender.dao;

import com.tender.entity.Supplier;

/**
 * Created by Денис on 10.01.2017.
 */
public interface SupplierDAO {

    int insertSupplier(Supplier supplier);

    Supplier findSupplierByLoginAndPassword(String login, String password);

}
