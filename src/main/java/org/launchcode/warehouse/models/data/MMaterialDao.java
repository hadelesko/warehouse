package org.launchcode.warehouse.models.data;

import org.launchcode.warehouse.models.MMaterial;
import org.launchcode.warehouse.models.MatLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface MMaterialDao extends CrudRepository<MMaterial, Integer> {

    MMaterial findByMatName(String matName);
    List<MMaterial> removeByMatName(String matName);
    List<MMaterial> removeByMatNameAndStockLessThanEqual(String matName, double stock);
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
