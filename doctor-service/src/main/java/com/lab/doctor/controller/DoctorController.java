package com.lab.doctor.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/doctors")
    public String getDoctors() {
        return "Doctor Service running on port " + port;
    }
}
