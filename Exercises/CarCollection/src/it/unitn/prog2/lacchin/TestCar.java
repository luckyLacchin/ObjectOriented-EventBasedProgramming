package it.unitn.prog2.lacchin;


import java.util.Set;
import java.util.TreeSet;

public class TestCar{
    Set<Car> macchine;
    Set <Car> macchine2;
    public static void main(String[] args) { new TestCar(); }
    TestCar(){
        macchine = new TreeSet();
        Car a = new Car(100, "Fiat Cinquecento L",160);
        macchine.add(a);
        Car b = new Car(250, "Porsche Carrera",230);
        macchine.add(b);
        Car c = new Car(180, "Renault Megane",200);
        macchine.add(c);
        Car d = new Car(200, "Renault Megane",250);
        macchine.add(d);
        Car e = new Car(180, "Pandino",200);
        macchine.add(e);
        System.out.println(macchine);
        /*quando aggiunge gli elementi guarda la compare e non solo equals e hashCode,perché
        è un set, nel caso in cui io volessi creare un Set con un diverso ordinamento, devo
        creare un altro set e passargli un altro metodo per il riordinamento
         */
        macchine2 = new TreeSet (new SpeedSorted());
        macchine2.addAll (macchine);
        System.out.println(macchine2);


    }
    //questo è fatto con gli Set, adesso lo provo con la list, con cui posso fare vari riordinamenti!
}