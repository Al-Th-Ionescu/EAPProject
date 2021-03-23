package com.company;

public class Carnivor extends Animal{
    protected static int nr_carnivore=0;

    public Carnivor(String specie, int varsta, int cantitateHrana) {
        super(specie, varsta);
        this.cantitateHrana=cantitateHrana;
        nr_carnivore++;
    }

    @Override
    public void doarme() {
        System.out.println("Animalul carnivor doarme. Zzz");
    }

    @Override
    public void mananca() {
        System.out.println("Animalul carnivor consuma "+getCantitateHrana()+" kg de carne.");
    }

    @Override
    public Animal[] se_inmulteste(Animal[] a) {
        return a;
    }

    @Override
    public void printAnimal() {
        System.out.println("~~~Animal carnivor din specia "+getSpecie()+" de "+getVarsta()+ " ani, care consuma "+getCantitateHrana()+" kg de carne.");
    }

    public static void printNr_Carnivore(){
        System.out.println("La aceasta gradina zoologica se afla "+nr_carnivore+" animale carnivore!");
    }
}
