import java.util.Scanner;

abstract class Ticket {
    protected int count;

    private static final double CONVENIENCE_FEE = 20.0;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPricePerTicket();

    abstract String getSeatType();

    double calculateAmount() {
        return (getPricePerTicket() + CONVENIENCE_FEE) * count;
    }
}

class RegularTicket extends Ticket {

    RegularTicket(int count) {
        super(count);
    }

    double getPricePerTicket() {
        return 150.0;
    }

    String getSeatType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {

    PremiumTicket(int count) {
        super(count);
    }

    double getPricePerTicket() {
        return 250.0;
    }

    String getSeatType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {

    ReclinerTicket(int count) {
        super(count);
    }

    double getPricePerTicket() {
        return 400.0;
    }

    String getSeatType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Ticket[] tickets = new Ticket[n];

        for (int i = 0; i < n; i++) {

            String seat = sc.next();
            int count = sc.nextInt();

            if (seat.equals("REGULAR")) {
                tickets[i] = new RegularTicket(count);

            } else if (seat.equals("PREMIUM")) {
                tickets[i] = new PremiumTicket(count);

            } else if (seat.equals("RECLINER")) {
                tickets[i] = new ReclinerTicket(count);
            }
        }

        double total = 0.0;

        for (Ticket ticket : tickets) {

            double amount = ticket.calculateAmount();

            System.out.printf(
                "%s: %.2f%n",
                ticket.getSeatType(),
                amount
            );

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}