package com.cypherstudios.cypherwallet.dao;

import com.cypherstudios.cypherwallet.exceptions.WalletException;
import com.cypherstudios.cypherwallet.interfaces.ExtractFields;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * Clase Interface que añade las funciones necesarias para que se pueda operar
 * con la clase Entrie
 *
 * @author Víctor Visús García
 */
public class IOperations extends ExtractFields implements statementCreator {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection con = null;
    private String sql = "";

    private Conexion conection = new Conexion();

    /**
     *
     * Recibe un objeto T, del que tiene que extraer a que clase pertenece para
     * poder operar con el.
     *
     *
     * @param <T>
     * @param record
     * @throws com.cypherstudios.cypherwallet.exceptions.WalletException
     * @throws java.sql.SQLException
     */
    public <T> void addRecord(T record, String tabla) throws WalletException, SQLException, IllegalArgumentException, IllegalAccessException {
        con = conection.getConexion();

        //Usa los métodos de la Clase padre ExtractFields para completar los datos de este método
        String[] nameFields = extractNameFields(record); //Recoge el nombre de los atributos
        Object[] valueFields = extractValueFields(record); //Recoge el valor de los atributos
        Object[] typesFields = extractTypeFields(record); //Recoge el tipo de los atributos
        /* Este último devuelve el nombre del atributo con la ruta completa, habrá
        que cortar el final para poder usarlo correctamente */

 /* ************************************ BLOQUE PARA MONTAR LA SENTENCIA SQL **/
        //sql = "INSERT INTO usuarios(nickName, password, email, idTipoUsr) VALUES (?,?,?,?);";
        /*
        Habrá que preparar un método que dependiendo del número de atributos que
        tenga el objeto complete la consulta SQL.

        Si tiene 4 atributos, tendrá que crear el String con los 4 campos y con sus valores

        StringBuilder?????
         */
        //VER COMO SE LE PASA LA TABLA, se podria encriptar con la clase auxiliar Hash.java????
        String campos = ""; //String en el que imprime los nombres de las tablas, que serán los mismo que los de los atributos
        String valores = ""; //aunque no es muy necesario, pero muy recomendable. String que imprime tantas interrogantes como atributos tiene el objeto, separadas por comas
        sql = "INSERT INTO" + tabla + "(" + campos
                + ") VALUES(" + valores + ");";

        ps = con.prepareStatement(sql);

        /* CONSTRUCCIÓN DE CONSULTA PARAMETRIZADA
        El uso de esta consulta evita la inyección de código, y mejora el
        rendimiento entre un 20 y 30% */
        int pos = 0;
        String valor = null;
        /*
        Mediante un bucle,
        0. Ojo con los atributos tipo Object que puede tener el objeto que se le
        envie al método. De ellos, posiblemente, solo habra que extraer el ID
        1. Para la variable "pos" poner la posición en la que ha montado, en el
        String "campos", los atributos de la sentencia SQL. Para ello habrá que
        leer en que posición estan en el Array "nameFields" y sumarle 1 (la
        posición empieza en 0)
        2. Para "valor", deberá hacer un casting dependiendo del tipo de la
        variable
        3A. Hacer casting a String de todos los valores de las variables, y usar
        setString
        ó
        3B. Elige un "set" u otro dependiendo del tipo de dato del atributo.
        if(tipo_dato = int) {
            ps.setInt(pos, Integer.parseInt(valor);
        } else if (tipo_dato = Double) {
            ps.setDouble(pos, Double.parseDouble(valor));
        } else if (tipo_dato = Date) {
            ******* VER COMO HACERLO CORRECTAMENTE ******
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        } else {
            ps.setString(pos, valor);
        }
         */
        ps.setString(pos, valor);
        ps.setInt(pos, Integer.parseInt(valor));
        ps.setDouble(pos, Double.parseDouble(valor));
//        ps.setString(1, usr.getNickName());
//        ps.setString(2, usr.getPassword());
//        ps.setString(3, usr.getEmail());
//        ps.setInt(4, usr.getIdTipoUsr());

        /*
        Lo mismo que para la SQL tendrá que hacer esto de antes, con algún bucle
        o algo parecido
         */
 /* ***************************************************************************/
        ps.executeUpdate();

        con.close();
    }

    public <T> void remRecord(T record) throws WalletException, SQLException {
        //Usar los métodos extractNameFields y extractValueFields para completar los datos de este método

    }

    public <T> void modRecord(T record) throws WalletException, SQLException {
        //Usar los métodos extractNameFields y extractValueFields para completar los datos de este método

    }

    /**
     * Evalua que el objeto exista, si es asi muestra los datos del mismo, si no
     * lanza un error
     *
     * @param <T>
     * @param record
     * @throws WalletException
     */
    public void detRecord(Object record) throws WalletException, IllegalArgumentException, IllegalAccessException {

        if (record != null) {
            //System.out.println(record.toString());
            JOptionPane.showMessageDialog(null, record.toString(), "Información del objeto", JOptionPane.INFORMATION_MESSAGE);

            String[] namesFields = extractNameFields(record);
            Object[] valuesFields = extractValueFields(record);
            Object[] typesFields = extractTypeFields(record);

            for (int i = 0; i < valuesFields.length; i++) {
                System.out.println("El valor del atributo " + namesFields[i] + ": "
                        + valuesFields[i] + " de Tipo: " + typesFields[i]);
            }

        } else {
            throw new WalletException(11);
        }
    }

}
