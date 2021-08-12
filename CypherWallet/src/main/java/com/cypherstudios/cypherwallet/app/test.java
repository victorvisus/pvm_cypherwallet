package com.cypherstudios.cypherwallet.app;

import com.cypherstudios.cypherwallet.exceptions.WalletException;
import com.cypherstudios.cypherwallet.interfaces.IOperations;
import com.cypherstudios.cypherwallet.model.*;
import java.util.Date;

/**
 *
 * @author Victor
 */
public class test {

    public static void main(String[] args) throws WalletException {

        Date fecha = new Date();

        Supplier acreedor = new Supplier("miAcreedor");
        Category laCategoria = new Category("La Categoria", "Esta es la descripcion");
        Concept serExt = new Concept("Servicios Externos", "Esta es la descripción del concepto", laCategoria);

        Entrie entrada = new Entrie(fecha, 100, "Estas son las notas", acreedor, serExt);

        IOperations.detRecord(acreedor);
    }
}
