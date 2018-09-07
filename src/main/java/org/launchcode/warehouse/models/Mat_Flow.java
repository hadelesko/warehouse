package org.launchcode.warehouse.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Mat_Flow {
    //Mat_Flow={Reception, Order, Retour, Delivery, Relocation, Pick}
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Id
    @GeneratedValue
    private int id; // the flow id
    /*we don't need here to declare name or the id of the flowed material. it is
     * contained in the list  List<MMaterial> mMaterials
     * */
    @NotNull
    private double flow_quantity;
    @NotNull
    private String description;

    private String flowname;// ={Recepetion, Retour, Order}

    /*from warehouse and material location for the intern
    order for the production and supplier for the reception from outside of the company
    Email, phone or contact are preferred here to contact the provenance
    if we are out of stock or to proceed automatically or dynamically the command
    */
    private String provenance;

    //warehouse as default for all reception from supplier// and all Retour from different production line

    private String destination;

    /*Relation between tables . a list of different materials or "Many" materials can belong to "One" Mat_Flow
     * example: one list of materials or more than one material can be ordered, delivered, received: ---> Many
     *  in "one" Flow  ---> One
     *  The Material of the list (List<MMaterial> mMaterials) belongs to the class material and can be identified
     *  in the table Mat_Flow  with the id "mat_id" ---->@JoinColumn(name = "mat_id") in the class MMaterial
     *  */

    @ManyToOne
    private List<MMaterial> mMaterials = new ArrayList<>();

    @ManyToOne
    private List<MatLocation> matLocations = new ArrayList<>();


    public Mat_Flow() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getFlow_quantity() {
        return flow_quantity;
    }

    public void setFlow_quantity(double flow_quantity) {
        this.flow_quantity = flow_quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFlowname() {
        return flowname;
    }

    public void setFlowname(String flowname) {
        this.flowname = flowname;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<MMaterial> getmMaterials() {
        return mMaterials;
    }

    public void setmMaterials(List<MMaterial> mMaterials) {
        this.mMaterials = mMaterials;
    }

    /*Extra method to add new material to the list of the MMaterials on the list of the flow
     * https://www.thoughts-on-java.org/hibernate-tips-map-bidirectional-many-one-association/
     * Updating the associations on both entities is an error-prone task.
     * Therefore, it’s a good practice to provide a helper method
     * that adds another entity to the many side of the association
     * */
    public void addMaterial(MMaterial mMaterial) {

        mMaterials.add(mMaterial);

    }
}
