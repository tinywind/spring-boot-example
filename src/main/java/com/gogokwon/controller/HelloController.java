package com.gogokwon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloController {
    @RequestMapping("")
    public String indexPage(Model model) {
        model.addAttribute("name", "gogokwon");
        return "index";
    }
}