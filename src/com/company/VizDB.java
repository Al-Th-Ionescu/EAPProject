package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.SocketHandler;

public class VizDB {

    private static final String dbURL="jdbc:oracle:thin:@localhost:1521:xe";
    private static final String username="ADMINPIZZA";
    private static final String password="password2";

    public static void AddVizDB(Vizitator v){
        try {
            Connection con = DriverManager.getConnection(dbURL, username, password);
            String query;
            if (v.getClass().toString().equals("class com.company.Copil"))
                query="insert into VIZITATOR(ID_VIZITATOR,STATUS,NUME,PRENUME,VARSTA) values ("+v.getId_vizitator()+",'Copil','"+v.getNume()+"','"+v.getPrenume()+"',"+v.getVarsta()+")";
            else if (v.getClass().toString().equals("class com.company.Student"))
                query="insert into VIZITATOR(ID_VIZITATOR,STATUS,NUME,PRENUME,VARSTA) values ("+v.getId_vizitator()+",'Student','"+v.getNume()+"','"+v.getPrenume()+"',"+v.getVarsta()+")";
            else
                query="insert into VIZITATOR(ID_VIZITATOR,STATUS,NUME,PRENUME,VARSTA) values ("+v.getId_vizitator()+",'Adult','"+v.getNume()+"','"+v.getPrenume()+"',"+v.getVarsta()+")";
            PreparedStatement ps= con.prepareStatement(query);
            ps.execute();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void AfisareVizDB(){
        try {
            Connection con = DriverManager.getConnection(dbURL, username, password);
            String query="SELECT * FROM VIZITATOR";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id_vizitator = rs.getInt("ID_VIZITATOR");
                String status= rs.getString("STATUS");
                String Nume = rs.getString("NUME");
                String Prenume = rs.getString("PRENUME");
                int varsta = rs.getInt("VARSTA");
                System.out.format("~~~~~~~~\n ID vizitator: %s \n Tip: %s \n Nume: %s \n Prenume: %s \n Varsta: %s\n\n", id_vizitator, status, Nume, Prenume, varsta);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void LoadCopii(ArrayList<Vizitator> v){
        try {
            Copil.setNr_copii();
            Connection con = DriverManager.getConnection(dbURL, username, password);
            String query="SELECT * FROM VIZITATOR WHERE STATUS='Copil'";
            Statement statement= con.createStatement();
            ResultSet rs= statement.executeQuery(query);
            while (rs.next()){
                int id_vizitator=rs.getInt("ID_VIZITATOR");
                String nume= rs.getString("NUME");
                String prenume = rs.getString("PRENUME");
                int varsta= rs.getInt("VARSTA");
                v.add(new Copil(id_vizitator,nume,prenume,varsta));
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void LoadStudenti(ArrayList<Vizitator> v){
        try {
            Student.setNr_studenti();
            Connection con = DriverManager.getConnection(dbURL, username, password);
            String query="SELECT * FROM VIZITATOR WHERE STATUS='Student'";
            Statement statement= con.createStatement();
            ResultSet rs= statement.executeQuery(query);
            while (rs.next()){
                int id_vizitator=rs.getInt("ID_VIZITATOR");
                String nume= rs.getString("NUME");
                String prenume = rs.getString("PRENUME");
                int varsta= rs.getInt("VARSTA");
                v.add(new Student(id_vizitator,nume,prenume,varsta));
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void LoadAdulti(ArrayList<Vizitator> v){
        try {
            Adult.setNr_adulti();
            Connection con = DriverManager.getConnection(dbURL, username, password);
            String query="SELECT * FROM VIZITATOR WHERE STATUS='Adult'";
            Statement statement= con.createStatement();
            ResultSet rs= statement.executeQuery(query);
            while (rs.next()){
                int id_vizitator=rs.getInt("ID_VIZITATOR");
                String nume= rs.getString("NUME");
                String prenume = rs.getString("PRENUME");
                int varsta= rs.getInt("VARSTA");
                v.add(new Adult(id_vizitator,nume,prenume,varsta));
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void EditViz(ArrayList<Vizitator> v){
        try {
            Scanner scanner= new Scanner(System.in);
            Connection con = DriverManager.getConnection(dbURL,username,password);
            System.out.println("Introduceti ID-ul vizitatorului pe care doriti sa il editati: ");
            int id=scanner.nextInt();
            String query;
            System.out.println("Ce doriti sa modificati? [nume/prenume/status/varsta]");
            String modif=scanner.next();
            if (modif.equals("nume")) {
                System.out.println("Introduceti numele dorit: ");
                String nume=scanner.next();
                query = "UPDATE VIZITATOR SET NUME='"+nume+"' where ID_VIZITATOR="+id+"";
            }
            else if (modif.equals("prenume")){
                System.out.println("Introduceti prenumele dorit: ");
                String prenume= scanner.next();
                query="UPDATE VIZITATOR SET PRENUME='"+prenume+"' where ID_VIZITATOR="+id+"";
            }
            else if (modif.equals("varsta")){
                System.out.println("Introduceti varsta dorita: ");
                int varsta= scanner.nextInt();
                query="UPDATE VIZITATOR SET VARSTA="+varsta+" where ID_VIZITATOR="+id+"";
            }
            else {
                System.out.println("Adult/Student/Copil :");
                String status=scanner.next();
                query="UPDATE VIZITATOR SET STATUS='"+status+"' where ID_VIZITATOR="+id+"";
            }
            PreparedStatement ps= con.prepareStatement(query);
            ps.execute();
            con.close();
            v.clear();
            Vizitator.setNr_vizitatori();
            LoadAdulti(v);
            LoadStudenti(v);
            LoadCopii(v);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void StergeViz(ArrayList<Vizitator> v){
        try {
            Scanner scanner=new Scanner(System.in);
            Connection con= DriverManager.getConnection(dbURL,username,password);
            System.out.println("Introduceti ID-ul vizitatorului pe care doriti sa il stergeti: ");
            int id= scanner.nextInt();
            String query="DELETE FROM VIZITATOR WHERE ID_VIZITATOR="+id+"";
            PreparedStatement ps =con.prepareStatement(query);
            ps.execute();
            con.close();
            v.clear();
            Vizitator.setNr_vizitatori();
            LoadCopii(v);
            LoadAdulti(v);
            LoadStudenti(v);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
