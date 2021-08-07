package com.cypherstudios.cypherwallet.model;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ClienteDAO extends Conexion {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection con = null;

    /**
     * Crea la tabla Clientes en la Base de Datos "test"
     *
     * @return boolean para evaluar el éxito de la operación
     */
    public boolean crearTabla() {
        con = getConexion();

        String sql = "CREATE TABLE IF NOT EXISTS `test`.`Clientes` (`Cod_Cliente` INT NOT NULL AUTO_INCREMENT, `Nombre` VARCHAR(45) NOT NULL, `telefono` VARCHAR(45) NOT NULL, PRIMARY KEY (`Cod_Cliente`));";
        try {

            ps = con.prepareStatement(sql);
            ps.execute();

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

    public boolean eliminarTabla() {
        //DROP TABLE test.clientes;
        return true;
    }

    /**
     * Inserta 3 Clientes preestablecidos en la tabla "clientes"
     *
     * @return boolean para evaluar el éxito de la operación
     */
    public boolean registarClientesPreestablecidos() {
        con = getConexion();

        //String sql = "INSERT INTO clientes (Cod_Cliente, Nombre, Telefono) VALUES(?,?,?);";
        String sql = "INSERT INTO clientes (Nombre, Telefono) VALUES(\"Juan Dominguez\",\"976859545\"),"
                + " (\"Angela Martinez\", \"654987321\"), (\"Sofia Perez\", \"974856595\");";

        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al insertar los registros", "Insertar", JOptionPane.ERROR_MESSAGE);
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
     * Inserta un nuevo registro en la tabla de la base de datos
     *
     * @param cli : Objeto tipo Cliente
     * @return boolean para evaluar el éxito de la operación
     */
    public boolean registrarCliente(Cliente cli) {
        con = getConexion();

        String sql = "INSERT INTO clientes (Nombre, Telefono) VALUES(?,?);";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getTelefono());

            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error al Guardar", "Insertar", JOptionPane.ERROR_MESSAGE);
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
     * Actualiza el registro con los datos modificados en el formulario
     *
     * @param cli : Objeto tipo Cliente
     * @return boolean para evaluar el éxito de la operación
     */
    public boolean actualizarCliente(Cliente cli) {
        con = getConexion();

        String sql = "UPDATE clientes SET Nombre = ?, telefono = ? WHERE Cod_Cliente = ?;";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getTelefono());
            ps.setInt(3, cli.getCodCliente());

            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error al Actualizar", "Actualizar", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    public boolean eliminarCliente(JTextField codCliente) {
        con = getConexion();

        String sql = "DELETE FROM clientes WHERE Cod_Cliente = ?;";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, codCliente.getText());

            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error al Eliminar", "Eliminar", JOptionPane.ERROR_MESSAGE);
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
     * Lista los Registros que se encuentran en la tabla 'clientes', los muestra
     * en una JTable
     *
     * @param jtClientes : Recibe la tabla de la vista
     * @return boolean para evaluar el éxito de la operación
     */
    public boolean listarClientes(JTable jtClientes, String codCliente) {

        DefaultTableModel tablaClientes = new DefaultTableModel();
        jtClientes.setModel(tablaClientes);

        String where = "";

        if (!"".equals(codCliente)) {
            where = "WHERE Cod_Cliente = " + Integer.parseInt(codCliente);

            //rellenaCampos(where);
        }
        con = getConexion();

        String sql = "SELECT Cod_Cliente, Nombre, telefono FROM Clientes " + where;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMD = rs.getMetaData();
            //Miramos cuantos datos nos esta devolviendo la consulta
            int numColumnas = rsMD.getColumnCount();

            //Por haber reiniciado la tabla tenemos que añadir las columnas de nuevo
            tablaClientes.addColumn("Código");
            tablaClientes.addColumn("Nombre");
            tablaClientes.addColumn("Teléfono");

            //Ancho de las columnas
            int[] anchoColumna = {50, 200, 200};
            for (int i = 0; i < numColumnas; i++) {
                jtClientes.getColumnModel().getColumn(i).setPreferredWidth(anchoColumna[i]);
            }

            //Con un while recorremos todos los datos que nos devuelve la consulta
            while (rs.next()) {

                //Con un bucle for añadimos los campos a un objeto, ya que la table requiere objetos
                Object[] filas = new Object[numColumnas];

                for (int i = 0; i < numColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }

                //Agregamos al modelo los resultados
                tablaClientes.addRow(filas);

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

    /**
     * Rellena los campos del formulario con los datos de la fila seleccionada
     * en la tabla que lista los clientes. Dentro de la sección "Modificar
     * Cliente"
     *
     * @param jtClientes : JTable, donde se listan los clientes
     * @param txtCodigoMod : Campo del formulario
     * @param txtNombreMod : Campo del formulario
     * @param txtTelefonoMod : Campo del formulario
     * @return boolean para evaluar el éxito de la operación
     */
    public boolean rellenaCampos(JTable jtClientes, JTextField txtCodigoMod,
            JTextField txtNombreMod, JTextField txtTelefonoMod) {

        con = getConexion();

        String sql = "SELECT Cod_Cliente, Nombre, telefono FROM Clientes"
                + " WHERE Cod_Cliente = ?";

        try {
            int Fila = jtClientes.getSelectedRow();
            String codCliente = jtClientes.getValueAt(Fila, 0).toString();

            ps = con.prepareStatement(sql);
            ps.setString(1, codCliente);
            rs = ps.executeQuery();

            if (rs.next()) {
                txtCodigoMod.setText(rs.getString("Cod_Cliente"));
                txtNombreMod.setText(rs.getString("Nombre"));
                txtTelefonoMod.setText(rs.getString("telefono"));

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
