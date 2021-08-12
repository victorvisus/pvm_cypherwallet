package com.cypherstudios.cypherwallet.model;

import com.cypherstudios.cypherwallet.auxiliares.IdGenerator;
import com.cypherstudios.cypherwallet.interfaces.IOperations;

/**
 *
 * @author Victor
 */
public class Supplier implements IOperations {

    private String idSupplier;
    private String nameSupplier;
    private String notes;

    //Constructor que recibe, unicamente, el nombre del acreedor.
    public Supplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;

        this.idSupplier = IdGenerator.setId(this);
    }

    //Constructor que recibe unicamente el nombre.
    public Supplier(String nameSupplier, String notes) {
        this.nameSupplier = nameSupplier;
        this.notes = notes;

        this.idSupplier = IdGenerator.setId(this);
    }

    //Getters & Setters
    public String getIdSupplier() {
        return idSupplier;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Los datos del acreedor son:"
                + "\n- Identificador: " + idSupplier
                + "\n- Nombre: " + nameSupplier
                + "\n- Notas: " + notes;
    }

}
