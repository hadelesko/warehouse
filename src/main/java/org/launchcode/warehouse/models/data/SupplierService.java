package org.launchcode.warehouse.models.data;

import org.launchcode.warehouse.models.MMaterial;
import org.launchcode.warehouse.models.Msupplier;

import java.util.List;

public class SupplierService implements SupplierDao {
    private List<MMaterial>allmaterials;

    private List<Msupplier> suppliers;
    private List<MMaterial> suppliedmaterials;

    public List<MMaterial> getMateiallistByMsupplierId(int supplierId){
        //suppliedmaterials=new List<MMaterial>();
        for(MMaterial mat:allmaterials){
            if(mat.getMsupplier().getId()==supplierId){
                suppliedmaterials.add(mat);


            }
        }
        return suppliedmaterials;
    }
}
