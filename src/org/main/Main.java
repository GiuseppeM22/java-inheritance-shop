package org.main;

import org.model.Product;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Product p = new Product("prodotto", "Buona", new BigDecimal("12.23"), 22);
        System.out.println(p.toString());
    }
}
