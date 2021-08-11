package com.cypherstudios.cypherwallet.auxiliares;

enum Vaso {
    // Tipos de vaso disponibles. Pasan al constructor su capacidad en cc.
    JARRA(500), TUBO(250), TERCIO(333), CAÑA(200);
    private int cc; // Variable interna donde almacenaremos la capacidad
    // Nuestro constructor nos fuerza a pasar parámetros al definir un nuevo tipo

    Vaso(int cc) {
        this.cc = cc;
    }

    // Devuelve la capacidad del vaso
    public int getCentimetrosCubicos() {
        return cc;
    }
}

/*
 * Definimos un tipo de bebida
 */
class BebidaCerveza {

    enum MarcaCerveza {
        AMBAR, GUINNESS, HEINEKEN
    } // Tipos enumerados sencillos. Solo tenemos estas marcas
    private Vaso vaso;
    private MarcaCerveza marca;

    BebidaCerveza(MarcaCerveza marca, Vaso vaso) {
        this.marca = marca;
        this.vaso = vaso;
    }

    public void servir() {
        System.out.println("Sirviendo " + vaso.getCentimetrosCubicos() + "cc. de cerveza " + marca);
    }
}

/*
 * Clase pública que prueba todo esto
 */
public class PruebaEnum {

    public static void main(String[] args) {
        BebidaCerveza birra = new BebidaCerveza(BebidaCerveza.MarcaCerveza.AMBAR, Vaso.JARRA);
        birra.servir();
    }
}
