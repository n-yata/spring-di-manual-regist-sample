package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.component.MutterComponent;

@Controller
public class MyController {

    @Autowired
    ApplicationContext context;

    @GetMapping(value = "/")
    public String get() {
        return "index";
    }

    @GetMapping(value = "/find")
    public String select(Model model) {
        MutterComponent mutter = context.getBean(MutterComponent.class);

        String msg = mutter.getMutter(1);
        model.addAttribute("res", msg);
        model.addAttribute("size", mutter.getMutterList().size());

        String msg2 = mutter.getMutter(2);
        model.addAttribute("res2", msg2);
        model.addAttribute("size2", mutter.getMutterList().size());

        return "index";
    }
}
