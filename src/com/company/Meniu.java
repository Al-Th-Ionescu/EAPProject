package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

public class Meniu {
    private static Meniu men;

    Meniu(){
    }

    public static Meniu getInstance(){
        if (men==null){
            men = new Meniu();
        }
            return men;
    }

    public void showMenu(){
        System.out.println("In aceasta gradina zoologica este loc pentru 5 animale!\n\n");
        System.out.println("Alegeti optiunea dorita!");
        System.out.println("1- Tipariti bilet pentru copil");
        System.out.println("2- Tipariti bilet pentru student");
        System.out.println("3-Tipariti bilet pentru adult");
        System.out.println("4- Afisati numarul total de vizitatori si incasarile obtinute");
        System.out.println("5-Afisati numarul total de copii si incasarile obtinute din vanzarea acestor bilete");
        System.out.println("6-Afisati numarul total de studenti si incasarile obtinute din vanzarea acestor bilete");
        System.out.println("7-Afisati numarul total de adulti si incasarile obtinute din vanzarea acestor bilete");
        System.out.println("8- Afisati toti vizitatorii ordonati dupa varsta");
        System.out.println("9- Afisati numarul total de animale aflate in aceasta gradina zoologica");
        System.out.println("10- Afisati numarul animalelor carnivore aflate in aceasta gradina zoologica");
        System.out.println("11- Afisati numarul animalelor erbivore aflate in aceasta gradina zooloica");
        System.out.println("12- Adaugati un nou leu (primit de la alta gradina zoologica)");
        System.out.println("13- Nasterea unui nou leu in captivitate");
        System.out.println("14- Adaugati o zebra noua (primita de la alta gradina zoologica)");
        System.out.println("15- Nasterea unei noi zebre in captivitate");
        System.out.println("16- Afisati toate animalele din gradina zoologica");
    }

    public void MeniuUse() {
        showMenu();
        Animal[] a = new Animal[5];
        Scanner scanner = new Scanner(System.in);
        int optiune = 0;
        int i = 0;
        String nume;
        int varsta;
        String prenume;
        int cantitateHrana;
        ArrayList<Vizitator> viz = new ArrayList<>();
        Citeste_Copii.Citeste_Copil(viz);
        Citeste_Studenti.Citeste_Student(viz);
        Citeste_Adulti.Citeste_Adult(viz);
        while (optiune >= -1 && optiune <= 16) {
            System.out.println("Introduceti optiunea: ");
            optiune = scanner.nextInt();
            switch (optiune) {
                case 1 -> {
                    System.out.println("Nume: ");
                    nume = scanner.next();
                    System.out.println("Prenume: ");
                    scanner.skip("\n");
                    prenume = scanner.nextLine();
                    System.out.println("Varsta: ");
                    varsta = scanner.nextInt();
                    viz.add(new Copil(nume, prenume, varsta));
                    Scrie_Copii.Scrie_Copil(nume,prenume,varsta);
                }
                case 2 -> {
                    System.out.println("Nume: ");
                    nume = scanner.next();
                    System.out.println("Prenume: ");
                    scanner.skip("\n");
                    prenume = scanner.nextLine();
                    System.out.println("Varsta: ");
                    varsta = scanner.nextInt();
                    viz.add(new Student(nume, prenume, varsta));
                    Scrie_Student.Scrie_Stud(nume,prenume,varsta);
                }
                case 3 -> {
                    System.out.println("Nume: ");
                    nume = scanner.next();
                    System.out.println("Prenume: ");
                    scanner.skip("\n");
                    prenume = scanner.nextLine();
                    System.out.println("Varsta: ");
                    varsta = scanner.nextInt();
                    viz.add(new Adult(nume, prenume, varsta));
                    Scrie_Adulti.Scrie_Adult(nume,prenume,varsta);
                }
                case 4 -> {
                    Vizitator.printNr_Vizitatori();
                    Vizitator.printIncasariTotale();
                }
                case 5 -> {
                    Copil.printNr_Copii();
                    Copil.printIncasareTotalaCopii();
                }
                case 6 -> {
                    Student.printNr_Studenti();
                    Student.printIncasareTotalaStudenti();
                }
                case 7 -> {
                    Adult.printNr_Adulti();
                    Adult.printIncasareTotalaAdulti();
                }
                case 8 ->{
                    viz.sort(Vizitator::compareTo);
                    for (Vizitator vizitator : viz)
                        vizitator.printVizitator();

                }
                case 9 -> {
                    Animal.printNr_Animale();
                }
                case 10 -> {
                    Carnivor.printNr_Carnivore();
                }
                case 11 -> {
                    Erbivor.printNr_Erbivore();
                }
                case 12 -> {
                    System.out.println("Varsta leului: ");
                    varsta = scanner.nextInt();
                    System.out.println("Cantitatea de carne consumata zilnic de leu:");
                    cantitateHrana = scanner.nextInt();
                    a[i] = new Leu("leu", varsta, cantitateHrana);
                    i++;
                }
                case 13 -> {
                    int nr=0;
                    for (int j = 0; j < a.length && a[j] != null; j++)
                     if (a[j].getSpecie().equals("Leu")) {
                            nr++;
                            if (nr==2)
                            break;
                            else
                                a[j].se_inmulteste(a);
                        }
                    if (nr==0)
                        System.out.println("Nu exista lei in gradina zoologica!");
                }
                case 14 -> {
                    System.out.println("Varsta zebrei: ");
                    varsta = scanner.nextInt();
                    System.out.println("Cantitatea de iarba consumata zilnic de zebra: ");
                    cantitateHrana = scanner.nextInt();
                    a[i] = new Zebra("zebra", varsta, cantitateHrana);
                    i++;
                }
                case 15 -> {
                    int nr=0;
                    for (int j = 0; j < a.length && a[j] != null; j++)
                        if (a[j].getSpecie().equals("Zebra")) {
                            nr++;
                            if (nr==2)
                                break;
                            else
                                a[j].se_inmulteste(a);
                    }
                    if (nr==0)
                        System.out.println("Nu exista zebre in gradina zoologica!");
                }
                case 16 -> {
                    for (int j = 0; j < a.length && a[j] != null; j++)
                        a[j].printAnimal();
                }
            }
        }
            scanner.close();
    }
}
