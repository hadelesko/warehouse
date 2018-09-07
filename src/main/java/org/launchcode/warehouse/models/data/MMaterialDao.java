package org.launchcode.warehouse.models.data;

import org.launchcode.warehouse.models.MMaterial;
import org.launchcode.warehouse.models.MatLocation;

public interface MMaterialDao {
    Iterable<MMaterial> getAll();
    Iterable<MMaterial> getbysupplier(String suppliername);
    MMaterial getById(int id);
    MMaterial getByname(String name);

    void add_newmaterial(MMaterial mMaterial);
    void update_stock(MMaterial mMaterial);//for the modification of the available stock of material
    void relocateMaterial(MMaterial mMaterial);

    void addnewlocation(MatLocation location);

    void removelocation(MatLocation location);

}
