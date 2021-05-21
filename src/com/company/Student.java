package com.company;

public class Student extends Vizitator implements Comparable<Vizitator>{
    private static final double reducere=0.25;
    private static int nr_studenti=0;
    private static double incasare;

    public Student(String nume, String prenume, int varsta) {
        super(nume, prenume, varsta);
        this.bilet.pret = bilet.getPret() - (reducere * bilet.getPret());
        nr_studenti++;
        incasare=bilet.pret;
    }

    public  Student(int id_vizitator,String nume, String prenume, int varsta){
        super(id_vizitator,nume,prenume,varsta);
        nr_studenti++;
        this.bilet.pret = bilet.getPret() - (reducere * bilet.getPret());
        incasare=bilet.pret;
    }
    @Override
    public void printVizitator(){
        System.out.println("~~~~~~STUDENT~~~~~~");
        super.printVizitator();
        System.out.println("Bilet pentru student cu pretul de "+bilet.getPret()+" RON\n");
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

    public static void setNr_studenti() {
        Student.nr_studenti = 0;
    }

    @Override
    public int compareTo(Vizitator o) {
        return this.varsta-o.varsta;
    }
}
