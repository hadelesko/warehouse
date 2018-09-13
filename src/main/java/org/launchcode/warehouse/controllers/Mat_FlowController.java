package org.launchcode.warehouse.controllers;

import org.launchcode.warehouse.models.MMaterial;
import org.launchcode.warehouse.models.Mat_Flow;
import org.launchcode.warehouse.models.data.MMaterialDao;
import org.launchcode.warehouse.models.data.Mat_FlowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value="mflow")
public class Mat_FlowController {
    @Autowired
    Mat_FlowDao flowDao;
    @Autowired
    MMaterialDao materialDao;

    @RequestMapping(value="materialflows")
    public String index(Model model){
        model.addAttribute("title","list of the actual flows");
        model.addAttribute("flows",flowDao.findAll());
        return "mflow/index";
    }

    @RequestMapping(value = "addflow", method = RequestMethod.GET)
    public String displayaddflow(Model model) {


        model.addAttribute("title", "Add the new flow of the material");
        model.addAttribute("flow",new Mat_Flow());
        model.addAttribute("material",new MMaterial());
        model.addAttribute("materials",materialDao.findAll());


        return "mflow/addflow";
    }

    @RequestMapping(value = "addflow", method = RequestMethod.POST)
    public String procedaddflow(Model model,
                                     @ModelAttribute @Valid Mat_Flow flow,
                                     Errors errors, @RequestParam int materialId ) {

        MMaterial mat = materialDao.findOne(materialId);
        double dispo = mat.getStock() + flow.getFlow_quantity();
        //flow.setMaterials(mat);
        mat.setStock(dispo);
        model.addAttribute("material", mat);
        model.addAttribute("materialId", mat.getMat_id());

        if (errors.hasErrors()) {
            model.addAttribute("title", "Insert a new Material");

            return "mflow/addflow";
        }else{
            flowDao.save(flow);
            return "redirect:";
        }
    }


}
