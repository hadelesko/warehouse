package org.launchcode.warehouse.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MMaterial {
    @Id
    @GeneratedValue
    private int mat_id;
    private String matName;
    private String description;
    @NotNull
    @Min(value=1, message="at least 1")
    private double stock; // Available quantity after eachflow

    @ManyToOne
    private Mat_Flow flow;

    @ManyToOne
    private
    MatLocation matlocation;

    @ManyToMany(mappedBy="suppliedmateriels")
    private List<Msupplier> matsupplierlist;

    public MMaterial() {
    }

    public int getMat_id() {
        return mat_id;
    }

    public void setMat_id(int mat_id) {
        this.mat_id = mat_id;
    }

    public String getMatName() {
        return matName;
    }

    public void setMatName(String matName) {
        this.matName = matName;
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

    public Mat_Flow getFlow() {
        return flow;
    }

    public void setFlow(Mat_Flow flow) {
        this.flow = flow;
    }

    public MatLocation getMatlocation() {
        return matlocation;
    }

    public void setMatlocation(MatLocation matlocation) {
        this.matlocation = matlocation;
    }

    public List<Msupplier> getMatsupplierlist() {
        return matsupplierlist;
    }

    public void setMatsupplierlist(List<Msupplier> matsupplierlist) {
        this.matsupplierlist = matsupplierlist;
    }
}

/*    // {matname,description,stock,List<Mat_Flow> mat_flows;List<MatLocation> matLocations,List<Msupplier> msuppliers;}

    @OneToMany
    @JoinColumn(name = "mat_id")
    private List<Mat_Flow> mat_flows;
    *//*One flow activity can contain more than one material
     example:One list of order from the production or reception from
     supplier can contain  more than one different material
     in the template this wil be mat_id
     *//*

    //Many locations can be used for the storing of "One" material. List of locations associated to single material
    //@JoinColumn(name="locationId")
    @ManyToOne(targetEntity = MatLocation.class)
    @JoinColumn(name="material")
    private List<MatLocation> matLocations=new ArrayList<>(); ; // can be let blank if the material is newly received

    //Suppose that one supplier can provide us one or several materials
    @OneToMany
    @JoinColumn(name = "materials")
    private  List<Msupplier> msuppliers;

    public MMaterial(){}
*/



