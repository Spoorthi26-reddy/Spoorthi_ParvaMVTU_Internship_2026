package com.hidrip.model;

public class Product {

    /* =========================================
       PRODUCT FIELDS
    ========================================= */

    private int productId;

    private int categoryId;

    private String productName;

    private String description;

    private String brand;

    private double price;

    private double discountPercent;

    private String imageUrl;

    private boolean isActive;



    /* =========================================
       DEFAULT CONSTRUCTOR
    ========================================= */

    public Product() {

    }



    /* =========================================
       PARAMETERIZED CONSTRUCTOR
    ========================================= */

    public Product(int productId,
                   int categoryId,
                   String productName,
                   String description,
                   String brand,
                   double price,
                   double discountPercent,
                   String imageUrl,
                   boolean isActive) {

        this.productId = productId;

        this.categoryId = categoryId;

        this.productName = productName;

        this.description = description;

        this.brand = brand;

        this.price = price;

        this.discountPercent = discountPercent;

        this.imageUrl = imageUrl;

        this.isActive = isActive;
    }



    /* =========================================
       GET PRODUCT ID
    ========================================= */

    public int getProductId() {

        return productId;
    }



    /* =========================================
       SET PRODUCT ID
    ========================================= */

    public void setProductId(int productId) {

        this.productId = productId;
    }



    /* =========================================
       GET CATEGORY ID
    ========================================= */

    public int getCategoryId() {

        return categoryId;
    }



    /* =========================================
       SET CATEGORY ID
    ========================================= */

    public void setCategoryId(int categoryId) {

        this.categoryId = categoryId;
    }



    /* =========================================
       GET PRODUCT NAME
    ========================================= */

    public String getProductName() {

        return productName;
    }



    /* =========================================
       SET PRODUCT NAME
    ========================================= */

    public void setProductName(String productName) {

        this.productName = productName;
    }



    /* =========================================
       GET DESCRIPTION
    ========================================= */

    public String getDescription() {

        return description;
    }



    /* =========================================
       SET DESCRIPTION
    ========================================= */

    public void setDescription(String description) {

        this.description = description;
    }



    /* =========================================
       GET BRAND
    ========================================= */

    public String getBrand() {

        return brand;
    }



    /* =========================================
       SET BRAND
    ========================================= */

    public void setBrand(String brand) {

        this.brand = brand;
    }



    /* =========================================
       GET PRICE
    ========================================= */

    public double getPrice() {

        return price;
    }



    /* =========================================
       SET PRICE
    ========================================= */

    public void setPrice(double price) {

        this.price = price;
    }



    /* =========================================
       GET DISCOUNT PERCENT
    ========================================= */

    public double getDiscountPercent() {

        return discountPercent;
    }



    /* =========================================
       SET DISCOUNT PERCENT
    ========================================= */

    public void setDiscountPercent(double discountPercent) {

        this.discountPercent = discountPercent;
    }



    /* =========================================
       GET IMAGE URL
    ========================================= */

    public String getImageUrl() {

        return imageUrl;
    }



    /* =========================================
       SET IMAGE URL
    ========================================= */

    public void setImageUrl(String imageUrl) {

        this.imageUrl = imageUrl;
    }



    /* =========================================
       CHECK ACTIVE STATUS
    ========================================= */

    public boolean isActive() {

        return isActive;
    }



    /* =========================================
       SET ACTIVE STATUS
    ========================================= */

    public void setActive(boolean isActive) {

        this.isActive = isActive;
    }

}