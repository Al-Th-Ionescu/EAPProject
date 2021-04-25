package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class Citeste_Animale {

    private final static String path="src/com/company/Animale.csv";

    public static void Citeste_Animal(Animal[] a,int j) {
        BufferedReader br;
        try {
            int i=0;
            br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].toLowerCase().equals("leu"))
                    a[i] = new Leu(values[0], Integer.parseInt(values[2]), Integer.parseInt(values[3]));
                else
                    a[i] = new Zebra(values[0], Integer.parseInt(values[2]), Integer.parseInt(values[3]));
                i++;
            }
            j=i;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
