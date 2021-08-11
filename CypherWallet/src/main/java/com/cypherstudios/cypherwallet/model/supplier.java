package com.cypherstudios.cypherwallet.model;

/**
 *
 * @author Victor
 */
public class supplier {

    private String idSupplier;
    private String nameSupplier;
    private String notes;

    //Constructor que recibe, unicamente, el nombre del acreedor.
    public supplier(String nameSupplier) {

        /**
         *
         */
        this.nameSupplier = nameSupplier;
    }

    //Constructor que recibe el nombre y el campo notas del acreedor.
    public supplier(String nameSupplier, String notes) {
        this.nameSupplier = nameSupplier;
        this.notes = notes;
    }

}
