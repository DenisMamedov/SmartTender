package com.tender.entity.builder;

import com.tender.entity.Category;

/**
 * Created by Денис on 04.01.2017.
 */
public class CategoryBuilder {

    private String categoryName;

    public CategoryBuilder setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public Category createCategory() {
        return new Category(categoryName);
    }
}
