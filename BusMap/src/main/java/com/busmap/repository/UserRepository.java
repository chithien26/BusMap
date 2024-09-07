/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.repository;

import com.busmap.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lechi
 */
public interface UserRepository {
    User getUserByUsername(String username);
    User createUser(User user);
    List<User> getUsers(Map<String, String> params);
}
