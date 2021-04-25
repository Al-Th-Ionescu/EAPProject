package com.company;

public class Zebra extends  Erbivor{

    private static int nr_zebre=0;

    public Zebra(String specie, int varsta, int cantitateHrana) {
        super(specie, varsta, cantitateHrana);
        nr_zebre++;
    }
    @Override
    public void doarme() {
        System.out.println("Zebra doarme. Zzz");
    }

    @Override
    public void mananca() {
        System.out.println("Zebra, animal erbivor, consuma "+getCantitateHrana()+" kg de hrana.");
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
                    System.out.println("O noua zebra s-a alaturat gradinii zoologice!");
                    a[i] = new Leu(specie, 0, 3);
                    Scrie_Animale.Scrie_Animal("Zebra","Erbivor",0,3);
                    break;
                }
                if (i==a.length-1)
                    System.out.println("Nu este destul spatiu in gradina zoologica!");
            }
        }
        else
            System.out.println("Zebra este singura!");
        return a;
    }

    @Override
    public void printAnimal() {
        if (getVarsta()>0)
            System.out.println("~~~"+getSpecie()+" de "+getVarsta()+ " ani, care consuma "+getCantitateHrana()+" kg de frunze.");
        else
            System.out.println("~~~Puiul de "+getSpecie()+" este hranit cu lapte.");
    }

    private static int getNr_pui(Animal[] a){
        int counter=0;
        for (int i=0;i<a.length && a[i]!=null;i++)
            if (a[i].getVarsta()==0 && a[i].getSpecie().equals("Zebra"))
                counter++;
        return counter;
    }
    public static void printNr_Zebre(Animal[] a){
        if (getNr_pui(a)>0)
            System.out.println("La aceasta gradina zoologica se afla "+nr_zebre+" zebre, dintre care "+ getNr_pui(a)+" sunt pui!");
        else
            System.out.println("La aceasta gradina zoologica se afla "+nr_zebre+" zebre adulte!");
    }
}
