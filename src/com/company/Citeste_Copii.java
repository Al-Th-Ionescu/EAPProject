package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Citeste_Copii {

    private final static String path = "src/com/company/Copii.csv";




    public static void Citeste_Copil(ArrayList<Vizitator> v) {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                v.add(new Copil(Integer.parseInt(values[0]),values[1], values[2], Integer.parseInt(values[3])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
