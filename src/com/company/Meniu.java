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
        System.out.println("In aceasta gradina zoologica este loc pentru 20 animale!\n\n");
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
        Animal[] a = new Animal[20];
        Scanner scanner = new Scanner(System.in);
        int optiune = 0;
        int i =0;
        String nume;
        int varsta;
        String prenume;
        int cantitateHrana;
        ArrayList<Vizitator> viz = new ArrayList<>();
        Citeste_Copii.Citeste_Copil(viz);
        Citeste_Studenti.Citeste_Student(viz);
        Citeste_Adulti.Citeste_Adult(viz);
        Citeste_Animale.Citeste_Animal(a,i);
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
                    ServiciuAudit.Scrie_Audit("Adaugat copil");
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
                    ServiciuAudit.Scrie_Audit("Adaugat student");
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
                    ServiciuAudit.Scrie_Audit("Adaugat adult");
                }
                case 4 -> {
                    Vizitator.printNr_Vizitatori();
                    Vizitator.printIncasariTotale();
                    ServiciuAudit.Scrie_Audit("Vizualizat numar total vizitatori + incasari totale");
                }
                case 5 -> {
                    Copil.printNr_Copii();
                    Copil.printIncasareTotalaCopii();
                    ServiciuAudit.Scrie_Audit("Numarul de copii +  incasari");
                }
                case 6 -> {
                    Student.printNr_Studenti();
                    Student.printIncasareTotalaStudenti();
                    ServiciuAudit.Scrie_Audit("Numarul de studenti + incasari");
                }
                case 7 -> {
                    Adult.printNr_Adulti();
                    Adult.printIncasareTotalaAdulti();
                    ServiciuAudit.Scrie_Audit("Numarul de adulti + incasari");
                }
                case 8 ->{
                    viz.sort(Vizitator::compareTo);
                    for (Vizitator vizitator : viz)
                        vizitator.printVizitator();
                    ServiciuAudit.Scrie_Audit("Afisarea vizitatorilor ordonati dupa varsta");
                }
                case 9 -> {
                    Animal.printNr_Animale();
                    ServiciuAudit.Scrie_Audit("Afisarea numarului total de animale");
                }
                case 10 -> {
                    Carnivor.printNr_Carnivore();
                    ServiciuAudit.Scrie_Audit("Afisarea numarului de animale carnivore");
                }
                case 11 -> {
                    Erbivor.printNr_Erbivore();
                    ServiciuAudit.Scrie_Audit("Afisarea numarului de animale erbivore.");
                }
                case 12 -> {
                    System.out.println("Varsta leului: ");
                    varsta = scanner.nextInt();
                    System.out.println("Cantitatea de carne consumata zilnic de leu:");
                    cantitateHrana = scanner.nextInt();
                    a[i] = new Leu("leu", varsta, cantitateHrana);
                    i++;
                    ServiciuAudit.Scrie_Audit("Adaugarea unui nou leu");
                    Scrie_Animale.Scrie_Animal("Leu","Carnivor",varsta,cantitateHrana);
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
                    ServiciuAudit.Scrie_Audit("S-a incercat inmultirea leilor");

                }
                case 14 -> {
                    System.out.println("Varsta zebrei: ");
                    varsta = scanner.nextInt();
                    System.out.println("Cantitatea de iarba consumata zilnic de zebra: ");
                    cantitateHrana = scanner.nextInt();
                    a[i] = new Zebra("zebra", varsta, cantitateHrana);
                    i++;
                    ServiciuAudit.Scrie_Audit("Adaugarea unei noi zebre");
                    Scrie_Animale.Scrie_Animal("Zebra","Erbivor",varsta,cantitateHrana);
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
                    ServiciuAudit.Scrie_Audit("S-a incercat inmultirea leilor");
                }
                case 16 -> {
                    for (int j = 0; j < a.length && a[j] != null; j++)
                        a[j].printAnimal();
                    ServiciuAudit.Scrie_Audit("S-au afisat toate animalele");
                }
            }
        }
            scanner.close();
    }
}
