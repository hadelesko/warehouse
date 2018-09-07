package org.launchcode.warehouse.models.data;

import org.launchcode.warehouse.models.Material;
import org.launchcode.warehouse.models.MaterialOrder;
import org.launchcode.warehouse.models.MaterialReception;
import org.launchcode.warehouse.models.Retour;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Matmanagement implements Mrepository{
    private List<Material>materials;
    private Material material;
    private MaterialReception materialReception;
    private MaterialOrder materialOrder;
    private Retour retour;

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


    @Override
    public Material findOne(String String) {
        return null;
    }

    @Override
    public void addnewmaterial(Material material) {
            if(!(materials.contains(material.getName()))){
                material.setDispo_quantity(materialReception.getReceived_quantity());
        }
    }

    @Override
    public void update(Material material) {
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

//    @Override
//    public <S extends Material> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends Material> Iterable<S> save(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public Material findOne(java.lang.Integer integer) {
//        return null;
//    }
//
//    @Override
//    public boolean exists(java.lang.Integer integer) {
//        return false;
//    }
//
//    @Override
//    public Iterable<Material> findAll() {
//
//        return  ;
//    }
//
//    @Override
//    public Iterable<Material> findAll(Iterable<java.lang.Integer> integers) {
//
//        return MaterialDao.findAll();
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void delete(java.lang.Integer integer) {
//
//    }
//
//    @Override
//    public void delete(Material entity) {
//
//    }
//
//    @Override
//    public void delete(Iterable<? extends Material> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {

    }

}
