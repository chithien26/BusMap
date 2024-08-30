/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.service;

import com.busmap.pojo.Schedule;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lechi
 */
public interface ScheduleService {
    List<Schedule> getSchedules(Map<String, String> params);
    void addOrUpdate(Schedule schedule);
    Schedule getScheduleById(int id); 
    void deleteSchedule(int id); 
}
