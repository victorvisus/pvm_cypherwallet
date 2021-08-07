package com.cypherstudios.cypherwallet.controller;

import com.cypherstudios.cypherwallet.view.InsertCliente;
import com.cypherstudios.cypherwallet.view.ModCliente;
import com.cypherstudios.cypherwallet.view.InsertEscrituras;
import com.cypherstudios.cypherwallet.view.PanelOpciones;
import com.cypherstudios.cypherwallet.model.ClienteDAO;
import com.cypherstudios.cypherwallet.model.EscrituraDAO;
import com.cypherstudios.cypherwallet.model.Cliente;
import com.cypherstudios.cypherwallet.model.EscCliDAO;
import com.cypherstudios.cypherwallet.model.Escritura;
import java.awt.HeadlessException;
import java.awt.event.*;
import javax.swing.JOptionPane;

/**
 * Clase que va a controlar las operaciones del programa. Implemente la clase
 * ActionListener porque va a escuchar las acciones del usuario
 *
 */
public class CtrlPanelOpciones implements ActionListener {

    private Cliente cli;
    private ClienteDAO cliDao;

    private Escritura esc;
    private EscrituraDAO escDao;

    private EscCliDAO escCliDao;

    private PanelOpciones run;
    private ModCliente runModCli = new ModCliente(run, true);
    private InsertCliente runInsCli = new InsertCliente(run, true);
    private InsertEscrituras runInsEsc = new InsertEscrituras(run, true);

    /**
     * Constructor de la clase.
     *
     * En esta clase "escucha" la interacción del usuario con los botones de la
     * app
     *
     * @param run : Vista gráfica de la app
     * @param cli : Objeto tipo Cliente
     * @param cliDao : Clase con los métodos para manipular los datos de los
     * Clientes en la BBDD
     * @param esc : Objeto tipo Escritura
     * @param escDao : Clase con los métodos para manipular los datos de las
     * Escrituras en la BBDD
     * @param escCliDao : Clase con los métodos para manipular la relacion
     * Cliente-Escritura
     */
    public CtrlPanelOpciones(PanelOpciones run,
            Cliente cli, ClienteDAO cliDao,
            Escritura esc, EscrituraDAO escDao, EscCliDAO escCliDao) {

        this.run = run;
        /// CLIENTES ///
        this.cli = cli;
        this.cliDao = cliDao;
        // ESCRITURAS //
        this.esc = esc;
        this.escDao = escDao;

        this.escCliDao = escCliDao;

        //Agrego los botones comunes
        this.run.btnSalir.addActionListener(this);

        //Botones Panel InsertCliente
        this.runInsCli.btnCerrar.addActionListener(this);
        this.runInsCli.btnInsertarCliente.addActionListener(this);

        //Botones Panel ModCliente
        this.runModCli.btnCerrar.addActionListener(this);
        this.runModCli.btnListarClientes.addActionListener(this);
        this.runModCli.btnBuscarCliente.addActionListener(this);
        this.runModCli.btnGuardarModificaciones.addActionListener(this);
        this.runModCli.btnEliminarCliente.addActionListener(this);

        //Agrego los botones correspondientes a Clientes
        this.run.btnCrearClientes.addActionListener(this);
        this.run.btnListarClientes.addActionListener(this);
        this.run.btnInsert3Clientes.addActionListener(this);
        this.run.btnInsertCliente.addActionListener(this);
        this.run.btnModCliente.addActionListener(this);

        //Agrego los botones correspondientes a Escrituras
        this.run.btnCrearEscrituras.addActionListener(this);
        this.run.btnListarEscrituras.addActionListener(this);

        this.runInsEsc.btnCerrar.addActionListener(this);
        this.runInsEsc.btnVerClientes.addActionListener(this);
        this.runInsEsc.btnInsertarEscritura.addActionListener(this);

        this.run.btnInsertEscCli.addActionListener(this);

        // ESCLI //
        this.run.btnCrearEscCli.addActionListener(this);

        this.run.btnListarCliCPVE.addActionListener(this);
    }

    public void iniciar() {
        run.setVisible(true);
        //Oculto el campo del codigo del cliente del panel "Listar Clientes"
        run.txtCodCliente.setVisible(false);
        run.setTitle("Panel de opciones");
        run.setLocationRelativeTo(null);
    }

    /**
     * Método que escucha los clicks a los botones y filtran la operación que
     * tiene que realizar
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        /* ********************************************* Operaciones comunes ** */
        //Salir
        if (e.getSource() == run.btnSalir) {
            //Cierra la aplicación
            System.exit(0);
        }

        //Abrir ventana ModCliente
        if (e.getSource() == run.btnModCliente) {
            //this hace referencia al formulario principal y true para afirmar que es un form modal
            runModCli.setVisible(true);
        }

        //Abrir ventana InsertCliente
        if (e.getSource() == run.btnInsertCliente) {
            runInsCli.setVisible(true);
        }


        /* ******************************** Operaciones especificas CLIENTES ** */
        //Crear tabla Clientes
        if (e.getSource() == run.btnCrearClientes) {

            if (cliDao.crearTabla()) {
                JOptionPane.showMessageDialog(null, "Tabla 'clientes' creada correctamente", "Crear Tabla", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        //Listar Clientes
        if (e.getSource() == run.btnListarClientes) {

            String codCliente = run.txtCodCliente.getText();
            //Llama al método y le manda la tabla y el codCliente, en este caso siempre será 0
            cliDao.listarClientes(run.jtClientes, codCliente);
        }

        //Insertar 3 Clientes de prueba
        if (e.getSource() == run.btnInsert3Clientes) {
            cliDao.registarClientesPreestablecidos();
        }

        //** INSERTAR CLIENTES **//
        //Cerrar la ventana Insertar Cliente
        if (e.getSource() == runInsCli.btnCerrar) {
            //Sale de la ventana donde se encuentre
            runInsCli.dispose();
        }

        //Insertar nuevo cliente
        if (e.getSource() == runInsCli.btnInsertarCliente) {
            /* Tomamos los valores de las cajas de texto y los mete al objeto Cliente,
            después llamar al método de guardar e insertar los datos a la BBDD */
            cli.setNombre(runInsCli.txtNombre.getText());
            cli.setTelefono(runInsCli.txtTel.getText());

            //Llamo al método registrarCliente y le pasa el objeto cliente
            if (cliDao.registrarCliente(cli)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado", "Insertar", JOptionPane.INFORMATION_MESSAGE);
            }
            limpiarCampos();
        }

        //** MODIFICAR CLIENTES **//
        //Cerrar la ventana Modificar Cliente
        if (e.getSource() == runModCli.btnCerrar) {
            //Sale de la ventana donde se encuentre
            runModCli.dispose();
        }

        //Listar todos O Buscar cliente por código
        if (e.getSource() == runModCli.btnListarClientes || e.getSource() == runModCli.btnBuscarCliente) {
            String codCliente = runModCli.txtCodCliente.getText();
            cliDao.listarClientes(runModCli.jtClientes, codCliente);

            runModCli.txtCodCliente.setText(null);
        }

        //Guardar Modificaciones
        if (e.getSource() == runModCli.btnGuardarModificaciones) {
            //Establece los valores de los datos del formulario como atributos del objeto Cliente
            cli.setCodCliente(Integer.parseInt(runModCli.txtCodigoMod.getText()));
            cli.setNombre(runModCli.txtNombreMod.getText());
            cli.setTelefono(runModCli.txtTelefonoMod.getText());

            //Llamna al método para realizar la actualización y le manda el objeto cliente
            if (cliDao.actualizarCliente(cli)) {
                JOptionPane.showMessageDialog(null, "Registro Actualizado", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
            }
            limpiarCampos();
        }

        //Eliminar Cliente
        if (e.getSource() == runModCli.btnEliminarCliente) {

            if (JOptionPane.showConfirmDialog(null, "Seguro?", "Eliminar", JOptionPane.YES_NO_OPTION) == 0) {
                if (cliDao.eliminarCliente(runModCli.txtCodigoMod)) {
                    JOptionPane.showMessageDialog(null, "Registro Eliminado", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Operación Cancelada", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
            }

        }

        /* ****************************** Operaciones especificas ESCRITURAS ** */
        //Crear tabla
        if (e.getSource() == run.btnCrearEscrituras) {
            if (escDao.crearTabla()) {
                JOptionPane.showMessageDialog(null, "Tabla 'escrituras' creada correctamente", "Crear Tabla", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        //Listar Escrituras en Panel Principal
        if (e.getSource() == run.btnListarEscrituras) {
            escDao.listarEscrituras(run.jtEscrituras);
        }

        //** INSERTAR ESCRITURAS **//
        //Abrir ventana
        if (e.getSource() == run.btnInsertEscCli) {
            runInsEsc.setVisible(true);
        }

        //Cerrar ventana
        if (e.getSource() == runInsEsc.btnCerrar) {
            runInsEsc.dispose();
        }

        //Listar Clientes en Panel Insertar Escritura
        if (e.getSource() == runInsEsc.btnVerClientes) {
            cliDao.listarClientes(runInsEsc.jtClientesEsc, "");
        }

        //Insertar Escritura y Asociarla con un Cliente (tabla EscCli)
        if (e.getSource() == runInsEsc.btnInsertarEscritura) {

            insertarEscritura();
        }

        /* ********************************** Operaciones especificas ESCCLI ** */
        //Crear tabla
        if (e.getSource() == run.btnCrearEscCli) {
            if (escCliDao.crearTabla()) {
                JOptionPane.showMessageDialog(null, "Tabla 'EscCli' creada correctamente", "Crear Tabla", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        //Listar Nombre de los clientes con escritura CPVE
        if (e.getSource() == run.btnListarCliCPVE) {
            if (escCliDao.listarCPVE(run.jtCpve)) {
                JOptionPane.showMessageDialog(null, "No hago la consulta que pide el ejercicio,"
                        + "\n no consigo que me salga\n"
                        + "Listo TODOS los nombres de Clientes",
                        "Lista CPVE", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }

    private void insertarEscritura() throws HeadlessException, NumberFormatException {
        String codString = runInsEsc.txtCodClienteEsc.getText();

        if (!"".equals(runInsEsc.txtCodClienteEsc.getText())) {
            /* Tomamos los valores de las cajas de texto y los mete al objeto Escritura,
            después llamar al método de guardar e insertar los datos a la BBDD */

            //Coge los valores de los atributos del objeto Escritura y su registro en la tabla Escrituras
            esc.setTipo(runInsEsc.cbxTipoEsc.getSelectedItem().toString());
            esc.setNomFichero(runInsEsc.txtNomFich.getText());
            esc.setNumIntervinientes(Integer.parseInt(runInsEsc.txtNumIntervinientes.getText()));

            int codCliente = Integer.parseInt(runInsEsc.txtCodClienteEsc.getText());

            if (escDao.registrarEscritura(esc, escCliDao, codCliente)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado", "Insertar", JOptionPane.INFORMATION_MESSAGE);
            }

            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un Cliente para asociarlo a la escritura", "Insertar", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        runInsCli.txtNombre.setText(null);
        runInsCli.txtTel.setText(null);

        runModCli.txtCodCliente.setText(null);
        runModCli.txtCodigoMod.setText(null);
        runModCli.txtNombreMod.setText(null);
        runModCli.txtTelefonoMod.setText(null);

        runInsEsc.txtCodClienteEsc.setText(null);
        runInsEsc.txtNomFich.setText(null);
        runInsEsc.txtNumIntervinientes.setText(null);
    }

}
