package org.launchcode.warehouse.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Retour {
    @Id
    @GeneratedValue
    private int retour_id;

    @OneToMany//(mappedBy="material_id")
    private List<Material> retournedmaterial;

    private double retour_quantity;


    public Retour(){}


    public int getRetour_id() {
        return retour_id;
    }

    public void setRetour_id(int retour_id) {
        this.retour_id = retour_id;
    }

    public List<Material> getRetournedmaterial() {
        return retournedmaterial;
    }

    public void setRetournedmaterial(List<Material> retournedmaterial) {
        this.retournedmaterial = retournedmaterial;
    }

    public double getRetour_quantity() {
        return retour_quantity;
    }

    public void setRetour_quantity(double retour_quantity) {
        this.retour_quantity = retour_quantity;
    }
}
