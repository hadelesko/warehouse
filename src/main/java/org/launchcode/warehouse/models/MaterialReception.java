package org.launchcode.warehouse.models;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class MaterialReception {
    @Id
    @GeneratedValue
    private int receptionId;

    @OneToMany//(mappedBy = "material_id")
    private List<Material> receivedmaterial;

    @NotNull(message = "not empty")
    @Range(min = 0, message = "Not negative")
    private double received_quantity;

    public MaterialReception() {
    }

    public int getReceptionId() {
        return receptionId;
    }

    public void setReceptionId(int receptionId) {
        this.receptionId = receptionId;
    }

    public double getReceived_quantity() {
        return received_quantity;
    }

    public void setReceived_quantity(double received_quantity) {
        this.received_quantity = received_quantity;
    }

    public List<Material> getReceivedmaterial() {
        return receivedmaterial;
    }

    public void setReceivedmaterial(List<Material> receivedmaterial) {
        this.receivedmaterial = receivedmaterial;
    }
}

































































