package com.hidrip.dao;

import java.util.List;

import com.hidrip.model.Product;
import com.hidrip.model.ProductSize;

public interface ProductDAO {

    /* =========================================
       ADD PRODUCT
    ========================================= */

    boolean addProduct(Product product);
       


    /* =========================================
       GET ALL PRODUCTS
    ========================================= */

    List<Product> getAllProducts();



    /* =========================================
       GET PRODUCT BY ID
    ========================================= */

    Product getProductById(int productId);



    /* =========================================
       GET PRODUCTS BY CATEGORY
    ========================================= */

    List<Product> getProductsByCategory(int categoryId);



    /* =========================================
       SEARCH PRODUCTS
    ========================================= */

    List<Product> searchProducts(String keyword);



    /* =========================================
       FILTER PRODUCTS
    ========================================= */

    List<Product> filterProducts(String category,
                                 String brand);



    /* =========================================
       UPDATE PRODUCT
    ========================================= */

    boolean updateProduct(Product product);



    /* =========================================
       DELETE PRODUCT
    ========================================= */

    boolean deleteProduct(int productId);



    /* =========================================
       GET PRODUCT SIZES
    ========================================= */

    List<ProductSize> getSizesByProductId(int productId);

}