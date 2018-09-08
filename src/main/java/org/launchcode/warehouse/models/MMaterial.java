package org.launchcode.warehouse.models;

import javax.persistence.*;
import java.util.List;

public class MMaterial {
    @Id
    @GeneratedValue
    private int mat_id;
    private String matname;
    private String description;
    private double stock; // Available quantity after eachflow
    @OneToMany
    @JoinColumn(name = "mat_id")
    private Mat_Flow mat_Flow;
    /*One flow activity can contain more than one material
     example:One order from the production or reception from
     supplier can contain  more than one different material
     in the template this wil be MatFlowId
     */


    @ManyToOne  //Many locations can be used for the storing of "One" material
    private List<MatLocation> matLocations; // can be let blank if the material is newly received

    @OneToMany // Suppose that one supplier can provide us several materials
    private Msupplier msupplier;



    public MMaterial(){}

    public int getMat_id() {
        return mat_id;
    }

    public void setMat_id(int mat_id) {
        this.mat_id = mat_id;
    }

    public String getMatname() {
        return matname;
    }

    public void setMatname(String matname) {
        this.matname = matname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public Mat_Flow getMat_Flow() {
        return mat_Flow;
    }

    public void setMat_Flow(Mat_Flow mat_Flow) {
        this.mat_Flow = mat_Flow;
    }

    public List<MatLocation> getMatLocations() {
        return matLocations;
    }

    public void setMatLocations(List<MatLocation> matLocations) {
        this.matLocations = matLocations;
    }

    public Msupplier getMsupplier() {
        return msupplier;
    }

    public void setMsupplier(Msupplier msupplier) {
        this.msupplier = msupplier;
    }

    /*Extra method that will be devlopped in the class
    implementing the  interface MMaterialDao
    * */
    public void addnewlocation(MatLocation location){
        matLocations.add(location);
    }
    public void removelocation(MatLocation location){

        matLocations.remove(location);
    }


}
