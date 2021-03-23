package com.company;

public class Leu extends Carnivor{

    private static int nr_lei=0;

    public Leu(String specie, int varsta, int cantitateHrana) {
        super(specie, varsta, cantitateHrana);
        nr_lei++;
    }

    @Override
    public void doarme() {
        System.out.println("Leul doarme. Zzz");
    }

    @Override
    public void mananca() {
        System.out.println("Leul, animal carnivor, consuma "+getCantitateHrana()+" kg de hrana.");
    }

    @Override
    public Animal[] se_inmulteste(Animal[] a) {
        int counter=0;
        for (int i=0;i<a.length && a[i]!=null;i++){
            if (a[i].getClass()==this.getClass())
                counter++;
        }
        if (counter>1) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == null) {
                    System.out.println("Un nou leu s-a alaturat gradinii zoologice!");
                    a[i] = new Leu(specie, 0, 3);
                    break;
                }
                if (i==a.length-1)
                    System.out.println("Nu este destul spatiu in gradina zoologica!");
            }
        }
        else
            System.out.println("Leul este singur!");
        return a;
    }

    @Override
    public void printAnimal() {
        if (getVarsta()>0)
        System.out.println("~~~"+getSpecie()+" de "+getVarsta()+ " ani, care consuma "+getCantitateHrana()+" kg de carne.");
        else
            System.out.println("~~~Puiul de "+getSpecie()+" este hranit cu lapte.");
    }

    private static int getNr_pui(Animal[] a){
        int counter=0;
        for (int i=0;i<a.length && a[i]!=null;i++)
        if (a[i].getVarsta()==0 && a[i].getSpecie().equals("Leu"))
                counter++;
        return counter;
    }
    public static void printNr_Lei(Animal[] a){
        if (getNr_pui(a)>0)
            System.out.println("La aceasta gradina zoologica se afla "+nr_lei+" lei, dintre care "+ getNr_pui(a)+" sunt pui!");
        else
            System.out.println("La aceasta gradina zoologica se afla "+nr_lei+" lei adulti!");
    }
}
