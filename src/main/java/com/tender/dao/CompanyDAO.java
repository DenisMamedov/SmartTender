package com.tender.dao;

import com.tender.entity.Company;

import java.util.List;

/**
 * Created by Денис on 03.01.2017.
 */
public interface CompanyDAO {

    int insertCompany(Company company);
    boolean deleteCompany(int id);
    Company findCompany(int id);
    boolean updateCompany(Company company);
    List selectCompany();
}
