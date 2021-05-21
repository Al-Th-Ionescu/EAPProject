package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class Scrie_Adulti {
    private final static String path = "src/com/company/Adulti.csv";


    public static void Scrie_Adult(int index,String Nume,String Prenume,int Varsta)
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
