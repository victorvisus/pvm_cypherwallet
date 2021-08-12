package com.cypherstudios.cypherwallet.interfaces;

import com.cypherstudios.cypherwallet.exceptions.WalletException;
import javax.swing.JOptionPane;

/**
 *
 * Clase Interface que añade las funciones necesarias para que se pueda operar
 * con la clase Entrie
 *
 * @author Víctor Visús García
 */
public interface IOperations {

    /**
     *
     * @param <T>
     * @param record
     */
    public static <T> void addRecord(T record) throws WalletException {

    }

    public static <T> void remRecord(T record) throws WalletException {

    }

    public static <T> void modRecord(T record) throws WalletException {

    }

    /**
     * Evalua que el objeto exista, si es asi imprime los datos del mismo, si no
     * lanza un error
     *
     * @param <T>
     * @param record
     * @throws WalletException
     */
    public static <T> void detRecord(T record) throws WalletException {

        if (record != null) {
            System.out.println(record.toString());

            JOptionPane.showMessageDialog(null, record.toString(), "Información del objeto", JOptionPane.INFORMATION_MESSAGE);

        } else {
            throw new WalletException(11);
        }
    }
}
