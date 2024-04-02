package org.main;

import org.model.Headphones;
import org.model.Product;
import org.model.Smartphone;
import org.model.Tv;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class Cart {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Quanti prodotti vuoi acquistare? ");
        int size = Integer.parseInt(scan.nextLine());

        Product[] product = new Product[size];

        System.out.println("Inserisci il tipo di dispositivo (S per Smartphone, T per Televisore, C per Cuffie, E per uscire):");
        String scelta = scan.nextLine().toUpperCase();

        for (int i = 0; i < product.length; i++) {

            switch (scelta) {
                case "S":
                    String[] smartphoneInfo = acquireProductInfo(scan);

                    System.out.print("Imai Smartphone: ");
                    int imai = Integer.parseInt(scan.nextLine());
                    System.out.print("Memory Smartphone: ");
                    int memory = Integer.parseInt(scan.nextLine());

                    Smartphone smartphone = new Smartphone(smartphoneInfo[0], smartphoneInfo[1], new BigDecimal(smartphoneInfo[2]), new BigDecimal(smartphoneInfo[3]), imai, memory);
                    product[i] = smartphone;
                    break;
                case "T":
                    String[] tvInfo = acquireProductInfo(scan);

                    System.out.print("Dimensioni Smartphone: ");
                    int dimensioni = Integer.parseInt(scan.nextLine());
                    System.out.print("Smart? ");
                    boolean smart = scan.nextBoolean();

                    Tv tv = new Tv(tvInfo[0], tvInfo[1], new BigDecimal(tvInfo[2]), new BigDecimal(tvInfo[3]), dimensioni, smart);
                    product[i] = tv;
                    break;
                case "C":
                    // TODO: aggiungere attributi in più della classe cuffie
                    String[] headphonesInfo = acquireProductInfo(scan);
                    Headphones headphones = new Headphones(headphonesInfo[0], headphonesInfo[1], new BigDecimal(headphonesInfo[2]), new BigDecimal(headphonesInfo[3]));
                    product[i] = headphones;
                    break;
                case "E":
                    System.out.println("Uscita dal menu...");
                    scan.close();
                    System.exit(0);
                default:
                    System.out.println("Scelta non valida.");
            }

        }
        //definisco una variabile per fare nel ciclo la somma del prezzp dei prodotti
        BigDecimal totale = BigDecimal.ZERO;
        // ciclo sull'array di prodotti creato prima
        for (Product products : product) {
            if (products != null) {
                totale = totale.add(products.getPrezzoConIva());
                System.out.println();
                System.out.println("*****************");
                System.out.println("Nome prodotto: " + products.getNome());
                System.out.println("Marca: " + products.getMarca());
                System.out.println("Prezzo: " + products.getPrezzo() + "€");
                System.out.println("Prezzo con iva: " + products.getPrezzoConIva() + "€");


                // Verifichiamo il tipo dell'oggetto di prodotto
                if (products instanceof Smartphone) {
                    Smartphone smartphone = (Smartphone) products;
                    System.out.println("Imai Smartphone: " + smartphone.getImei());
                    System.out.println("Memory Smartphone: " + smartphone.getMemory());
                } else if (products instanceof Tv) {
                    Tv tv = (Tv) products;
                    System.out.println("Dimensioni Tv: " + tv.getDimensions());
                    System.out.println("Smart? " + tv.isSmart());
                }
                System.out.println("---------------------");

            }

        }
        System.out.println("TOTALE: " + totale + "€");

    }

    //metodo per evitare di essere ripetitivi nello switch case
    public static String[] acquireProductInfo(Scanner scan) {
        String[] productInfo = new String[4];

        System.out.print("Nome: ");
        productInfo[0] = scan.nextLine();

        System.out.print("Marca: ");
        productInfo[1] = scan.nextLine();

        System.out.print("Prezzo: ");
        productInfo[2] = scan.nextLine();

        System.out.print("Iva: ");
        productInfo[3] = scan.nextLine();

        return productInfo;
    }


}

