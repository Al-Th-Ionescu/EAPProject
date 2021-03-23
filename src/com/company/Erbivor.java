package com.company;

public class Erbivor extends Animal{
    private static int  nr_erbivore=0;

    public Erbivor(String specie, int varsta,int cantitateHrana) {
        super(specie, varsta);
        this.cantitateHrana=cantitateHrana;
        nr_erbivore++;
    }

    @Override
    public void doarme() {
        System.out.println("Animalul erbivor doarme. Zzz");
    }

    @Override
    public void mananca() {
        System.out.println("Animalul erbivor consuma "+getCantitateHrana()+" kg de hrana.");
    }

    @Override
    public Animal[] se_inmulteste(Animal[] a) {
        return a;
    }

    @Override
    public void printAnimal() {
        System.out.println("~~~Animal erbivor din specia "+getSpecie()+" de "+getVarsta()+ " ani, care consuma "+getCantitateHrana()+" kg de frunze.");
    }

    public static void printNr_Erbivore(){
        System.out.println("La aceasta gradina zoologica se afla "+nr_erbivore+" animale erbivore!");
    }
}
