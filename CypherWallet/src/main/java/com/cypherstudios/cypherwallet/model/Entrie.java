package com.cypherstudios.cypherwallet.model;

import java.util.Date;

/**
 * Clase que define un movimiento en la cuenta.
 *
 * @author Victor
 */
public abstract class Entrie {

    protected int IdEntrie;
    protected Date date;
    protected double amount;
    protected String notes;

    protected supplier Supplier;
    protected concept Concept;

}
