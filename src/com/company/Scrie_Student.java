package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class Scrie_Student {

    private final static String path = "src/com/company/Studenti.csv";


    public static void Scrie_Stud(int index,String Nume,String Prenume,int Varsta)
    {
        FileWriter wr;
        try {
            wr = new FileWriter((path),true);
            StringBuilder sb= new StringBuilder();
            sb.append(index);
            sb.append(",");
            sb.append(Nume);
            sb.append(",");
            sb.append(Prenume);
            sb.append(",");
            sb.append(Integer.toString(Varsta));
            sb.append("\n");
            wr.write(sb.toString());
            wr.flush();
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
