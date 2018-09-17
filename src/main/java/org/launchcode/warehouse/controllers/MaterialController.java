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
import java.util.List;

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
        model.addAttribute("materials", materialDao.findAll());
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

        model.addAttribute("title", "Add the new flow of the material");
        model.addAttribute("material", new MMaterial());

        return "material/add";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processaddmaterial(Model model,
                                     @ModelAttribute @Valid MMaterial material,
                                     Errors errors, @RequestParam("stock") double stock,
                                     @RequestParam String matName) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Insert a new Material");

            return "material/add";
        } else {

            if (materialDao.findByMatName(matName) != null) { //it was checked that the
                // material with the name matName exists so the only things to do here is
                //to update the available quantity

                double newstocko = materialDao.findByMatName(matName).getStock() + stock;
                materialDao.findByMatName(matName).setStock(newstocko);
                materialDao.save(materialDao.findByMatName(matName));
                return "redirect:";

            }
            else {
                //New material that is at the first time in the database
                //Obtain the id for the new material that will help to save it into the database
                material.setMat_id(material.getMat_id());
                //save the new material
                materialDao.save(material);
                return "redirect:";
            }
        }
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String removematerial(Model model) {
        model.addAttribute("title", "Remove material");
        model.addAttribute("materials", materialDao.findAll());
        return "material/removematerial";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemove(@RequestParam String[] matNames) {

        for (String matName : matNames) {
            //materialDao.removeByMatNameAndStockLessThanEqual(matName, stock);
            materialDao.removeByMatName(matName);

        }

        return "redirect:";
    }
}

/*    @RequestMapping(value="delete",method=RequestMethod.GET)
    public String deletematerial(Model model){
        model.addAttribute("title", "Delete material");

        model.addAttribute("materials",materialDao.findAll());
        return "material/deletematerial";
    }
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String proceeddelete(Model model, @RequestParam  String matName, @RequestParam  double stock) {

        //
        //double stocko=Double.parseDouble(stock);
        materialDao.findByMatName(matName);

        // Verfy if the given material name exists and if its stock exceeds the required stock
        if(materialDao.findByMatName(matName)!=null && materialDao.findByMatName(matName).getStock()>stock) {

            materialDao.removeByMatName(matName);
        }

        return "redirect:";

}*/




