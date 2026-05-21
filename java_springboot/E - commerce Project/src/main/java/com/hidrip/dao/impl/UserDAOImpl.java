package com.hidrip.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hidrip.dao.UserDAO;
import com.hidrip.model.User;
import com.hidrip.util.DBConnection;

public class UserDAOImpl implements UserDAO {



    // =========================
    // REGISTER USER
    // =========================

    @Override
    public boolean registerUser(User user) {

        boolean status = false;

        String sql =
        "INSERT INTO users(full_name,email,phone,password,gender,address,role) "
      + "VALUES (?,?,?,?,?,?,?)";

        try (Connection con = DBConnection.getConnection();

             PreparedStatement ps =
             con.prepareStatement(sql)) {

            ps.setString(1, user.getFullName());

            ps.setString(2, user.getEmail());

            ps.setString(3, user.getPhone());

            ps.setString(4, user.getPassword());

            ps.setString(5, user.getGender());

            ps.setString(6, user.getAddress());

            ps.setString(7, "CUSTOMER");

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return status;
    }



    // =========================
    // LOGIN USER
    // =========================

    @Override
    public User loginUser(String email,
                          String password) {

        User user = null;

        String sql =
        "SELECT * FROM users "
      + "WHERE email=? AND password=?";

        try (Connection con =
             DBConnection.getConnection();

             PreparedStatement ps =
             con.prepareStatement(sql)) {

            ps.setString(1, email);

            ps.setString(2, password);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                user = extractUser(rs);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return user;
    }



    // =========================
    // GET USER BY ID
    // =========================

    @Override
    public User getUserById(int userId) {

        User user = null;

        String sql =
        "SELECT * FROM users WHERE user_id=?";

        try (Connection con =
             DBConnection.getConnection();

             PreparedStatement ps =
             con.prepareStatement(sql)) {

            ps.setInt(1, userId);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                user = extractUser(rs);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return user;
    }



    // =========================
    // GET USER BY EMAIL
    // =========================

    @Override
    public User getUserByEmail(String email) {

        User user = null;

        String sql =
        "SELECT * FROM users WHERE email=?";

        try (Connection con =
             DBConnection.getConnection();

             PreparedStatement ps =
             con.prepareStatement(sql)) {

            ps.setString(1, email);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                user = extractUser(rs);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return user;
    }



    // =========================
    // GET USER BY PHONE
    // =========================

    @Override
    public User getUserByPhone(String phone) {

        User user = null;

        String sql =
        "SELECT * FROM users WHERE phone=?";

        try (Connection con =
             DBConnection.getConnection();

             PreparedStatement ps =
             con.prepareStatement(sql)) {

            ps.setString(1, phone);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                user = extractUser(rs);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return user;
    }

   



 /* =========================================
    DELETE USER
 ========================================= */

    @Override
    public boolean deleteUser(
            int userId) {

        boolean deleted = false;

        try(Connection con =
                DBConnection.getConnection()) {




        	
            



            // =========================================
            // DELETE WISHLIST
            // =========================================

            try {

                PreparedStatement ps2 =
                con.prepareStatement(

                "DELETE FROM wishlist "
                + "WHERE user_id=?");

                ps2.setInt(1,
                        userId);

                ps2.executeUpdate();

            }

            catch(Exception e) {

                System.out.println(
                "wishlist skip");
            }


         // =========================================
         // DELETE CART ITEMS
         // =========================================

         try {

             PreparedStatement ps3 =
             con.prepareStatement(

             "DELETE FROM cart_items "
             + "WHERE cart_id IN ("
             + "SELECT cart_id FROM cart "
             + "WHERE user_id=?)");

             ps3.setInt(1,
                     userId);

             ps3.executeUpdate();

         }

         catch(Exception e) {

             System.out.println(
             "cart_items skip");
         }





         // =========================================
         // DELETE CART
         // =========================================

         try {

             PreparedStatement ps4 =
             con.prepareStatement(

             "DELETE FROM cart "
             + "WHERE user_id=?");

             ps4.setInt(1,
                     userId);

             ps4.executeUpdate();

         }

         catch(Exception e) {

             System.out.println(
             "cart skip");
         }


            // =========================================
            // DELETE ORDERS
            // =========================================

            try {

                PreparedStatement ps5 =
                con.prepareStatement(

                "DELETE FROM orders "
                + "WHERE user_id=?");

                ps5.setInt(1,
                        userId);

                ps5.executeUpdate();

            }

            catch(Exception e) {

                System.out.println(
                "orders skip");
            }




            // =========================================
            // DELETE USER
            // =========================================

            PreparedStatement ps6 =
            con.prepareStatement(

            "DELETE FROM users "
            + "WHERE user_id=?");

            ps6.setInt(1,
                    userId);



            deleted =
            ps6.executeUpdate() > 0;

            System.out.println(
            "USER DELETED: "
            + deleted);
        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return deleted;
    }

 /* =========================================
    UPDATE USER ROLE
 ========================================= */

 @Override
 public boolean updateUserRole(
         int userId,
         String role) {

     boolean updated = false;



     String sql =
     "UPDATE users "
     + "SET role=? "
     + "WHERE user_id=?";



     try(Connection con =
             DBConnection.getConnection();

         PreparedStatement ps =
         con.prepareStatement(sql)) {

         ps.setString(1,
                 role);

         ps.setInt(2,
                 userId);



         updated =
         ps.executeUpdate() > 0;
     }

     catch(Exception e) {

         e.printStackTrace();
     }

     return updated;
 }


    // =========================
    // UPDATE USER
    // =========================

    @Override
    public boolean updateUser(User user) {

        boolean status = false;

        String sql =
        "UPDATE users "
      + "SET full_name=?, phone=?, "
      + "gender=?, address=? "
      + "WHERE user_id=?";

        try (Connection con =
             DBConnection.getConnection();

             PreparedStatement ps =
             con.prepareStatement(sql)) {

            ps.setString(1,
                    user.getFullName());

            ps.setString(2,
                    user.getPhone());

            ps.setString(3,
                    user.getGender());

            ps.setString(4,
                    user.getAddress());

            ps.setInt(5,
                    user.getUserId());

            status =
            ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return status;
    }



    // =========================
    // UPDATE PASSWORD
    // =========================

    @Override
    public boolean updatePassword(int userId,
                                  String newPassword) {

        boolean status = false;

        String sql =
        "UPDATE users "
      + "SET password=? "
      + "WHERE user_id=?";

        try (Connection con =
             DBConnection.getConnection();

             PreparedStatement ps =
             con.prepareStatement(sql)) {

            ps.setString(1,
                    newPassword);

            ps.setInt(2,
                    userId);

            status =
            ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return status;
    }



    // =========================
    // EMAIL EXISTS
    // =========================

    @Override
    public boolean emailExists(String email) {

        boolean exists = false;

        String sql =
        "SELECT user_id "
      + "FROM users WHERE email=?";

        try (Connection con =
             DBConnection.getConnection();

             PreparedStatement ps =
             con.prepareStatement(sql)) {

            ps.setString(1, email);

            ResultSet rs =
                    ps.executeQuery();

            exists = rs.next();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return exists;
    }



    // =========================
    // PHONE EXISTS
    // =========================

    @Override
    public boolean phoneExists(String phone) {

        boolean exists = false;

        String sql =
        "SELECT user_id "
      + "FROM users WHERE phone=?";

        try (Connection con =
             DBConnection.getConnection();

             PreparedStatement ps =
             con.prepareStatement(sql)) {

            ps.setString(1, phone);

            ResultSet rs =
                    ps.executeQuery();

            exists = rs.next();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return exists;
    }



    // =========================
    // GET ALL USERS
    // =========================

    @Override
    public List<User> getAllUsers() {

        List<User> users =
                new ArrayList<>();

        String sql =
        "SELECT * FROM users";

        try (Connection con =
             DBConnection.getConnection();

             PreparedStatement ps =
             con.prepareStatement(sql);

             ResultSet rs =
             ps.executeQuery()) {

            while(rs.next()) {

                users.add(
                        extractUser(rs));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return users;
    }



    // =========================
    // COMMON RESULTSET MAPPER
    // =========================

    private User extractUser(ResultSet rs)
            throws Exception {

        User user = new User();

        user.setUserId(
                rs.getInt("user_id"));

        user.setFullName(
                rs.getString("full_name"));

        user.setEmail(
                rs.getString("email"));

        user.setPhone(
                rs.getString("phone"));

        user.setPassword(
                rs.getString("password"));

        user.setGender(
                rs.getString("gender"));

        user.setAddress(
                rs.getString("address"));

        user.setRole(
                rs.getString("role"));

        user.setCreatedAt(
                rs.getTimestamp("created_at"));

        return user;
    }

}