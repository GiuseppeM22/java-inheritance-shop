package org.model;

import java.math.BigDecimal;

public class Smartphone extends Product{
    private int imei;
    private int memory;

    public Smartphone(String nome, String marca, BigDecimal prezzo, BigDecimal iva, int imei, int memory) {
        super(nome, marca, prezzo, iva);
        this.imei = imei;
        this.memory = memory;
    }

    public int getImei() {
        return imei;
    }

    public int getMemory() {
        return memory;
    }
}
