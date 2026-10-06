import java.util.Scanner;

abstract class Booking {

    protected double distanceKm;

    private static final double BOOKING_FEE = 50;

    Booking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    abstract double calculateBaseFare();

    abstract String getMode();

    double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {

    BusBooking(double distanceKm) {
        super(distanceKm);
    }

    double calculateBaseFare() {
        return 2 * distanceKm;
    }

    String getMode() {
        return "BUS";
    }
}

class TrainBooking extends Booking {

    TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    double calculateBaseFare() {
        return 1.5 * distanceKm;
    }

    String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends Booking {

    FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    double calculateBaseFare() {
        return 2500 + (4 * distanceKm);
    }

    String getMode() {
        return "FLIGHT";
    }
}

public class TravelBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Booking[] bookings = new Booking[n];

        for (int i = 0; i < n; i++) {

            String mode = sc.next();
            double distanceKm = sc.nextDouble();

            if (mode.equals("BUS")) {

                bookings[i] =
                    new BusBooking(distanceKm);

            } else if (mode.equals("TRAIN")) {

                bookings[i] =
                    new TrainBooking(distanceKm);

            } else if (mode.equals("FLIGHT")) {

                bookings[i] =
                    new FlightBooking(distanceKm);
            }
        }

        for (Booking booking : bookings) {

            double total = booking.calculateTotal();

            System.out.printf(
                "%s: %.2f%n",
                booking.getMode(),
                total
            );
        }

        sc.close();
    }
}