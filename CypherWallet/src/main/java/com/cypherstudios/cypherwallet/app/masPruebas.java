/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cypherstudios.cypherwallet.app;

import java.util.*;
import java.lang.*;
import java.io.*;

import java.lang.reflect.Field;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone {

    public String quesito = "test";
    public String lechita = "test2";
    public String lechita2 = "test3";

    public static void main(String[] args) {

        Ideone t = new Ideone();
        for (Field f : t.getClass().getFields()) {

            System.out.println("nombre instancia: " + f.getName());
        }
    }
}
