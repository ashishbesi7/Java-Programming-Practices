import java.util.Scanner;

interface Transport {
    double calculateFare();
    String getType();
}

class Bus implements Transport {

    private double distance;

    Bus(double distance) {
        this.distance = distance;
    }

    public double calculateFare() {

        double fare =
            2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }

    public String getType() {
        return "BUS";
    }
}

class Train implements Transport {

    private double distance;

    Train(double distance) {
        this.distance = distance;
    }

    public double calculateFare() {
        return 3 + (0.15 * distance);
    }

    public String getType() {
        return "TRAIN";
    }
}

class Metro implements Transport {

    private double distance;
    private double peakHourFactor;

    Metro(double distance,
          double peakHourFactor) {

        this.distance = distance;
        this.peakHourFactor = peakHourFactor;
    }

    public double calculateFare() {

        double fare =
            1.50 + (0.20 * distance);

        return fare * peakHourFactor;
    }

    public String getType() {
        return "METRO";
    }
}

public class PublicTransportFareCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Transport[] transports =
            new Transport[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            double distance =
                sc.nextDouble();

            if (type.equals("BUS")) {

                transports[i] =
                    new Bus(distance);

            } else if (type.equals("TRAIN")) {

                transports[i] =
                    new Train(distance);

            } else if (type.equals("METRO")) {

                double peakHourFactor =
                    sc.nextDouble();

                transports[i] =
                    new Metro(
                        distance,
                        peakHourFactor
                    );
            }
        }

        double total = 0;

        for (Transport transport : transports) {

            double fare =
                transport.calculateFare();

            System.out.printf(
                "%s: %.2f%n",
                transport.getType(),
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