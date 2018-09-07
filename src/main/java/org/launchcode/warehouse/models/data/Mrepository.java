package org.launchcode.warehouse.models.data;

import org.launchcode.warehouse.models.Material;

import java.util.List;

public interface Mrepository {
    //Material findByname(String name);


    Material findOne(String String);

    void addnewmaterial(Material material);

    void update(Material material);
}
