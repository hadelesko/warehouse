package org.launchcode.warehouse.models;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Material {

    @Id
    @GeneratedValue
    private  int id ;

    @NotNull(message="not empty")
    private  String name;
    private  String description;

    private  double initialstock;
    private  double orderd_quantity;
    private  double received_quantity;
    private  double returned_quantity_on_delivery;
    private  double returned_quantity_on_reception;
    private  double dispo_quantity;
}
