package com.learn.HotelApp.controller;

import com.learn.HotelApp.model.Staff;
import com.learn.HotelApp.service.impl.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StaffController {

    @Autowired
    private StaffService service;

    @GetMapping("/staff")
    public ResponseEntity<List<Staff>> getStaff() {
        return ResponseEntity.ok(service.getStaff());
    }
}