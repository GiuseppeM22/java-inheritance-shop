package org.model;

import java.math.BigDecimal;

public class Headphones extends Product{

    private String color;
    private boolean wireless;
    private boolean wired;

    public Headphones(String nome, String marca, BigDecimal prezzo, BigDecimal iva) {
        super(nome, marca, prezzo, iva);
    }
}
