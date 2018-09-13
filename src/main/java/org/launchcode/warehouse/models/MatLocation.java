package org.launchcode.warehouse.models;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class MatLocation {

    @Id
    @GeneratedValue
    private int locationId;

     //One material in can be stored in more than one places in the warehouse(Chaotische Lagerungsstrategie)
     // One Material can be found in different place in the warehouse to facilitate its access
    @OneToMany
    @JoinColumn(name="material_locations") // This column will be shown in the table MMaterial
    private List<MMaterial> materiallocations;
    @OneToMany //One material  reception can be placed at different places in the warehouse or one order can be picked in different locations
    @JoinColumn(name="flow_locations")
    private List<Mat_Flow> flow_locations;

    private double quantity;
    /* to see the quantity available at each place to know where to go when receiving the picking
    // No restrictions because the location can be empty at the creation or after picking or
    // refilling. So the location table can be affected by the Material Flow class "Mat_Flow"
    // (after picking,receiving or returning some material at some places in the warehouse)
    // The update of this quantity can help the logistic manager to plan the reception and manage
    the picking way and know which place is available for the relocation other materials
    */

    public MatLocation(){}


    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public List<MMaterial> getMateriallocations() {
        return materiallocations;
    }

    public void setMateriallocations(List<MMaterial> materiallocations) {
        this.materiallocations = materiallocations;
    }

    public List<Mat_Flow> getFlow_locations() {
        return flow_locations;
    }

    public void setFlow_locations(List<Mat_Flow> flow_locations) {
        this.flow_locations = flow_locations;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
