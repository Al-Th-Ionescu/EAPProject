package com.company;

public class Meniu {
    private static Meniu men;

    private Meniu(){
    }

    public static Meniu getInstance(){
        if (men==null){
            men = new Meniu();
        }
            return men;
    }

    public void showMenu(){

    }

}
