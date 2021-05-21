package com.company;

import java.util.Comparator;

public class Adult extends Vizitator implements Comparable<Vizitator> {
    private static int nr_adulti=0;
    private static double incasare;

    public Adult(String nume, String prenume, int varsta) {
        super(nume, prenume, varsta);
        this.bilet.pret=bilet.getPret();
        nr_adulti++;
        incasare=bilet.pret;
    }

    public Adult(int id_vizitator, String nume, String prenume, int varsta){
        super(id_vizitator,nume,prenume,varsta);
        nr_adulti++;
        incasare=bilet.pret;
    }

    @Override
    public void printVizitator(){
        System.out.println("~~~~~~ADULT~~~~~~");
        super.printVizitator();
        System.out.println("Bilet pentru adult cu pretul de " +bilet.getPret()+ " RON\n" );
    }

    public static int getNr_Adulti() {
        return nr_adulti;
    }

    public static void printNr_Adulti(){
        System.out.println("Au fost vandute "+getNr_Adulti()+" bilete pentru adulti.");
    }

    public static double getIncasareTotala(){
        return nr_adulti*incasare;
    }

    public static void printIncasareTotalaAdulti(){
        System.out.println("S-au incasat "+Adult.getIncasareTotala()+" RON din biletele pentru adulti.");
    }

    public static void setNr_adulti() {
        Adult.nr_adulti = 0;
    }

    @Override
    public int compareTo(Vizitator o) {
        return this.varsta-o.varsta;
    }
}
