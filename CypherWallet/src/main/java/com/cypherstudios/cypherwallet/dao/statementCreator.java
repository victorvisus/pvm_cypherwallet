package com.cypherstudios.cypherwallet.dao;

import java.sql.PreparedStatement;

/**
 *
 * @author Victor
 */
interface statementCreator {

    /*
    Creo que haran falta dos métodos.
    1.- Que construya elString con la consulta sql
    2.- Mediante un bucle prepare la consulta parametrizada con los valores de
    los atributos del objeto recibido.

    Desde la clase IOperations tal vez tenga que llamar a estos dos métodos por
    separado, para que ejecute el ps.executeUpdate() en la clase operaciones

    ¿Qué pasa si un atributo del objeto es otro objeto? Extraemos el id, vale
    pero ¿como lo hgao?

     */
//    public static PreparedStatement[] createSQL(PreparedStatement ps, String sql, String[] nameFields, Object[] valueFields, Object[] typesFields) {
//
//        PreparedStatement[] psForm;
//
//        //La idea es que,mediante un
//        return psForm;
//    }
}
