package com.hidrip.dao;

import java.util.List;
import com.hidrip.model.Category;

public interface CategoryDAO {

    // Add new category
    boolean addCategory(Category category);

    // Get all categories
    List<Category> getAllCategories();

    // Get category by ID
    Category getCategoryById(int categoryId);

    // Update category
    boolean updateCategory(Category category);

    // Delete category
    boolean deleteCategory(int categoryId);

    // Active categories (for UI filtering)
    List<Category> getActiveCategories();
}