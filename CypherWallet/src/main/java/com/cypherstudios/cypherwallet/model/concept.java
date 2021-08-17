package com.cypherstudios.cypherwallet.model;

import com.cypherstudios.cypherwallet.auxiliares.IdGenerator;

/**
 *
 * @author Víctor Visús García
 */
public class Concept {

    private String idConcept;
    private String nameConcept;
    private String descConcept;
    private ConceptTypes conceptType;

    private Category category;

    /**
     * Constructor
     *
     * VER COMO HACER PARA ASIGNAR EL VALOR AL ATTR conceptType
     */
    public Concept(String nameConcept, String descConcept, ConceptTypes conceptTypes, Category category) {
        this.nameConcept = nameConcept;
        this.descConcept = descConcept;
        this.conceptType = conceptTypes;
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

    /**
     *
     * @return : nombre manejable del tipo, un String
     */
    public String getConceptType() {
        return conceptType.getTipo();
    }

    public void setConceptType(ConceptTypes conceptType) {
        this.conceptType = conceptType;
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
                + "\n- Tipo de Gasto: " + conceptType.getTipo()
                + "\nCATEGORIA\n" + category;
    }

}
