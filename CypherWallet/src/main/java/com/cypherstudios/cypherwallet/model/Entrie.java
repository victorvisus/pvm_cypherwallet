package com.cypherstudios.cypherwallet.model;

import com.cypherstudios.cypherwallet.auxiliares.IdGenerator;
import java.util.Date;

/**
 * Clase que define un movimiento en la cuenta.
 *
 * @author Víctor Visús García
 */
public abstract class Entrie {

    protected String idEntrie;
    protected Date date;
    protected double amount;
    protected String notes;

    protected supplier Supplier;
    protected concept Concept;

    //Constructor de la clase, no se permite ningún attr vacio
    public Entrie(Date date, double amount, String notes, supplier Supplier, concept Concept) {
        //this.idEntrie = idEntrie;
        this.date = date;
        this.amount = amount;
        this.notes = notes;
        this.Supplier = Supplier;
        this.Concept = Concept;

        //El idEntrie tiene que generarlo con el método auxiliar generico
    }
    public Entrie(double amount, String notes) {
        this.amount = amount;
        this.notes = notes;

        this.idEntrie = IdGenerator.setId(this);
    }

    //Getters & Stters
    public String getIdEntrie() {
        return idEntrie;
    }

    public void setIdEntrie(String IdEntrie) {
        this.idEntrie = IdEntrie;
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

    @Override
    public String toString() {
        return "Entrie{" + "idEntrie=" + idEntrie + ", date=" + date + ", amount=" + amount + ", notes=" + notes + ", Supplier=" + Supplier + ", Concept=" + Concept + '}';
    }

}
