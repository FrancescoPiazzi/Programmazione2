package it.unitn.piazzi.esercizio;

import it.unitn.piazzi.esercizio.car.Car;

import java.util.ArrayList;

public class Controller {
    ArrayList<Car> cars;
    int index;
    Main main;

    Controller(Main main, ArrayList<Car> cars){
        this.cars = cars;
        this.main = main;
        resetShownCar();
    }

    public void sortByid(){
        cars.sort(new CompareById());
        resetShownCar();
    }

    public void sortByMonth(){
        cars.sort(new CompareByMonth());
        resetShownCar();
    }

    public void resetShownCar(){
        index = 0;
        main.setCarShown(this.cars.get(0));
    }

    public boolean nextCar(){
        boolean end = ++index == cars.size()-1;
        main.setCarShown(cars.get(index));
        return end;
    }

    public boolean prevCar(){
        boolean end = --index == 0;
        main.setCarShown(cars.get(index));
        return end;
    }
}
