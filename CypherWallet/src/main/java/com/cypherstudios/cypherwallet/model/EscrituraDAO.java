package com.cypherstudios.cypherwallet.model;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EscrituraDAO extends Conexion {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection con = null;

    /**
     * Crea la tabla Escrituras en la Base de Datos "test"
     *
     * @return
     */
    public boolean crearTabla() {
        con = getConexion();

        String sql = "CREATE TABLE IF NOT EXISTS test.escrituras"
                + " (Cod_Escritura INT NOT NULL AUTO_INCREMENT, Tipo VARCHAR(10) NOT NULL,"
                + " Nom_fich VARCHAR(80) NOT NULL, Numinterv INT NOT NULL,"
                + " PRIMARY KEY (Cod_Escritura));";
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

    /**
     * Inserta registros en la tabla Escrituras y en la tabla EscCli. Para
     * insertar un registro en la tabla EscCli llama al método asociarEscCli
     * implementado en la clase EscCliDAO. Le envia como parámetros las claves
     * primarias correspondientes a la Escritura, que en este momento esta
     * registrando, y del Cliente, indicada en el formulario.
     *
     * @param esc
     * @param escCliDao
     * @param codCliente
     * @return
     */
    public boolean registrarEscritura(Escritura esc, EscCliDAO escCliDao, int codCliente) {
        con = getConexion();

        String sql = "INSERT INTO escrituras (Tipo, Nom_fich, Numinterv) VALUES(?,?,?);";

        try {
            //Con PreparedStatement.RETURN_GENERATED_KEYS le indico que estoy interesado en la clave autoincremental
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, esc.getTipo());
            ps.setString(2, esc.getNomFichero());
            ps.setString(3, String.valueOf(esc.getNumIntervinientes()));

            ps.executeUpdate();

            //Obtengo la clave autogenerada
            int codEsc = 0;
            rs = ps.getGeneratedKeys();
            while (rs.next()) {
                codEsc = rs.getInt(1);
            }

            //Llamo al método que creará el registro en la tabla EscCli. Le paso los código de escritura y cliente
            escCliDao.asociarEscCli(codEsc, codCliente);

            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error al Guardar la Escritura", "Insertar", JOptionPane.ERROR_MESSAGE);
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
     * Lista los Registros que se encuentran en la tabla 'escrituras', los
     * muestra en una JTable
     *
     * @param jtClientes : JTable Recibe la tabla de la vista
     * @return boolean para evaluar el éxito de la operación
     */
    public boolean listarEscrituras(JTable jtEscrituras) {

        DefaultTableModel tablaEscrituras = new DefaultTableModel();
        jtEscrituras.setModel(tablaEscrituras);

        con = getConexion();

        String sql = "SELECT Cod_Escritura, Tipo, Nom_fich, Numinterv FROM escrituras ";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMD = rs.getMetaData();
            //Miramos cuantos datos nos esta devolviendo la consulta
            int numColumnas = rsMD.getColumnCount();

            //Por haber reiniciado la tabla tenemos que añadir las columnas de nuevo
            tablaEscrituras.addColumn("Código");
            tablaEscrituras.addColumn("Tipo");
            tablaEscrituras.addColumn("Nombre de Ficher");
            tablaEscrituras.addColumn("Nº de Intervinientes");

            //Ancho de las columnas
            int[] anchoColumna = {50, 200, 200, 200};
            for (int i = 0; i < numColumnas; i++) {
                jtEscrituras.getColumnModel().getColumn(i).setPreferredWidth(anchoColumna[i]);
            }

            //Con un while recorremos todos los datos que nos devuelve la consulta
            while (rs.next()) {

                //Con un bucle for añadimos los campos a un objeto, ya que la table requiere objetos
                Object[] filas = new Object[numColumnas];

                for (int i = 0; i < numColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }

                //Agregamos al modelo los resultados
                tablaEscrituras.addRow(filas);

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
