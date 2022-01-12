package com.cypherstudios.cypherwallet.interfaces;

import java.lang.reflect.Field;

/**
 * ************************** Acceder a los Atributos de Cualquier Objeto *****
 *
 * @see https://programmerclick.com/article/2840322638/
 * @see https://www.arumeinformatica.es/blog/java-reflection-parte-1/
 * @see https://www.arumeinformatica.es/blog/java-reflection-parte-2/
 * @see https://www.arumeinformatica.es/blog/java-reflection-parte-3/
 *
 * @author Victor
 */
public class ExtractFields {

    /**
     * Obtiene la clase del objeto que recibe y la devuelve
     *
     * * OJO -> Devuelve la clase con la ruta completa.
     *
     * @param <T>
     * @param record
     * @return
     */
    protected static <T> Class extractClass(T record) {
        Class x = record.getClass();
        System.out.println("x = " + x);
        return x;
    }

    /**
     * Accede a los atributos del objeto que recibe, para extraer el nombre.
     *
     * <ul>
     * <ol>Obtiene la clase del objeto y Extrae los atributos del objeto, y los
     * guarda en un array de Field</ol>
     * <ol>Crea un array de String de misma longitud que el array anterior
     * (fields)</ol>
     * <ol>Coje los nombres de cada atributo almacenado en el array de Fields y
     * lo añade al array de String</ol>
     * </ul>
     *
     * @param <T>
     * @param record : un objeto cualquiera
     * @return : Array de Strings en el que almacena los Nombres de los
     * atributos del objeto
     */
    protected static <T> String[] extractNameFields(T record) throws IllegalArgumentException {

        //Obtiene la clase del objeto
        //Class x = record.getClass();
        //Paso 1
        Field[] fields = extractClass(record).getDeclaredFields();

        //Paso 2
        String[] namesFields = new String[fields.length];

        //Paso 3
        for (int i = 0; i < fields.length; i++) {
            // Establece que el indicador accesible de este objeto sea legible
            fields[i].setAccessible(true);
            // Añade al array de String nameFields el name del objeto i
            namesFields[i] = fields[i].getName();
        }
        return namesFields;
    }

    /**
     * Accede a los atributos del objeto que recibe, para extraer los valores de
     * cada uno.
     *
     * OJO -> Devuelve el tipo con la ruta completa.
     *
     * @param <T>
     * @param record
     * @return : Array de tipo Object en el que almacena los Valores de los
     * atributos del objeto
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    protected static <T> Object[] extractValueFields(T record) throws IllegalArgumentException, IllegalAccessException {
        //Class x = record.getClass();
        Field[] fields = extractClass(record).getDeclaredFields();

        Object[] valuesFields = new Object[fields.length];

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true); // Establece que el indicador accesible de este objeto sea legible
            valuesFields[i] = fields[i].get(record);
        }
        return valuesFields;
    }

    /**
     * Accede a los atributos del objeto que recibe, para extraer el tipo de
     * dato de cada uno.
     *
     * @param <T>
     * @param record
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    protected static <T> Object[] extractTypeFields(T record) throws IllegalArgumentException, IllegalAccessException {
        Field[] fields = extractClass(record).getDeclaredFields();

        Object[] typesFields = new Object[fields.length];

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true); // Establece que el indicador accesible de este objeto sea legible
            typesFields[i] = fields[i].getType();
        }

        return typesFields;
    }
}
