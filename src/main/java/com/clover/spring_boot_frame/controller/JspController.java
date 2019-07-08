package com.clover.spring_boot_frame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = "/jsp")
public class JspController {

    @RequestMapping(value = "/index")
    public String index(Model model){

        model.addAttribute("msg","JSP后台信息");

        return "index";
    }

}
