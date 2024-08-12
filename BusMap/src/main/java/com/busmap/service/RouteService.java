/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.busmap.service;

import com.busmap.pojo.Route;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lechi
 */
public interface RouteService {
    List<Route> getRoutes(Map<String, String> params);
}
