package it.unitn.prog2.lacchin;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestCarList{
    List<Car> macchine;
    public static void main(String[] args) { new TestCarList(); }
    TestCarList(){
        macchine = new LinkedList<>();
        Car a = new Car(100, "Fiat Cinquecento L",160);
        macchine.add(a);
        Car b = new Car(250, "Porsche Carrera",230);
        macchine.add(b);
        Car c = new Car(180, "Renault Megane",200);
        macchine.add(c);
        Car e = new Car(180, "Pandino",200);
        macchine.add(e);
        System.out.println("ORDINAMENTO NORMALE: ");
        System.out.println(macchine);
        Collections.sort(macchine); //per nome
        System.out.println("ORDINAMENTO PER NOME: ");
        System.out.println(macchine);
        Collections.sort(macchine,new SpeedSorted()); //per velocità
        System.out.println("ORDINAMENTO PER VELOCITA': ");
        System.out.println(macchine);
        Collections.sort(macchine,new PriceSorted()); //per prezzo
        System.out.println("ORDINAMENTO PER PREZZO': ");
        System.out.println(macchine);


    }
}