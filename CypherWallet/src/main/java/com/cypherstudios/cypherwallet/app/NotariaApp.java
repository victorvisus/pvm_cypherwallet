package com.cypherstudios.cypherwallet.app;

import com.cypherstudios.cypherwallet.model.EscrituraDAO;
import com.cypherstudios.cypherwallet.model.Escritura;
import com.cypherstudios.cypherwallet.model.ClienteDAO;
import com.cypherstudios.cypherwallet.model.EscCliDAO;
import com.cypherstudios.cypherwallet.model.Cliente;
import com.cypherstudios.cypherwallet.controller.CtrlPanelOpciones;
import com.cypherstudios.cypherwallet.view.PanelOpciones;

public class NotariaApp {

    public static void main(String[] args) {

        //Instancio objetos Cliente y Escritura y EscCli para operar con ellos
        Cliente cli = new Cliente();
        ClienteDAO cliDao = new ClienteDAO();

        Escritura esc = new Escritura();
        EscrituraDAO escDao = new EscrituraDAO();

        EscCliDAO escCliDao = new EscCliDAO();

        //Instancio la vista principal
        PanelOpciones run = new PanelOpciones();

        //No instancio los JDialog aqui, lo hago en la clase de control

        //Instancio el controlador y le mando los objetos
        CtrlPanelOpciones ctrl = new CtrlPanelOpciones(run, cli, cliDao, esc, escDao, escCliDao);

        //Inicio el panel
        ctrl.iniciar();
//        run.setVisible(true);
//        //Oculto el campo del codigo del cliente del panel "Listar Clientes"
//        run.txtCodCliente.setVisible(false);

    }
}
