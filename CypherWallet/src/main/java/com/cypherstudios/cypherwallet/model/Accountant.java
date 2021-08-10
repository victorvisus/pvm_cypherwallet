package com.cypherstudios.cypherwallet.model;

import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class Accountant {

    private int idAccountant;
    private String nameAccountant;
    private String descAccountant;
    private double balance;

    //Almacena los objetos Entrie que sean de tipo Enum OUTPUTENTRIE
    private ArrayList<Entrie> outputEntries;
    //Almacena los objetos Entrie que sean de tipo Enum INPUTENTRIE
    private ArrayList<Entrie> inputEntries;

    //Almacena los usuario de esta Cuenta
    private ArrayList<User> user;
}
