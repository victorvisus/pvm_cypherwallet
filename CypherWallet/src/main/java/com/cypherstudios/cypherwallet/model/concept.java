package com.cypherstudios.cypherwallet.model;

import com.cypherstudios.cypherwallet.auxiliares.IdGenerator;
import com.cypherstudios.cypherwallet.interfaces.IOperations;

/**
 *
 * @author Víctor Visús García
 */
public class Concept implements IOperations {

    private String idConcept;
    private String nameConcept;
    private String descConcept;

    private Category category;

    /**
     * Constructor
     */
    public Concept(String nameConcept, String descConcept, Category category) {
        this.nameConcept = nameConcept;
        this.descConcept = descConcept;
        this.category = category;

        this.idConcept = IdGenerator.setId(this);
    }

    //Getters & Setters
    public String getIdConcept() {
        return idConcept;
    }

    public String getNameConcept() {
        return nameConcept;
    }

    public void setNameConcept(String nameConcept) {
        this.nameConcept = nameConcept;
    }

    public String getDescConcept() {
        return descConcept;
    }

    public void setDescConcept(String descConcept) {
        this.descConcept = descConcept;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Los datos del Concepto son:"
                + "\n- Identificador: " + idConcept
                + "\n- Nombre: " + nameConcept
                + "\n- Descripción: " + descConcept
                + "\nCATEGORIA\n" + category;
    }

}
