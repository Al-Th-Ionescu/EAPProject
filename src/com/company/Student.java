package com.company;

public class Student extends Vizitator{
    private static final double reducere=0.25;
    private static int nr_studenti=0;
    private static double incasare;

    public Student(String nume, String prenume, int varsta) {
        super(nume, prenume, varsta);
        this.bilet.pret = bilet.getPret() - (reducere * bilet.getPret());
        nr_studenti++;
        incasare=bilet.pret;
    }

    @Override
    public void printVizitator(){
        super.printVizitator();
        System.out.println("Bilet pentru student cu pretul de "+bilet.getPret()+" RON");
    }

    public static int getNr_Studenti() {
        return nr_studenti;
    }

    public static void printNr_Studenti(){
        System.out.println("Au fost vandute "+getNr_Studenti()+" bilete pentru studenti.");
    }

    public static double getIncasareTotala(){
        return nr_studenti*incasare;
    }

    public static void printIncasareTotalaStudenti(){
        System.out.println("S-au incasat "+ Student.getIncasareTotala()+" RON din biletele pentru studenti.");
    }
}
