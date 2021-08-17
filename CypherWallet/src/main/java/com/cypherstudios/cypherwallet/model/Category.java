package com.cypherstudios.cypherwallet.model;

import com.cypherstudios.cypherwallet.auxiliares.IdGenerator;
import com.cypherstudios.cypherwallet.dao.IOperations;

/**
 *
 * @author Victor
 */
public class Category {

    private String idCategory;
    private String nameCategory;
    private String descCategory;

    public Category(String nameCategory, String descCategory) {
        this.nameCategory = nameCategory;
        this.descCategory = descCategory;

        this.idCategory = IdGenerator.setId(this);
    }

    //Getters & Setters
    public String getIdCategory() {
        return idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getDescCategory() {
        return descCategory;
    }

    public void setDescCategory(String descCategory) {
        this.descCategory = descCategory;
    }

    @Override
    public String toString() {
        return "Los datos de la categoría son:"
                + "\n- Identificador: " + idCategory
                + "\n- Nombre: " + nameCategory
                + "\n- Descripción: " + descCategory;
    }

}
