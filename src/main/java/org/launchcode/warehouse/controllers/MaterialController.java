package org.launchcode.warehouse.controllers;

import org.launchcode.warehouse.models.MMaterial;
import org.launchcode.warehouse.models.Mat_Flow;
import org.launchcode.warehouse.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller

public class MaterialController {
    @Autowired
    private MMaterialDao materialDao;

    @Autowired
    private Mat_FlowDao mat_flowDao;

    @Autowired
    private SupplierDao supplierDao;

    @Autowired
    private MatLocationDao matLocationDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Warehouse management");
        model.addAttribute("materials",materialDao.findAll());
        return "material/index";

    }

    @RequestMapping(value = "materials")
    public String materialss(Model model) {

        model.addAttribute("materials", materialDao.findAll());
        model.addAttribute("title", "List of the materials");

        return "material/materiallist";
    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayaddmatflow(Model model) {


/*        model.addAttribute("title", "Add the new flow of the material");
        model.addAttribute("matflow",new Mat_Flow());
        model.addAttribute("material",new MMaterial());
        model.addAttribute("materials",materialDao.findAll());*/

        model.addAttribute("title", "Add the new flow of the material");
        model.addAttribute("material",new MMaterial());

        return "material/add";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processaddmaterial(Model model,
                                     @ModelAttribute @Valid MMaterial material,
                                     Errors errors){


        /*MMaterial mat = materialDao.findOne(materialId);
        double dispo = mat.getStock() //+ flow.getFlow_quantity();
        flow.setMmaterial(mat);
        mat.setStock(dispo);
        model.addAttribute("material", mat);
        model.addAttribute("materialId", flow.getMmaterial().getMat_id());
*/

        if (errors.hasErrors()) {
            model.addAttribute("title", "Insert a new Material");

            return "material/add";
        }else{
            material.setMat_id(material.getMat_id());
            materialDao.save(material);
            return "redirect:";
    }
}
}



