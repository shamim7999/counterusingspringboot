package com.request.counter.controller;

import com.request.counter.helper.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Controller
public class MyController {

    private int cnt=0;
    private List<String> colors = List.of(
                "purple", "blue", "indigo", "green", "yellow", "orange", "red",
                "pink", "magenta", "black", "#DFFF00", "#0B5345"
            );

    private List<String> buttons = List.of(
            "primary", "danger", "success", "secondary", "warning", "info", "dark"
    );
    @GetMapping("/")
    public String dispatchHandler() {
        return "index";
    }

    @GetMapping("/hello")
    public String requestCounterHandler(Model model) {
        int colorListSize = colors.size();
        int buttonListSize = buttons.size();
        LocalDateTime localDateTime = LocalDateTime.now();
        model.addAttribute("counter", this.cnt++);
        model.addAttribute("localDateTime", localDateTime);
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("localTime", LocalTime.now());
        model.addAttribute("formattedDate", DateFormatter.convertToYearTimeDay(localDateTime));
        model.addAttribute("color", colors.get(this.cnt%colorListSize));
        model.addAttribute("type", buttons.get(this.cnt%buttonListSize));
        return "home";
    }
}
