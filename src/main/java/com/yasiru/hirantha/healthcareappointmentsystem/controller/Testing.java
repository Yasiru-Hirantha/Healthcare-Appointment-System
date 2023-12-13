package com.yasiru.hirantha.healthcareappointmentsystem.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing")
@CrossOrigin
public class Testing {
    @PostMapping("/test")
    public String myMethod(String myString){
        System.out.println("This working");
        return myString;
    }
}
