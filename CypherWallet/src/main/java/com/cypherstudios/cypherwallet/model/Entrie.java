package com.cypherstudios.cypherwallet.model;

import java.util.Date;

/**
 * Clase que define un movimiento en la cuenta.
 *
 * @author Víctor Visús García
 */
public abstract class Entrie {

    protected int IdEntrie;
    protected Date date;
    protected double amount;
    protected String notes;

    protected supplier Supplier;
    protected concept Concept;

    //Constructor de la clase, no se permite ningún attr vacio
    public Entrie(int IdEntrie, Date date, double amount, String notes, supplier Supplier, concept Concept) {
        this.IdEntrie = IdEntrie;
        this.date = date;
        this.amount = amount;
        this.notes = notes;
        this.Supplier = Supplier;
        this.Concept = Concept;
    }

    //Getters & Stters
    public int getIdEntrie() {
        return IdEntrie;
    }

    public void setIdEntrie(int IdEntrie) {
        this.IdEntrie = IdEntrie;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public supplier getSupplier() {
        return Supplier;
    }

    public void setSupplier(supplier Supplier) {
        this.Supplier = Supplier;
    }

    public concept getConcept() {
        return Concept;
    }

    public void setConcept(concept Concept) {
        this.Concept = Concept;
    }

}
