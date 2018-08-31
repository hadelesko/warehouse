package org.launchcode.warehouse.models;

public class UpdateDispoquantity {
    private Material material;
    private MaterialReception reception;
    private Retour retour;
    private MaterialOrder mo;
    public void updateafterreception(double dispo){
        if(reception.getReceived_quantity()>=0||retour.getRetour_quantity()>=0 || mo.getOrdered_quantity()>=0){
            dispo=material.getDispo_quantity()+reception.getReceived_quantity()+retour.getRetour_quantity()-mo.getOrdered_quantity();
    }
}}
