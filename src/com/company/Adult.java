package com.company;

public class Adult extends Vizitator{
    private static int nr_adulti=0;
    private static double incasare;

    public Adult(String nume, String prenume, int varsta) {
        super(nume, prenume, varsta);
        this.bilet.pret=bilet.getPret();
        nr_adulti++;
        incasare=bilet.pret;
    }

    @Override
    public void printVizitator(){
        super.printVizitator();
        System.out.println("Bilet pentru adult cu pretul de " +bilet.getPret()+ " RON" );
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
}
