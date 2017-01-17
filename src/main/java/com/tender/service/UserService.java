package com.tender.service;

import com.tender.entity.Supplier;

/**
 * Created by Денис on 11.01.2017.
 */
public interface UserService {
    String getRoleFromSession(Supplier supplier);

    int registration(Supplier supplier);

}
