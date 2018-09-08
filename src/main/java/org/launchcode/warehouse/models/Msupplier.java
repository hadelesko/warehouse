package org.launchcode.warehouse.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.List;
@Entity
public class Msupplier {
    private int id;
    private String name;
    private String email;
    @ManyToOne
    private List<MMaterial> suppliedmateriels;

    public Msupplier(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MMaterial> getSuppliedmateriels() {
        return suppliedmateriels;
    }

    public void setSuppliedmateriels(List<MMaterial> suppliedmateriels) {
        this.suppliedmateriels = suppliedmateriels;
    }

    /*Method to be implemented
     * List<MMaterial>getMateiallistByMsupplier(int supplierId)
     * void suppliedmaterials.add(MMaterial newMMaterial)
     *
     *
     */

}
