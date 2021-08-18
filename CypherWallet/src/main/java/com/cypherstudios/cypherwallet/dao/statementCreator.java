package com.cypherstudios.cypherwallet.dao;

/**
 *
 * @author Victor
 */
interface statementCreator {

    public static String createSQL(String sql, String[] nameFields, Object[] valueFields, Object[] typesFields) {


        return sql;
    }
}
