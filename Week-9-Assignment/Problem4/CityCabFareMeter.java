import java.util.Scanner;

abstract class Cab {

    protected double distance;

    private static final double MINIMUM_FARE = 100.0;

    Cab(double distance) {
        this.distance = distance;
    }

    abstract double getRatePerKm();

    abstract String getCabType();

    double calculateFare() {

        double fare = distance * getRatePerKm();

        if (fare < MINIMUM_FARE) {
            fare = MINIMUM_FARE;
        }

        return fare;
    }
}

interface NightService {

    double applyNightCharge(double fare);
}

class MiniCab extends Cab {

    MiniCab(double distance) {
        super(distance);
    }

    double getRatePerKm() {
        return 10.0;
    }

    String getCabType() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightService {

    SedanCab(double distance) {
        super(distance);
    }

    double getRatePerKm() {
        return 14.0;
    }

    String getCabType() {
        return "SEDAN";
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

class SUVCab extends Cab implements NightService {

    SUVCab(double distance) {
        super(distance);
    }

    double getRatePerKm() {
        return 18.0;
    }

    String getCabType() {
        return "SUV";
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFareMeter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Cab[] cabs = new Cab[n];

        String[] times = new String[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            times[i] = time;

            if (type.equals("MINI")) {

                cabs[i] = new MiniCab(km);

            } else if (type.equals("SEDAN")) {

                cabs[i] = new SedanCab(km);

            } else if (type.equals("SUV")) {

                cabs[i] = new SUVCab(km);
            }
        }

        double total = 0.0;

        for (int i = 0; i < n; i++) {

            Cab cab = cabs[i];

            if (times[i].equals("NIGHT")
                    && !(cab instanceof NightService)) {

                System.out.printf(
                    "%s: night service not available%n",
                    cab.getCabType()
                );

                continue;
            }

            double fare = cab.calculateFare();

            if (times[i].equals("NIGHT")) {

                NightService nightCab =
                    (NightService) cab;

                fare = nightCab.applyNightCharge(fare);
            }

            System.out.printf(
                "%s: %.2f%n",
                cab.getCabType(),
                fare
            );

            total += fare;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );

        sc.close();
    }
}