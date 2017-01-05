package com.tender.dao.impl;

import com.tender.dao.CategoryDAO;
import com.tender.entity.Category;
import com.tender.entity.builder.CategoryBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Денис on 03.01.2017.
 */
public class MySqlCategoryDAO implements CategoryDAO {

    public static final String SELECT_ALL_CATEGORIES = "SELECT * FROM category";
    public static final String FIND_CATEGORY = "SELECT * FROM category WHERE id = ?";

    private Connection connection;

    public MySqlCategoryDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public int insertCategory(Category tender) {
        return 0;
    }

    @Override
    public boolean deleteCategory(int id) {
        return false;
    }

    @Override
    public Category findCategory(int id) {
        Category category = null;
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_CATEGORY);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            result.next();
            category = new CategoryBuilder()
                    .setCategoryName(result.getString("category_name"))
                    .createCategory();
            category.setId(result.getInt("id"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return category;
    }

    @Override
    public boolean updateCategory(Category tender) {
        return false;
    }

    @Override
    public ArrayList<Category> selectCategory() {

        ArrayList<Category> list = new  ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CATEGORIES);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Category category = new CategoryBuilder()
                        .setCategoryName(result.getString("category_name"))
                        .createCategory();
                category.setId(result.getInt("id"));
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
