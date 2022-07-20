package it.unitn.piazzi.esercizio;

import it.unitn.piazzi.esercizio.car.Car;

import java.util.Comparator;

public class CompareById implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        return car1.id - car2.id;
    }
}
