package org.example;

public class Main {
    public static void main(String[] args) {

        Database newDB = new Database();

        var newCar = new Car(5555,"Volvo", "V70", 2023);
        System.out.println();

        var sav = newDB.saveCar(newCar);

        var rem = newDB.removeCar(5);

        /*if (removeResult){
            System.out.println("Car removed");
        }
        else{
            System.out.println("Car not saved");
        }*/

    }
}