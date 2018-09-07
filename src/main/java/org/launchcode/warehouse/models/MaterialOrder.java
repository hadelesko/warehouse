package org.launchcode.warehouse.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class MaterialOrder {
    //@Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Id
    @GeneratedValue
    private int orderid;

    @OneToMany
    @JoinColumn(name = "id")//One Material can be ordered several time==one to many relation type
    private List<Material> materials;

    @NotNull(message ="can not be empty or less than null")
    private double ordered_quantity;

    @NotNull
    @Size(min=4, message="At least 4 characters")
    private String destination;

    public MaterialOrder(){}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }



    public double getOrdered_quantity() {
        return ordered_quantity;
    }

    public void setOrdered_quantity(double ordered_quantity) {
        this.ordered_quantity = ordered_quantity;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
