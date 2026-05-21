package com.hidrip.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.hidrip.dao.ProductDAO;
import com.hidrip.model.Product;
import com.hidrip.model.ProductSize;
import com.hidrip.util.DBConnection;

public class ProductDAOImpl implements ProductDAO {

    /* =========================================
       ADD PRODUCT
    ========================================= */

    @Override
    public boolean addProduct(Product product) {

        boolean status = false;

        String sql =
                "INSERT INTO products " +
                "(category_id, product_name, description, " +
                "brand, price, discount_percent, " +
                "image_url, is_active) " +
                "VALUES (?,?,?,?,?,?,?,?)";

        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql)) {

            ps.setInt(1,
                    product.getCategoryId());

            ps.setString(2,
                    product.getProductName());

            ps.setString(3,
                    product.getDescription());

            ps.setString(4,
                    product.getBrand());

            ps.setDouble(5,
                    product.getPrice());

            ps.setDouble(6,
                    product.getDiscountPercent());

            ps.setString(7,
                    product.getImageUrl());

            ps.setBoolean(8,
                    product.isActive());

            status =
            ps.executeUpdate() > 0;
        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return status;
    }



    /* =========================================
       GET ALL PRODUCTS
    ========================================= */

    @Override
    public List<Product> getAllProducts() {

        List<Product> products =
                new ArrayList<>();

        String sql =
                "SELECT * FROM products " +
                "WHERE is_active=1";

        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql);

            ResultSet rs =
            ps.executeQuery()) {

            while(rs.next()) {

                products.add(
                        mapProduct(rs));
            }

        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return products;
    }



    /* =========================================
       GET PRODUCT BY ID
    ========================================= */

    @Override
    public Product getProductById(int productId) {

        Product product = null;

        String sql =
                "SELECT * FROM products " +
                "WHERE product_id=?";

        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql)) {

            ps.setInt(1,
                    productId);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                product =
                mapProduct(rs);
            }

        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return product;
    }



    /* =========================================
       GET PRODUCTS BY CATEGORY
    ========================================= */

    @Override
    public List<Product> getProductsByCategory(
            int categoryId) {

        List<Product> products =
                new ArrayList<>();

        String sql =
                "SELECT * FROM products " +
                "WHERE category_id=?";

        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql)) {

            ps.setInt(1,
                    categoryId);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                products.add(
                        mapProduct(rs));
            }

        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return products;
    }



    /* =========================================
       SEARCH PRODUCTS
    ========================================= */

    @Override
    public List<Product> searchProducts(
            String keyword) {

        List<Product> products =
                new ArrayList<>();

        String sql =
        "SELECT * FROM products "
        + "WHERE product_name LIKE ? "
        + "OR brand LIKE ? "
        + "OR description LIKE ?";

        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql)) {

            String search =
                    "%" + keyword + "%";

            ps.setString(1,
                    search);

            ps.setString(2,
                    search);

            ps.setString(3,
                    search);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                products.add(
                        mapProduct(rs));
            }

        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return products;
    }



    /* =========================================
       FILTER PRODUCTS
    ========================================= */

    @Override
    public List<Product> filterProducts(
            String category,
            String brand) {

        List<Product> products =
                new ArrayList<>();

        String sql =
        "SELECT * FROM products "
        + "WHERE brand LIKE ?";

        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql)) {

            ps.setString(1,
                    "%" + brand + "%");

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                products.add(
                        mapProduct(rs));
            }

        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return products;
    }



    /* =========================================
       UPDATE PRODUCT
    ========================================= */

    @Override
    public boolean updateProduct(Product product) {

        boolean status = false;

        String sql =
        "UPDATE products SET "
        + "category_id=?, "
        + "product_name=?, "
        + "description=?, "
        + "brand=?, "
        + "price=?, "
        + "discount_percent=?, "
        + "image_url=?, "
        + "is_active=? "
        + "WHERE product_id=?";

        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql)) {

            ps.setInt(1,
                    product.getCategoryId());

            ps.setString(2,
                    product.getProductName());

            ps.setString(3,
                    product.getDescription());

            ps.setString(4,
                    product.getBrand());

            ps.setDouble(5,
                    product.getPrice());

            ps.setDouble(6,
                    product.getDiscountPercent());

            ps.setString(7,
                    product.getImageUrl());

            ps.setBoolean(8,
                    product.isActive());

            ps.setInt(9,
                    product.getProductId());

            status =
            ps.executeUpdate() > 0;
        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return status;
    }
    



    /* =========================================
       DELETE PRODUCT
    ========================================= */
       @Override
    public boolean deleteProduct(
            int productId) {
    	   System.out.println(
    			   "DELETE METHOD CALLED");
        boolean status = false;



        String deleteCartItems =
        "DELETE FROM cart_items "
        + "WHERE product_id=?";



        String deleteWishlist =
        "DELETE FROM wishlist "
        + "WHERE product_id=?";



        String deleteOrderItems =
        "DELETE FROM order_items "
        + "WHERE product_id=?";

        String deleteProductSizes =
        		"DELETE FROM product_sizes "
        		+ "WHERE product_id=?";


        String deleteProduct =
        "DELETE FROM products "
        + "WHERE product_id=?";



        try(Connection con =
                DBConnection.getConnection()) {

        	


            // =========================================
            // DELETE CART ITEMS
            // =========================================

            PreparedStatement ps1 =
            con.prepareStatement(
                    deleteCartItems);

            ps1.setInt(1,
                    productId);

            ps1.executeUpdate();




            // =========================================
            // DELETE WISHLIST
            // =========================================

            PreparedStatement ps2 =
            con.prepareStatement(
                    deleteWishlist);

            ps2.setInt(1,
                    productId);

            ps2.executeUpdate();




            // =========================================
            // DELETE ORDER ITEMS
            // =========================================

            PreparedStatement ps3 =
            con.prepareStatement(
                    deleteOrderItems);

            ps3.setInt(1,
                    productId);

            ps3.executeUpdate();



            /* =========================================
            DELETE PRODUCT SIZES
         ========================================= */

         PreparedStatement ps4 =
         con.prepareStatement(
                 deleteProductSizes);

         ps4.setInt(1,
                 productId);

         ps4.executeUpdate();
         
         /* =========================================
         DELETE PRODUCT
      ========================================= */

      PreparedStatement ps5 =
      con.prepareStatement(
              deleteProduct);

      ps5.setInt(1,
              productId);

      status =
      ps5.executeUpdate() > 0;
        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return status;
    }

    /* =========================================
       GET PRODUCT SIZES
    ========================================= */

    @Override
    public List<ProductSize> getSizesByProductId(
            int productId) {

        List<ProductSize> sizes =
                new ArrayList<>();

        String sql =
                "SELECT * FROM product_sizes " +
                "WHERE product_id=?";

        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql)) {

            ps.setInt(1,
                    productId);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                ProductSize size =
                        new ProductSize();

                size.setProductSizeId(
                        rs.getInt(
                                "product_size_id"));

                size.setProductId(
                        rs.getInt(
                                "product_id"));

                size.setSizeLabel(
                        rs.getString(
                                "size_label"));

                size.setStockQuantity(
                        rs.getInt(
                                "stock_quantity"));

                sizes.add(size);
            }

        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return sizes;
    }



    /* =========================================
       MAP PRODUCT
    ========================================= */

    private Product mapProduct(ResultSet rs)
            throws Exception {

        Product product =
                new Product();

        product.setProductId(
                rs.getInt(
                        "product_id"));

        product.setCategoryId(
                rs.getInt(
                        "category_id"));

        product.setProductName(
                rs.getString(
                        "product_name"));

        product.setDescription(
                rs.getString(
                        "description"));

        product.setBrand(
                rs.getString(
                        "brand"));

        product.setPrice(
                rs.getDouble(
                        "price"));

        product.setDiscountPercent(
                rs.getDouble(
                        "discount_percent"));

        product.setImageUrl(
                rs.getString(
                        "image_url"));

        product.setActive(
                rs.getBoolean(
                        "is_active"));

        return product;
    }

}