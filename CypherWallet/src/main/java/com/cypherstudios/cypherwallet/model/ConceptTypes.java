/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
