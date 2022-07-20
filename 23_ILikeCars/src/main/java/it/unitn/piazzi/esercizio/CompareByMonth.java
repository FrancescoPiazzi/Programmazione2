package it.unitn.piazzi.esercizio;

import it.unitn.piazzi.esercizio.car.Car;

import java.util.Comparator;

public class CompareByMonth implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        int compare = Integer.compare(car1.mese, car2.mese);
        if(compare!=0)
            return compare;
        else
            return car1.anno - car2.anno;
    }
}
