package org.launchcode.warehouse.models.data;

import org.launchcode.warehouse.models.MMaterial;
import org.launchcode.warehouse.models.MatLocation;
import org.launchcode.warehouse.models.Mat_Flow;

import java.util.List;

public class Managmat implements MMaterialDao{

    private List<MMaterial> mMaterials;
    private List<MatLocation> matLocations;

    @Override
    Iterable<MMaterial> getAll(){
    return mMaterials;}


    @Override
    Iterable<MMaterial> getbysupplier(int supplierId){

    List<MMaterial>materialbysupplierId=new List<MMaterial>();
        for(MMaterial mat:mMaterials) {
            if(mat.getMsupplier()==supplierId){
                materialbysupplierId.add(mat);
            }
            }
            return materialbysupplierId;
    }



    @Override
    MMaterial getById(int id){
        for(MMaterial mat:mMaterials) {
            if(mat.getMat_id()==id){
                return mat;
            } else{return null;
        }

    }}

    @Override
    MMaterial getByname(String name){
            for(MMaterial mat:mMaterials) {
                if(mat.getMatname().equals(name)){
                    return mat;
                } else{return null;
                }
    }


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

