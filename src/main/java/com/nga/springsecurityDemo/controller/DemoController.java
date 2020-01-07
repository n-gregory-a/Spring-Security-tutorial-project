package com.nga.springsecurityDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    // add request mapping ro /leaders
    @GetMapping("/leaders")
    public String showLeaders() {
        return "leaders";
    }

    // add request mapping ro /systems
    @GetMapping("/systems")
    public String showSystems() {
        return "systems";
    }
}
