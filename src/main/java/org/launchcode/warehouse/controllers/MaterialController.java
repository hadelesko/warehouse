package org.launchcode.warehouse.controllers;

import org.launchcode.warehouse.models.Material;
import org.launchcode.warehouse.models.MaterialReception;
import org.launchcode.warehouse.models.data.InternOrderDao;
import org.launchcode.warehouse.models.data.MaterialDao;
import org.launchcode.warehouse.models.data.ReceptionDao;
import org.launchcode.warehouse.models.data.RetourDao;
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

    @Autowired
    private InternOrderDao internOrderDao;

    @Autowired
    private ReceptionDao receptionDao;

    @Autowired
    private RetourDao retourDao;


    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Warehouse management");
        return "material/index";

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
                                     @ModelAttribute @Valid Material material, MaterialReception reception,
                                     Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Insert a new Material");
            return "material/add";
        } else {
            if (materialDao.findOne(material.getMaterial_id()).equals(material.getMaterial_id())){
                //double dpq=material.getDispo_quantity+reception.getReceivedquantity;
                material.setDispo_quantity(material.getDispo_quantity()+reception.getReceived_quantity());
                materialDao.save(material);
                return "redirect:material/materials";
            }else{
                model.addAttribute("received_quantity", reception.getReceived_quantity());

                materialDao.save(material);
                return "redirect:material/materials";
                        }
    }}}
