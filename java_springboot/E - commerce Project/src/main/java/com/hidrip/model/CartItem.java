package com.hidrip.model;

public class CartItem {

    private int cartItemId;

    private int cartId;

    private int productId;

    private String sizeLabel;

    private int quantity;

    private double unitPrice;

    private Product product;



    // =========================================
    // DEFAULT CONSTRUCTOR
    // =========================================

    public CartItem() {

    }



    // =========================================
    // PARAMETERIZED CONSTRUCTOR
    // =========================================

    public CartItem(Product product,
                    int quantity) {

        this.product = product;

        this.quantity = quantity;
    }



    // =========================================
    // GETTERS & SETTERS
    // =========================================

    public int getCartItemId() {

        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {

        this.cartItemId = cartItemId;
    }



    public int getCartId() {

        return cartId;
    }

    public void setCartId(int cartId) {

        this.cartId = cartId;
    }



    public int getProductId() {

        return productId;
    }

    public void setProductId(int productId) {

        this.productId = productId;
    }



    public String getSizeLabel() {

        return sizeLabel;
    }

    public void setSizeLabel(String sizeLabel) {

        this.sizeLabel = sizeLabel;
    }



    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }



    public double getUnitPrice() {

        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {

        this.unitPrice = unitPrice;
    }



    public Product getProduct() {

        return product;
    }

    public void setProduct(Product product) {

        this.product = product;
    }



    // =========================================
    // TOTAL PRICE
    // =========================================

    public double getTotalPrice() {

        double price =
                unitPrice;

        if(product != null) {

            price =
            product.getPrice();

            double discount =
                    product.getDiscountPercent();

            price =
            price - (price * discount / 100);
        }

        return price * quantity;
    }

}