package org.launchcode.warehouse.models.data;

import org.launchcode.warehouse.models.MMaterial;
import org.launchcode.warehouse.models.MatLocation;
import org.launchcode.warehouse.models.Mat_Flow;

import java.util.List;

public class Managmat implements MMaterialDao{

    private List<MMaterial> mMaterials;
    private List<MatLocation> matLocations;

    @Override
    Iterable<MMaterial> getAll(){}

    @Override
    Iterable<MMaterial> getbysupplier(String suppliername){}

    @Override
    MMaterial getById(int id){}

    @Override
    MMaterial getByname(String name){}


    @Override
    void add_newmaterial(MMaterial mMaterial){
        mMaterials.add(mMaterial);
    }

    //for the modification of the available stock of material
    @Override
    public void update_stock(MMaterial mMaterial, Mat_Flow mat_flow){
        //Reception  from supplier or retour from productionline--- addition
        if(mat_flow.getFlowname().equals("reception") ||mat_flow.getFlowname().equals("retour") ){
            mMaterial.setStock(mMaterial.getStock() + mat_flow.getFlow_quantity());
        }
        //order from productionline
        if(mat_flow.getFlowname().equals("order")){
            mMaterial.setStock(mMaterial.getStock() - mat_flow.getFlow_quantity());
        }

    }


    @Override
    public void relocateMaterial(MMaterial mMaterial){
            mMaterials.add(mMaterial);
            
    }

    @Override
    public void addnewlocation(MatLocation location){
        matLocations.add(location);
    }

    @Override
    public void removelocation(MatLocation location){

        matLocations.remove(location);
    }

}

