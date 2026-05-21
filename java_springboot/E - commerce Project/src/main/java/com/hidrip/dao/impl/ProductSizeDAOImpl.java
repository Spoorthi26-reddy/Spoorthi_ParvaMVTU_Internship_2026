package com.hidrip.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hidrip.dao.ProductSizeDAO;
import com.hidrip.model.ProductSize;
import com.hidrip.util.DBConnection;

public class ProductSizeDAOImpl implements ProductSizeDAO {

    @Override
    public boolean addProductSize(ProductSize productSize) {

        boolean status = false;

        String sql = "INSERT INTO product_sizes(product_id, size_label, stock_quantity) VALUES (?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, productSize.getProductId());
            ps.setString(2, productSize.getSizeLabel());
            ps.setInt(3, productSize.getStockQuantity());

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public List<ProductSize> getSizesByProductId(int productId) {

        List<ProductSize> list = new ArrayList<>();

        String sql = "SELECT * FROM product_sizes WHERE product_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, productId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProductSize size = new ProductSize();
                size.setProductSizeId(rs.getInt("product_size_id"));
                size.setProductId(rs.getInt("product_id"));
                size.setSizeLabel(rs.getString("size_label"));
                size.setStockQuantity(rs.getInt("stock_quantity"));

                list.add(size);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public ProductSize getProductSize(int productId, String sizeLabel) {

        ProductSize size = null;

        String sql = "SELECT * FROM product_sizes WHERE product_id=? AND size_label=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, productId);
            ps.setString(2, sizeLabel);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                size = new ProductSize();
                size.setProductSizeId(rs.getInt("product_size_id"));
                size.setProductId(rs.getInt("product_id"));
                size.setSizeLabel(rs.getString("size_label"));
                size.setStockQuantity(rs.getInt("stock_quantity"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return size;
    }

    @Override
    public boolean updateStock(int productSizeId, int quantity) {

        boolean status = false;

        String sql = "UPDATE product_sizes SET stock_quantity=? WHERE product_size_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, quantity);
            ps.setInt(2, productSizeId);

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public boolean deleteProductSize(int productSizeId) {

        boolean status = false;

        String sql = "DELETE FROM product_sizes WHERE product_size_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, productSizeId);

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}