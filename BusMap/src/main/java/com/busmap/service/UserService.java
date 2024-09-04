/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.service;

import com.busmap.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author lechi
 */

public interface UserService extends UserDetailsService{
    User getUserByUsername(String username);
    User createUser(User user);
}
