package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.component.MutterComponent;

@Controller
public class MyController {
    @Autowired
    ConfigurableApplicationContext context;

    @GetMapping(value = "/")
    public String get() {
        return "index";
    }

    @GetMapping(value = "/find")
    public String select(Model model) {
        for(int i = 1; i <= 2; i++) {
            MutterComponent mutter = context.getBean(MutterComponent.class);
            mutter.getMutter(i);
            model.addAttribute("res" + i, mutter.toString());
        }
        return "index";
    }
}
