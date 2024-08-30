/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.service.impl;

import com.busmap.pojo.Schedule;
import com.busmap.repository.ScheduleRepository;
import com.busmap.service.ScheduleService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lechi
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> getSchedules(Map<String, String> params) {
        return this.scheduleRepository.getSchedules(params);
    }

    @Override
    public void addOrUpdate(Schedule schedule) {
        this.scheduleRepository.addOrUpdate(schedule);
    }

    @Override
    public Schedule getScheduleById(int id) {
        return this.scheduleRepository.getScheduleById(id);
    }

    @Override
    public void deleteSchedule(int id) {
        this.scheduleRepository.deleteSchedule(id);
    }

}
