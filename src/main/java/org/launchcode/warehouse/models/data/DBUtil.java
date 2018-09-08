package org.launchcode.warehouse.models.data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static final EntityManagerFactory emlm=Persistence.createEntityManagerFactory("listmaterial");
    public static EntityManagerFactory getEmlmFactory(){
        return emlm;
    }
}
