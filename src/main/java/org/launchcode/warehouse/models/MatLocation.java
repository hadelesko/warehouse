package org.launchcode.warehouse.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class MatLocation {
    private int id;

    @OneToMany  //One material in can be stored in more than one places in the warehouse(Chaotische Lagerungsstrategie)
                // One Material can be found in different place in the warehouse to facilitate its access
    @JoinColumn(name="w_Location") // This column will be shown in the table MMaterial
    private MMaterial mMaterial;

    private double quantity;
    /* to see the quantity available at each place to know where to go when receiving the picking
    // No restrictions because the location can be empty at the creation or after picking or
    // refilling. So the location table can be affected by the Material Flow class "Mat_Flow"
    // (after picking,receiving or returning some material at some places in the warehouse)
    // The update of this quantity can help the logistic manager to plan the reception and manage
    the picking way and know which place is available for the relocation other materials
    */

    public MatLocation(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MMaterial getmMaterial() {
        return mMaterial;
    }

    public void setmMaterial(MMaterial mMaterial) {
        this.mMaterial = mMaterial;
    }


    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
