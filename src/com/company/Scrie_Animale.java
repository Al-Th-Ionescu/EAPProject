package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Scrie_Animale {

    private final static String path = "src/com/company/Animale.csv";

    public static void Scrie_Animal(String nume_animal, String ordin_animal, int varsta, int hrana) {
        try {
            FileWriter wr = new FileWriter(path, true);
            StringBuilder sb = new StringBuilder();
            sb.append(nume_animal);
            sb.append(",");
            sb.append(ordin_animal);
            sb.append(",");
            sb.append(varsta);
            sb.append(",");
            sb.append(hrana);
            sb.append("\n");
            wr.write(sb.toString());
            wr.flush();
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}