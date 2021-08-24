package com.cypherstudios.cypherwallet.app;

import com.cypherstudios.cypherwallet.exceptions.WalletException;
import com.cypherstudios.cypherwallet.dao.IOperations;
import com.cypherstudios.cypherwallet.model.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class test {

    public static void main(String[] args) {

        Date fecha = new Date();

        Supplier acreedor = new Supplier("miAcreedor");
        Category laCategoria = new Category("La Categoria", "Esta es la descripcion de la Categoría");
        Concept servicioExterno = new Concept("Servicios Externos", "Esta es la descripción del concepto", ConceptTypes.VAR, laCategoria);
        Accountant cuenta = new Accountant("CuentaPrueba", "Esta es la descripción de la cuenta");

        Entrie entrada = new Entrie(fecha, 100, "Estas son las notas", acreedor, servicioExterno, cuenta);

        try {
            IOperations operaciones = new IOperations();
            operaciones.detRecord(entrada);
        } catch (WalletException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Detalles del Movimiento", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
