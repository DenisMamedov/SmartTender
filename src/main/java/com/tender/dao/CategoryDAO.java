package com.tender.dao;

import com.tender.entity.Category;

import java.util.ArrayList;

/**
 * Created by Денис on 03.01.2017.
 */
public interface CategoryDAO {

    Category findCategory(int id);

    ArrayList<Category> selectCategory();
}
