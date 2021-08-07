package com.cypherstudios.cypherwallet.model;

public class Cliente {

    private int codCliente;
    private String nombre;
    private String telefono;

    public Cliente() {
    }

    public Cliente(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Cliente(int cod_cliente, String nombre, String telefono) {
        this.codCliente = cod_cliente;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cod_cliente=" + codCliente + ", nombre=" + nombre + ", telefono=" + telefono + '}';
    }

}
