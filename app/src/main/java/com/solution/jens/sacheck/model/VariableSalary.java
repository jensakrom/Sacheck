package com.solution.jens.sacheck.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Jens on 8/10/2016.
 */
public class VariableSalary extends RealmObject {
    @PrimaryKey
    private String id;
    private double basicSalary;
    private double fixAllowed;
    private double transport;
    private double meal;
    private double healt;
    private double travel;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getFixAllowed() {
        return fixAllowed;
    }

    public void setFixAllowed(double fixAllowed) {
        this.fixAllowed = fixAllowed;
    }

    public double getTransport() {
        return transport;
    }

    public void setTransport(double transport) {
        this.transport = transport;
    }

    public double getMeal() {
        return meal;
    }

    public void setMeal(double meal) {
        this.meal = meal;
    }

    public double getHealt() {
        return healt;
    }

    public void setHealt(double healt) {
        this.healt = healt;
    }

    public double getTravel() {
        return travel;
    }

    public void setTravel(double travel) {
        this.travel = travel;
    }
}
