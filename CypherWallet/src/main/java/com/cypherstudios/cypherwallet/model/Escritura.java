package com.cypherstudios.cypherwallet.model;

public class Escritura {

    private int codEscritura;
    private String tipo;
    private String nomFichero;
    private int numIntervinientes;

    public Escritura() {
    }

    public Escritura(String tipo, String nomFichero, int numIntervinientes) {
        this.tipo = tipo;
        this.nomFichero = nomFichero;
        this.numIntervinientes = numIntervinientes;
    }

    public int getCodEscritura() {
        return codEscritura;
    }

    public void setCodEscritura(int codEscritura) {
        this.codEscritura = codEscritura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomFichero() {
        return nomFichero;
    }

    public void setNomFichero(String nomFichero) {
        this.nomFichero = nomFichero;
    }

    public int getNumIntervinientes() {
        return numIntervinientes;
    }

    public void setNumIntervinientes(int numIntervinientes) {
        this.numIntervinientes = numIntervinientes;
    }

    @Override
    public String toString() {
        return "Escrituras{" + "codEscritura=" + codEscritura + ", tipo=" + tipo + ", nomFichero=" + nomFichero + ", numIntervinientes=" + numIntervinientes + '}';
    }

}
