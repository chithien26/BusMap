/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.repository;

import com.busmap.pojo.User;

/**
 *
 * @author lechi
 */
public interface UserRepository {
    User getUserByUsername(String username);
}
