package com.company;



public abstract class Vizitator implements Comparable<Vizitator> {
    protected String nume;
    protected String prenume;
    protected int varsta;
    protected Bilet bilet;
    private static int nr_vizitatori=0;
    private int id_vizitator;


    public Vizitator(String nume, String prenume, int varsta){
        this.nume=nume;
        this.prenume=prenume;
        this.varsta=varsta;
        bilet=new Bilet();
        nr_vizitatori++;
        this.id_vizitator=nr_vizitatori;
    }

    public Vizitator(int id_vizitator,String nume, String prenume, int varsta){
        this.id_vizitator=id_vizitator;
        this.nume=nume;
        this.prenume=prenume;
        this.varsta=varsta;
        nr_vizitatori++;
        bilet=new Bilet();
    }



    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public int getId_vizitator(){return id_vizitator;}


    public void printVizitator(){
        System.out.println("ID Vizitator:"+getId_vizitator());
        System.out.println("Nume:"+getNume());
        System.out.println("Prenume:"+getPrenume());
        System.out.println("Varsta:"+getVarsta());
    }

    public static int getNr_vizitatori() {
        return nr_vizitatori;
    }

    public static void printNr_Vizitatori(){
        System.out.println("Au fost vandute "+getNr_vizitatori()+" bilete.");
    }

    private static double getIncasariTotale(){
        return Student.getIncasareTotala()+Adult.getIncasareTotala()+Copil.getIncasareTotala();
    }

    public static void printIncasariTotale(){
        System.out.println("S-au incasat in total " +getIncasariTotale()+" RON din vanzarile de bilete.");
    }

    public static void setNr_vizitatori() {
        Vizitator.nr_vizitatori =0;
    }

    @Override
    public int compareTo(Vizitator o) {
        return this.varsta-o.varsta;
    }
}
