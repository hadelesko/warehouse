package org.launchcode.warehouse.models.data;

import org.launchcode.warehouse.models.Msupplier;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Servicesupplier implements Iservicesupplier{

    EntityManager ems = DBUtil.getEmlmFactory().createEntityManager();
    //tring qam="SELECT * from MMaterial m"+ "";
    EntityTransaction trans =ems.getTransaction();
    @Override
    public void addnewsupplier(Msupplier msupplier){
        try {

            trans.begin();
            ems.persist(msupplier);
            trans.commit();
        }catch(Exception ex){
            trans.rollback();
        }finally {
            ems.close();
        }

    }
}
