package it.unitn.prog2.lacchin;

import java.util.Objects;

public class Car implements Comparable{

    int prezzo;
    String nome;
    int maxSpeed;

    public Car (int prezzo, String nome, int maxSpeed) {

        this.prezzo = prezzo;
        this.nome = nome;
        this.maxSpeed = maxSpeed;

    }

    @Override
    public int compareTo(Object o) {
        /* facciamo che questo metodo riordini le car secondo la loro max velocità
         */
        if (!(o instanceof Car)) System.exit(1);
        if (this.equals(o) ||
                nome == ((Car) o).nome) return 0;
        if (nome.compareTo(((Car) o).nome) < 0) return -1;
        return 1;
    }



    @Override
    public String toString () {

        return "Nome: " + this.nome + " ;"+"maxSpeed: " + this.maxSpeed +" ;" + "Price: " + this.prezzo + "\n";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return nome.equals(car.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
