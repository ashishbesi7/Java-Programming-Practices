import java.util.Scanner;

interface Vehicle {
    double calculateCharge();
    String getType();
}

class Bike implements Vehicle {
    private int hours;

    Bike(int hours) {
        this.hours = hours;
    }

    public double calculateCharge() {
        return hours * 10;
    }

    public String getType() {
        return "BIKE";
    }
}

class Car implements Vehicle {
    private int hours;

    Car(int hours) {
        this.hours = hours;
    }

    public double calculateCharge() {
        return 30 + (hours - 1) * 20;
    }

    public String getType() {
        return "CAR";
    }
}

class Truck implements Vehicle {
    private int hours;

    Truck(int hours) {
        this.hours = hours;
    }

    public double calculateCharge() {

        double charge = hours * 50;

        if (charge < 100) {
            charge = 100;
        }

        return charge;
    }

    public String getType() {
        return "TRUCK";
    }
}

public class CampusParkingChargeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int hours = sc.nextInt();

            if (type.equals("BIKE")) {
                vehicles[i] = new Bike(hours);
            } else if (type.equals("CAR")) {
                vehicles[i] = new Car(hours);
            } else if (type.equals("TRUCK")) {
                vehicles[i] = new Truck(hours);
            }
        }

        double total = 0;

        for (Vehicle vehicle : vehicles) {

            double charge = vehicle.calculateCharge();

            System.out.printf(
                "%s: %.2f%n",
                vehicle.getType(),
                charge
            );

            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}