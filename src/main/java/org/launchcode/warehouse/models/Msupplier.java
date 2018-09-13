package org.launchcode.warehouse.models;

import javax.persistence.*;
import java.util.List;
@Entity
public class Msupplier {
    @Id
    @GeneratedValue
    private int supplier_id;
    private String name;
    private String email;
    //@ManyToMany(mappedBy="mat_suppliers")
    //private List<Msupplier>matsupplierlist;
   @ManyToMany//(mappedBy = "suppliedmaterials")
    private List<MMaterial> suppliedmateriels;

    @ManyToMany(mappedBy="suppliedmateriels")
    private List<Msupplier>matsupplierlist;

    public Msupplier(){}

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
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
