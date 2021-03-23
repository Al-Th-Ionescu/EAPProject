package com.company;



public class Main {

    public static void main(String[] args) {
        Vizitator [] viz = new Vizitator[5];
        viz[0] = new Copil("Popescu","Andrei",4);
        viz[1]= new Adult("Iftime","Sorin",42);
        viz[2]= new Student("Marinescu","Florina",22);
        viz[3]= new Copil("Nume_Copil","Prenume_Copil",5);
        viz[4]=new Adult("Adult1","Adult1",44);
        System.out.println(" ");
        for (Vizitator vizitator : viz)
            vizitator.printVizitator();
        Vizitator.printNr_Vizitatori();
        System.out.println(" ");
        System.out.println(" ");
        Copil.printNr_Copii();
        Adult.printNr_Adulti();
        Student.printNr_Studenti();
        System.out.println(" ");
        System.out.println(" ");
        Copil.printIncasareTotalaCopii();
        Student.printIncasareTotalaStudenti();
        Adult.printIncasareTotalaAdulti();
        Vizitator.printIncasariTotale();
        System.out.println(" ");
        System.out.println(" ");
        Animal []a= new Animal[5];
        a[0]= new Leu("leu",2,75);
        a[1]= new Leu("leu",3,80);
        a[2]= new Zebra("zebra",10,5);
        a[2].se_inmulteste(a);
        a[1].se_inmulteste(a);
        a[0].se_inmulteste(a);
        Leu.printNr_Lei(a);
        for (int i=0;i<a.length && a[i]!=null;i++)
            a[i].printAnimal();
        Animal.printNr_Animale();
        Carnivor.printNr_Carnivore();
        Erbivor.printNr_Erbivore();
        Leu.printNr_Lei(a);
        Zebra.printNr_Zebre(a);
        System.out.println(" ");
        a[1].doarme();
        a[2].doarme();
        a[2].mananca();
    }
}
