package org.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Product {
    //ATTRIBUTI
    private Integer codice;
    private String nome;
    private String marca;

    private BigDecimal prezzo;
    private BigDecimal iva;

    //COSTRUTTORE
    public Product() {
    }

    public Product(String nome) {
        this.nome = nome;
    }

    public Product(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public Product(String nome, String marca, BigDecimal prezzo, BigDecimal iva) {
        this.codice = randomNumber();
        this.nome = nome;
        this.marca = marca;
        this.prezzo = prezzo;
        this.iva = iva;
    }

    //METODI GETTER - SOLO LETTURA
    public Integer getCodice() {
        return codice;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }
    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public BigDecimal getIva() {
        return iva;
    }

    // ALTRI METODI GETTER
    public BigDecimal getPrezzoConIva() {
        // price + price * vat
        return prezzo.add(prezzo.multiply(iva)).setScale(2, RoundingMode.HALF_EVEN);
    }

    public String getNomeConIva() {
        Random random = new Random();
        codice = random.nextInt(100000000);
        String codiceFormattato = String.format("%08d", codice);
        return codiceFormattato + "-" + nome;
    }

    //SETTER - SCRITTURA

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    //METODI GENERICI
    public static int randomNumber(){
        Random random = new Random();
        return random.nextInt(100000000);
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "codice=" + codice +
                ", nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", prezzo=" + prezzo +
                ", iva=" + iva +
                '}';
    }
}
