package org.launchcode.warehouse.models.data;

import org.launchcode.warehouse.models.MMaterial;

import java.util.List;

public class Matmanagement{
    private List<MMaterial>materials;
    private MMaterial material;


    /* @Override
   public Material findByname(String name) {
       Material mat=new Material();
        boolean  mat_exist=false;
        HashMap<Integer, String> allname=new HashMap<Integer, String>();
        for(mat : materials){
            allname.put(mat.getId(), mat.getName());
        }
        if(allname.containsValue(name)){
              mat_exist=true;
            } else{mat_exist=false;}
            return mat;
        }*/
/*


    @Override
    public Material findOne(String String) {
        return null;
    }

    @Override
    public void addnewmaterial(MMaterial material) {
            if(!(materials.contains(material.getName()))){
                material.setDispo_quantity(materialReception.getReceived_quantity());
        }
    }

    @Override
    public void update(MMaterial material) {
        if(materials.contains(material.getName())
                &&(materialReception.getReceived_quantity()>=0
                ||retour.getRetour_quantity()>=0
                ||materialOrder.getOrdered_quantity()>=0)){
            double dp_qty = material.getDispo_quantity()
                    + materialReception.getReceived_quantity()
                    + retour.getRetour_quantity()
                    - materialOrder.getOrdered_quantity();
            material.setDispo_quantity(dp_qty);
    }
*/



}
