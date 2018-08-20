package org.launchcode.warehouse.models;


import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Material {

    @Id
    @GeneratedValue
    private  int id ;

    @NotNull(message="not empty")
    private  String name;

    //@NotNull(message="not empty")
    //@Size(min=10, max=120, message="At least 10 Characters and not more than 120")
    private  String description;

    //@NotNull(message="not empty")
    //@Range(min=0, message="Not negative")
    private  double initialstock;


    //@NotNull(message="not empty")
    //@Range(min=0, message="Not negative")
    private  double orderd_quantity;



    @NotNull(message="not empty")
    @Range(min=0, message="Not negative")
    private  double received_quantity;

    //@NotNull(message="not empty")
    //@Range(min=0, message="Not negative")
    private  double returned_quantity_on_delivery;

    //@NotNull(message="not empty")
    //Range(min=0, message="Not negative")
    private  double returned_quantity_on_reception;

    //@NotNull(message="not empty")
    //@Range(min=0, message="Not negative")
    private  double dispo_quantity;


    public Material(){

    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getInitialstock() {
        return initialstock;
    }

    public void setInitialstock(double initialstock) {
        this.initialstock = initialstock;
    }

    public double getOrderd_quantity() {
        return orderd_quantity;
    }

    public void setOrderd_quantity(double orderd_quantity) {
        this.orderd_quantity = orderd_quantity;
    }

    public double getReceived_quantity() {
        return received_quantity;
    }

    public void setReceived_quantity(double received_quantity) {
        this.received_quantity = received_quantity;
    }

    public double getReturned_quantity_on_delivery() {
        return returned_quantity_on_delivery;
    }

    public void setReturned_quantity_on_delivery(double returned_quantity_on_delivery) {
        this.returned_quantity_on_delivery = returned_quantity_on_delivery;
    }

    public double getReturned_quantity_on_reception() {
        return returned_quantity_on_reception;
    }

    public void setReturned_quantity_on_reception(double returned_quantity_on_reception) {
        this.returned_quantity_on_reception = returned_quantity_on_reception;
    }

    public double getDispo_quantity() {
        return dispo_quantity;
    }

    public void setDispo_quantity(double dispo_quantity) {
        this.dispo_quantity = dispo_quantity;
    }
    public double dispo_stock(){
        double disp_quantity= getReceived_quantity()
                -getOrderd_quantity()
                +getInitialstock()
                +getReturned_quantity_on_delivery()
                -getReturned_quantity_on_reception();
        return disp_quantity;

    }


}
