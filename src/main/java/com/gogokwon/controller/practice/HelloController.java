package com.gogokwon.controller.practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloController {
    // /hello
    // /hello/material
    @RequestMapping({"material", ""})
    public String materialPage(Model model) {
        model.addAttribute("name", "gogokwon");
        return "hello/material";
    }

    @RequestMapping("bootstrap")
    public String indexPage(Model model) {
        model.addAttribute("name", "gogokwon");
        return "hello/bootstrap";
    }
}