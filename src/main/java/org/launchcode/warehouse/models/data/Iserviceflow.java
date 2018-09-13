package org.launchcode.warehouse.models.data;

import org.launchcode.warehouse.models.MMaterial;
import org.launchcode.warehouse.models.Mat_Flow;

import java.util.List;

public interface Iserviceflow {
    void addFlow(Mat_Flow flow);
//    Iterable<MMaterial> getAllflowsbyflowname(String flowname);
//    Iterable<MMaterial> getlistmaterialbysupplier(int supplierId);
//    Mat_Flow getflowById(int flow_id);
//    MMaterial getByname(String name);
//
//    void addnewmaterial(MMaterial mMaterial);
//    void updatematerial(MMaterial mMaterial);//for the modification of the available stock of material
//    List<Mat_Flow> addpicklist(Mat_Flow mat_flow);//by day list use date to make this list
//    boolean flowIsCompleted(Mat_Flow mat_flow);
    /*return false if the order is not yet delivered. so initialize to false if it is true, it
     * if it is true the stock of material can be updated(increased or decreased)
     * */
}
