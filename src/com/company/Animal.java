package com.company;



public abstract class Animal implements animal_behavior{
    protected String specie;
    protected int varsta;
    protected int cantitateHrana;
    static protected int nr_animale=0;

    public Animal(String specie, int varsta) {
        this.specie = specie;
        this.varsta = varsta;
        nr_animale++;
    }

    public String getSpecie() {
        return specie.substring(0,1).toUpperCase()+specie.substring(1).toLowerCase();
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public int getCantitateHrana() {
        return cantitateHrana;
    }

    public void setCantitateHrana(int cantitateHrana) {
        this.cantitateHrana = cantitateHrana;
    }

    @Override
    public void doarme() {
        System.out.println("Animalul doarme. Zzz");
    }

    @Override
    public void mananca() {
        System.out.println("Animalul consuma "+getCantitateHrana()+" kg de hrana.");
    }

    @Override
    public Animal[] se_inmulteste(Animal []a) {
        return a;
    }


    public static void printNr_Animale(){
        System.out.println("La aceasta gradina zoologica se afla "+nr_animale+" animale!");
    }

    public void printAnimal(){
        System.out.println("~~~Animal din specia "+getSpecie()+" de "+getVarsta()+ " ani, care consuma "+getCantitateHrana()+" kg de hrana.");
    }
}
