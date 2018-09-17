package org.launchcode.warehouse.controllers;

import org.launchcode.warehouse.models.MMaterial;
import org.launchcode.warehouse.models.MatLocation;
import org.launchcode.warehouse.models.data.MMaterialDao;
import org.launchcode.warehouse.models.data.MatLocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LocationController {
    @Autowired
    private MatLocationDao locationDao;
    private MMaterialDao materialDao ;

/*    @RequestMapping(value="createLocation")
    public void createLocation(Model model){
        model.addAttribute("title","Create new location");
        model.addAttribute("listLocations",locationDao.findAll());
        model.addAttribute("newlocation",new MatLocation());
        //Todo
        return "createlocation";
    }

    @RequestMapping(value="addLocationformaterial", method = RequestMethod.GET)
    public addLocationformaterial(Model model){
        model.addAttribute("title", "Add new location for the material");
        model.addAttribute("material", new MatLocation());
        MMaterial material=new MMaterial();
        String matName=material.getMatName();

        return "addlocation";
        // TODO  this html must be created
    }
    @RequestMapping(value="addLocationformaterial", method = RequestMethod.POST)
    public void addLocationformaterial(Model model){

     //TODO

    }*/


}
