package com.cypherstudios.cypherwallet.model;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EscCliDAO extends Conexion {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection con = null;

    /**
     * Crea la tabla EscCli
     *
     * @return
     */
    public boolean crearTabla() {
        con = getConexion();

        String sql = "CREATE TABLE IF NOT EXISTS test.EscCli"
                + " (Cod_Escritura INT NOT NULL, Cod_Cliente INT NOT NULL);";
        try {

            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error al crear la tabla", "Crear", JOptionPane.ERROR_MESSAGE);

            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    /**
     * Crea los registros en la tabla EscCli
     *
     * @param codEsc : int Código de la escritura
     * @param codCliente : int Código del cliente asociado a la escritura
     * @return
     */
    public boolean asociarEscCli(int codEsc, int codCliente) {

        con = getConexion();

        String sql = "INSERT INTO esccli (Cod_Escritura, Cod_Cliente) VALUES(?,?);";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, String.valueOf(codEsc));
            ps.setString(2, String.valueOf(codCliente));

            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error al Asociar Esc/Cli", "Insertar", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

    }

    /**
     * Rellena el campo del Código cliente con el código de la seleccion de la
     * tabla
     *
     * @param jtClientesEsc : JTable, donde se listan los clientes
     * @param txtCodClienteEsc : Campo del formulario
     */
    public void rellenaCampos(JTable jtClientesEsc, JTextField txtCodClienteEsc) {

        con = getConexion();

        String sql = "SELECT Cod_Cliente, Nombre, telefono FROM Clientes"
                + " WHERE Cod_Cliente = ?";

        int Fila = jtClientesEsc.getSelectedRow();
        String codCliente = jtClientesEsc.getValueAt(Fila, 0).toString();

        txtCodClienteEsc.setText(codCliente);

    }

    /**
     * Lista los Registros que se encuentran en la tabla 'escrituras', los
     * muestra en una JTable
     *
     * @param jtClientes : JTable Recibe la tabla de la vista
     * @return boolean para evaluar el éxito de la operación
     */
    public boolean listarCPVE(JTable jtClientes) {

        DefaultTableModel tablaCpve = new DefaultTableModel();
        jtClientes.setModel(tablaCpve);

        con = getConexion();

        String sql = "SELECT Nombre FROM clientes ";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMD = rs.getMetaData();
            //Miramos cuantos datos nos esta devolviendo la consulta
            int numColumnas = rsMD.getColumnCount();

            //Por haber reiniciado la tabla tenemos que añadir las columnas de nuevo
            tablaCpve.addColumn("Nomrbe");

            //Ancho de las columnas
//            int[] anchoColumna = {50, 200, 200, 200};
//            for (int i = 0; i < numColumnas; i++) {
//                jtClientes.getColumnModel().getColumn(i).setPreferredWidth(anchoColumna[i]);
//            }

            //Con un while recorremos todos los datos que nos devuelve la consulta
            while (rs.next()) {

                //Con un bucle for añadimos los campos a un objeto, ya que la table requiere objetos
                Object[] filas = new Object[numColumnas];

                for (int i = 0; i < numColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }

                //Agregamos al modelo los resultados
                tablaCpve.addRow(filas);

            }
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "No se han encontrado registros", "Listar", JOptionPane.ERROR_MESSAGE);

            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

}
