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
public class IdGenerator<T> {

    /**
     * Clase enumerada donde se establecen los prefijos predefinidos
     */
    private enum Prefix {

        USER("US"), SUPPLIER("SP"), ENTRIE("EN"), ACCOUNTANT("AC"), CATEGORY("CA"), CONCEPT("CO");

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
    private String setPrefix(T entidad, String idPrefix) {
        //Instancia el tipo Enumerado
        Prefix tipo = null;

        //Almacena el nombre de clase del objeto T que recibe
        String nameClass = entidad.getClass().getName();

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
            //Declaración
        }

        return idPrefix;
    }

    /**
     * Método que establece la ID del Acreedor (Supplier).
     *
     * <ul>
     * <li>1. Realiza una consulta COUNT a la tabla que corresponda en la base
     * de datos para extraer el nº de registros que existen</li>
     * <li>2. Concatena la constante idPrefix con el resultado de la
     * consulta</li>
     * <li>3. Valida que el ID resultante no exista en la tabla correspondiente
     * de la BBDD</li>
     * </ul>
     *
     * ---- MIRAR DE PONERLO EN ALGUNA INTERFACE, p.ej. interface IAux
     *
     */
    public static void setId(T ob) {
        String idPrefix = "";
    }
}
