package org.launchcode.warehouse.controllers;

import org.launchcode.warehouse.models.Material;
import org.launchcode.warehouse.models.data.MaterialDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "material")
public class MaterialController {
    @Autowired
    private MaterialDao materialDao;


    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Warehouse management");
        return "index";

    }

    @RequestMapping(value = "materials")
    public String materialss(Model model) {

        model.addAttribute("materials", materialDao.findAll());
        model.addAttribute("title", "List of the materials");

        return "material/materiallist";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayaddmaterial(Model model) {


        model.addAttribute("title", "Insert the material");
        model.addAttribute(new Material());
        return "material/add";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processaddmaterial(Model model,
                                     @ModelAttribute @Valid Material material,
                                     Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Insert a new Material");
            return "material/add";
        } else {
            if (materialDao.findOne(material.getId()) == null) {
                materialDao.save(material);
                return "redirect:materials";
            }else{
                model.addAttribute("received_quantity", material.getReceived_quantity());
              /*  model.addAttribute("dispo_stock",
                        material.getDispo_quantity()
                                + material.getReceived_quantity()
                                - material.getOrderd_quantity()
                                + material.getInitialstock()
                                + material.getReturned_quantity_on_delivery()
                                - material.getReturned_quantity_on_reception());*/
                double dispostock=material.getDispo_quantity()
                        +material.getReceived_quantity()
                        -material.getOrderd_quantity()
                        +material.getInitialstock()
                        +material.getReturned_quantity_on_delivery()
                        -material.getReturned_quantity_on_reception();

                //materialDao.save(material);
                material.setDispo_quantity(dispostock);
                materialDao.save(material);
                return "redirect:materials";




        }
    }}}
