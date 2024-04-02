package org.model;

import java.math.BigDecimal;

public class Tv extends Product{

    private int dimensions;
    private boolean smart;

    public Tv(String nome, String marca, BigDecimal prezzo, BigDecimal iva, int dimensions, boolean smart) {
        super(nome, marca, prezzo, iva);
        this.dimensions = dimensions;
        this.smart = smart;
    }

    public int getDimensions() {
        return dimensions;
    }

    public boolean isSmart() {
        return smart;
    }
}
