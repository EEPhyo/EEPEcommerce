package com.ai.model;

public class Transition {
public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCreated_date() {
        return created_date;
    }
    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }
    public double getReceived_amount() {
        return received_amount;
    }
    public void setReceived_amount(double received_amount) {
        this.received_amount = received_amount;
    }
    public String getTransition_proof() {
        return transition_proof;
    }
    public void setTransition_proof(String transition_proof) {
        this.transition_proof = transition_proof;
    }
private int id;
private String created_date;
private double received_amount;
private String transition_proof;
}