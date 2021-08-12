package com.cypherstudios.cypherwallet.model;

/**
 *
 * @author Victor
 */
public enum ConceptTypes {
    FIXED("Fijo"), VAR("Variable");

    private String tipo;

    private ConceptTypes(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
