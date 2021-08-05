package com.cypherstudios.wallet.app;

import com.cypherstudios.wallet.controlador.CtrlInicio;
import com.cypherstudios.wallet.controlador.CtrlLogin;
import com.cypherstudios.wallet.controlador.CtrlRegistroUser;

/**
 *
 * @author Víctor Visús García
 */
public class CypherWalletApp {

    //Controladores
    /**
     * Instancia el controlador que se encarga de las funciones del panel de
     * inicio de la aplicación
     */
    public static CtrlInicio ctrlInicio = new CtrlInicio();

    /**
     * Instancia el controlador que se encarga de las funciones del panel de
     * inicio de sesión
     */
    public static CtrlLogin ctrlLogin = new CtrlLogin();

    /**
     * Instancia el controlador que se encarga de las funciones del panel de
     * registro de usuario de la aplicación
     */
    public static CtrlRegistroUser ctrlRegistro = new CtrlRegistroUser();

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ctrlInicio.iniciarInicio();
    }

}
