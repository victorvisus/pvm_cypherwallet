package com.cypherstudios.cypherwallet.auxiliares;

/**
 *
 * Genera los IDs para los objetos del programa
 *
 * @author Víctor Visús García
 *
 *
 * ver:
 *
 * Clase Genérica: https://javadesdecero.es/avanzado/genericos-ejemplos-java/
 *
 * Clase Enumerados:
 * https://francho.org/2010/01/07/java-ejemplo-de-uso-de-tipos-enumerados-enum/
 */
public class IdGenerator {

    /**
     * Clase enumerada donde se establecen los prefijos predefinidos
     */
    private enum Prefix {

        USER("US"), SUPPLIER("SP"), ENTRIE("EN"), ACCOUNTANT("AC"),
        CATEGORY("CA"), CONCEPT("CO"), DEFUALT("DEF");

        private String idPrefix;

        private Prefix(String idPrefix) {
            this.idPrefix = idPrefix;
        }

        public String getPrefix() {
            return idPrefix;
        }
    }

    /**
     * Comprueba el Tipo de objeto que recibe, envia y establece el prefijo para
     * el ID
     */
    private static <T> String setPrefix(T entidad, String idPrefix) {
        //Instancia el tipo Enumerado
        Prefix tipo = null;

        //Almacena el nombre de clase del objeto T que recibe, para evaluar el switch
        String nameClass = entidad.getClass().getSimpleName();

        //Dependiendo del tipo de objeto establece un prefijo u otro
        switch (nameClass) {
            case "User":
                idPrefix = tipo.USER.getPrefix();
                break;
            case "Supplier":
                idPrefix = tipo.SUPPLIER.getPrefix();
                break;
            case "Entrie":
                idPrefix = tipo.ENTRIE.getPrefix();
                break;
            case "Accountant":
                idPrefix = tipo.ACCOUNTANT.getPrefix();
                break;
            case "Category":
                idPrefix = tipo.CATEGORY.getPrefix();
                break;
            case "Concept":
                idPrefix = tipo.CONCEPT.getPrefix();
                break;
            default:
                idPrefix = tipo.DEFUALT.getPrefix();
            //Declaración
        }

        return idPrefix;
    }

    /**
     * Método que establece la ID del Acreedor (Supplier).
     *
     * <ul>
     * <li>1. Establece el prefijo del ID, dependiendo del tipo de objeto que le
     * llegue</li>
     * <li>2. Realiza una consulta COUNT a la tabla que corresponda en la base
     * de datos para extraer el nº de registros que existen</li>
     * <li>3. Concatena la constante idPrefix con el resultado de la consulta,
     * sumandole 1 al resultado de la consulta</li>
     * <li>4. Valida que el ID resultante no exista en la tabla correspondiente
     * de la BBDD</li>
     * </ul>
     *
     * ---- MIRAR DE PONERLO EN ALGUNA INTERFACE, p.ej. interface IAux
     *
     */
    public static <T> String setId(T ob) {
        String idPrefix = "";

        idPrefix = setPrefix(ob, idPrefix);

        return idPrefix;
    }
}
