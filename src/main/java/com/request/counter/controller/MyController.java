package com.request.counter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
public class MyController {

    private int cnt=0;

    @GetMapping("/")
    public String dispatchHandler() {
        return "index";
    }

    @GetMapping("/hello")
    public String requestCounterHandler(Model model) {
        model.addAttribute("counter", this.cnt++);
        model.addAttribute("localDateTime", LocalDateTime.now());
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("localTime", LocalTime.now());
        return "home";
    }
}
