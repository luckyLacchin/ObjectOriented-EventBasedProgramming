package it.unitn.prog2.lacchin;

import java.util.Comparator;

public class SpeedSorted implements Comparator {
    public int compare(Object o1, Object o2) {
        if (o1.getClass() != o2.getClass()) {
            System.out.println("Non si possono comparare elementi di classe diversa");
            System.exit(1);
        }
        if (!(o1 instanceof Car) || (!(o2 instanceof Car))) {

            System.out.println ("Errore: gli elemeneti inseriti non sono delle Car");
            System.exit(1);
        }
        else {
            Car c1 = (Car) o1;
            Car c2 = (Car) o2;
            if (c1.maxSpeed<c2.maxSpeed)
                return -1;
            else if ((c1.maxSpeed==c2.maxSpeed))
                return 0;
        }
        return 1;
    }
}
