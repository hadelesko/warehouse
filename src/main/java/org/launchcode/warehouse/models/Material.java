package org.launchcode.warehouse.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
public class Material {

    @Id
    @GeneratedValue
    private  int id;
    //private  int material_id ;


    @NotNull(message="not empty")
    private  String name;

    @NotNull(message="not empty")
    @Size(min=10, max=120, message="At least 10 Characters and not more than 120")
    private  String description;

    private  double dispo_quantity;

    @ManyToOne//(mappedBy = "orderid")
    @JoinColumn(name = "orderid")
    private MaterialOrder materialOrder;

    @ManyToOne//(mappedBy = "receptionId")
    @JoinColumn(name = "reception_id")  //
    private MaterialReception materialReception;

    @ManyToOne//(mappedBy="retour_id")
    @JoinColumn(name="retour_id")
    private Retour retour;



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

    public double getDispo_quantity() {
        return dispo_quantity;
    }

    public void setDispo_quantity(double dispo_quantity) {
        this.dispo_quantity = dispo_quantity;
    }

    public MaterialOrder getMaterialOrder() {
        return materialOrder;
    }

    public void setMaterialOrder(MaterialOrder materialOrder) {
        this.materialOrder = materialOrder;
    }

    public MaterialReception getMaterialReception() {
        return materialReception;
    }

    public void setMaterialReception(MaterialReception materialReception) {
        this.materialReception = materialReception;
    }

    public Retour getRetour() {
        return retour;
    }

    public void setRetour(Retour retour) {
        this.retour = retour;
    }


//    @Override
//    public String toString() {
//        return "Material [id=" + getMaterial_id() + ", name=" + getName() +", description="+ getDescription() +", dispo_quantity="
//                + getDispo_quantity() + "]";
//    }
//
//    @Override
//    public String toString() {
//        return "Material [id=" + getId() + ", name=" + getName() +", description="+ getDescription() +", dispo_quantity="
//                + getDispo_quantity() + "]";
//    }


//    public int getMaterial_id() {
//        return material_id;
//    }
//
//    public void setMaterial_id(int material_id) {
//        this.material_id = material_id;
//    }

//    public double updateafter(){
//        if(materialReception.getReceived_quantity()>=0||retour.getRetour_quantity()>=0 || materialOrder.getOrdered_quantity()>=0) {
//            dispo_quantity = getDispo_quantity() + materialReception.getReceived_quantity() + retour.getRetour_quantity() - materialOrder.getOrdered_quantity();
//        }
//        return dispo_quantity;}
    }