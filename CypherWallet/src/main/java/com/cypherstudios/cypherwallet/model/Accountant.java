package com.cypherstudios.cypherwallet.model;

import com.cypherstudios.cypherwallet.auxiliares.IdGenerator;
import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class Accountant {

    private String idAccountant;
    private String nameAccountant;
    private String descAccountant;
    private double balance;

    /* LOS MOVIMIENTOS SE PODRÍA ALMACENAR EN UN SOLO ARRAYLIST DE TIPO ENTRIE
    Y LUEGO QUE SE FILTRASE POR TIPO DE MOVIMIENTO */
    //Almacena los objetos Entrie que sean de tipo Enum OUTPUTENTRIE
    private ArrayList<Entrie> outputEntries;
    //Almacena los objetos Entrie que sean de tipo Enum INPUTENTRIE
    private ArrayList<Entrie> inputEntries;

    //Almacena los usuario de esta Cuenta
    private ArrayList<User> user;

    /**
     * El contrustor de la clase solo recibe 2 parámetros, dentro de éste tiene
     * que generarse el ID de la cuenta, coger el Saldo actual de la cuenta (e
     * ir actulizandolo en cada momento).
     *
     * En cuanto a los movimientos no sé que será mejor si que los almacene en
     * un ArrayList y que lo vaya actualizando o que los recoja directamente de
     * la BBDD
     *
     * @param nameAccountant
     * @param descAccountant
     */
    public Accountant(String nameAccountant, String descAccountant/*, User user*/) {
        this.nameAccountant = nameAccountant;
        this.descAccountant = descAccountant;
        //this.user = user;

        this.idAccountant = IdGenerator.setId(this);

        //Llamada al método que crea el ArrayList de los movimientos (si se decide que es necesario)
        //Llamada al método que crea el ArrayList de los usuarios
    }

    @Override
    public String toString() {
        return "\nLos datos de la cuenta son:"
                + "\n- Identificador: " + idAccountant
                + "\n- Nombre de la cuenta: " + nameAccountant
                + "\n- Descripción: " + descAccountant
                + "\n- Saldo:" + balance;
    }
}
