package com.company;


import java.util.Comparator;

public class Copil extends Vizitator implements Comparable<Vizitator> {
    private static final double reducere=0.5;
    private static int nr_copii=0;
    private static double incasare;

    public Copil(String nume, String prenume, int varsta) {
        super(nume, prenume, varsta);
        this.bilet.pret = bilet.getPret() - (reducere * bilet.getPret());
        nr_copii++;
        incasare=bilet.pret;
    }



    @Override
    public void printVizitator(){
        System.out.println("~~~~~~COPIL~~~~~~");
    super.printVizitator();
        System.out.println("Bilet pentru copil cu pretul de "+bilet.getPret()+" RON\n");
    }

    public static int getNr_Copii() {
        return nr_copii;
    }

    public static void printNr_Copii(){
        System.out.println("Au fost vandute " + getNr_Copii()+ " bilete pentru copii.");
    }

    public static double getIncasareTotala(){
        return nr_copii*incasare;
    }

    public static void printIncasareTotalaCopii(){
        System.out.println("S-au incasat "+Copil.getIncasareTotala()+" RON din biletele pentru copii.");
    }


    @Override
    public int compareTo(Vizitator o) {
        return this.varsta-o.varsta;
    }
}
