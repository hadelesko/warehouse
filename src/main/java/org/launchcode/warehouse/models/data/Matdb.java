package org.launchcode.warehouse.models.data;

import org.launchcode.warehouse.models.MMaterial;

import javax.persistence.EntityManager;

public class Matdb {
    public static MMaterial getMMaterialbyId(int id){
        EntityManager em=DBUtil.getEmlmFactory().createEntityManager();
        try{
            MMaterial mMaterial=em.find(MMaterial.class, id);
            return mMaterial;
        }finally{
            em.close();
        }
    }
}
