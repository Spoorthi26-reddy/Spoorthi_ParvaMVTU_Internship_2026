package com.hidrip.dao;

import java.util.List;
import com.hidrip.model.ProductSize;

public interface ProductSizeDAO {

    // Add size for product
    boolean addProductSize(ProductSize productSize);

    // Get all sizes for a product
    List<ProductSize> getSizesByProductId(int productId);

    // Get specific size (e.g., M, L)
    ProductSize getProductSize(int productId, String sizeLabel);

    // Update stock quantity
    boolean updateStock(int productSizeId, int quantity);

    // Delete size
    boolean deleteProductSize(int productSizeId);
}