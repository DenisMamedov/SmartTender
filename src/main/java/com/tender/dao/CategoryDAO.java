package com.tender.dao;

import com.tender.entity.Category;

import java.util.ArrayList;

/**
 * Created by Денис on 03.01.2017.
 */
public interface CategoryDAO {

    int insertCategory(Category category);
    boolean deleteCategory(int id);
    Category findCategory(int id);
    boolean updateCategory(Category category);
    ArrayList<Category> selectCategory();
}
