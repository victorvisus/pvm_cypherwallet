package com.cypherstudios.cypherwallet.model;

import com.cypherstudios.cypherwallet.auxiliares.IdGenerator;
import com.cypherstudios.cypherwallet.interfaces.IOperations;
import java.util.Date;

/**
 * Clase que define un movimiento en la cuenta.
 *
 * @author Víctor Visús García
 */
public class Entrie implements IOperations {

    protected String idEntrie;
    protected Date date;
    protected double amount;
    protected String notes;

    protected Supplier supplier;
    protected Concept concept;

    /**
     * Constructor de la clase, no se permite ningún attr vacio
     *
     * El attr idEntrie es generado automáticamente mediante el método genérico
     * "setId" de la clase auxiliar idGenerator
     *
     * @param date
     * @param amount
     * @param notes
     * @param supplier
     * @param concept
     */
    public Entrie(Date date, double amount, String notes, Supplier supplier, Concept concept) {
        this.date = date;
        this.amount = amount;
        this.notes = notes;
        this.supplier = supplier;
        this.concept = concept;

        this.idEntrie = IdGenerator.setId(this);
    }

    //Getters & Setters
    public String getIdEntrie() {
        return idEntrie;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier Supplier) {
        this.supplier = Supplier;
    }

    public Concept getConcept() {
        return concept;
    }

    public void setConcept(Concept Concept) {
        this.concept = Concept;
    }

    @Override
    public String toString() {
        return "Los datos del movimiento son:"
                + "\n- Identificador: " + idEntrie
                + "\n- Fecha: " + date
                + "\n- Importe: " + amount
                + "\n- Notas: " + notes
                + "ACREEDOR\n" + supplier
                + "CONCEPTO\n" + concept;
    }

}
