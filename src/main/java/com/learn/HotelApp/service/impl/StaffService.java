package com.learn.HotelApp.service.impl;

import com.learn.HotelApp.model.Staff;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffService {

    public List<Staff> getStaff(){
        List<Staff> list = new ArrayList<>();
        list.add(new Staff(1, "Santosh", "Reception"));
        list.add(new Staff(2, "Meenakshi", "Service"));
        list.add(new Staff(3, "Sarvesh", "Laundry"));
        list.add(new Staff(4, "Mamta", "Kitchen"));
        return  list;
    }
}