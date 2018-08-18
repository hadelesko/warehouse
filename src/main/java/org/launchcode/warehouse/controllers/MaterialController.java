package org.launchcode.warehouse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MaterialController {



    @RequestMapping(value="")
    public  String index(Model model){
        model.addAttribute("title", "Warehouse management");
        return "index";

    }
}
