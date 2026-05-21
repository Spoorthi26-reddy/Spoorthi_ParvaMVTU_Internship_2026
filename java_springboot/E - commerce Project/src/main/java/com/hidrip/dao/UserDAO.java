package com.hidrip.dao;

import java.util.List;

import com.hidrip.model.User;

public interface UserDAO {

    // =========================
    // AUTHENTICATION
    // =========================

    boolean registerUser(User user);

    User loginUser(String email,
                   String password);



    // =========================
    // FETCH USERS
    // =========================

    User getUserById(int userId);

    User getUserByEmail(String email);

    User getUserByPhone(String phone);

  



    // =========================
    // UPDATE USER
    // =========================

    boolean updateUser(User user);

    boolean updatePassword(int userId,
                           String newPassword);
    
    
    List<User> getAllUsers();

    boolean deleteUser(int userId);

    boolean updateUserRole(
            int userId,
            String role);



    // =========================
    // VALIDATION
    // =========================

    boolean emailExists(String email);

    boolean phoneExists(String phone);

}