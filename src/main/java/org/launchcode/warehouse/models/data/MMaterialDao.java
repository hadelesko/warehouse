package org.launchcode.warehouse.models.data;

import org.launchcode.warehouse.models.MMaterial;
import org.launchcode.warehouse.models.MatLocation;
import org.springframework.data.repository.CrudRepository;

public interface MMaterialDao extends CrudRepository<MMaterial, Integer> {
/*    Iterable<MMaterial> getAllMaterials();
    Iterable<MMaterial> getbysupplier(String suppliername);
    MMaterial getById(int id);
    MMaterial getByname(String name);

    void add_newmaterial(MMaterial mMaterial);
    void update_stock(MMaterial mMaterial);//for the modification of the available stock of material
    void relocateMaterial(MMaterial mMaterial);

    void addnewlocation(MatLocation location);

    void removelocation(MatLocation location);*/


    //Material findByname(String name);


    //Material findOne(String String);

    //void addnewmaterial(Material material);

    //void update(Material material);



    //void save(Material material);
}
