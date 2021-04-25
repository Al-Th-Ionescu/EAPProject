package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class ServiciuAudit {

    private final static String path="src/com/company/ServiciuAudit.csv";

    public static void Scrie_Audit(String numeActiune){
        try {
            FileWriter wr=new FileWriter(path,true);
            StringBuilder sb= new StringBuilder();
            sb.append(numeActiune);
            sb.append(",");

            Date data= new Date();

            sb.append(data);
            sb.append("\n");
            wr.write(sb.toString());
            wr.flush();
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
