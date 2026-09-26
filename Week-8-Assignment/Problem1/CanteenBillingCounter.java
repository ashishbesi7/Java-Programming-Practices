import java.util.Scanner;

interface Customer {
    double calculateFinalAmount();
    String getType();
}

class StudentCustomer implements Customer {
    private double amount;

    StudentCustomer(double amount) {
        this.amount = amount;
    }

    public double calculateFinalAmount() {
        return amount * 0.90;
    }

    public String getType() {
        return "STUDENT";
    }
}

class StaffCustomer implements Customer {
    private double amount;

    StaffCustomer(double amount) {
        this.amount = amount;
    }

    public double calculateFinalAmount() {
        return amount * 0.95;
    }

    public String getType() {
        return "STAFF";
    }
}

class GuestCustomer implements Customer {
    private double amount;

    GuestCustomer(double amount) {
        this.amount = amount;
    }

    public double calculateFinalAmount() {
        return amount + 10;
    }

    public String getType() {
        return "GUEST";
    }
}

public class CanteenBillingCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Customer[] customers = new Customer[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            if (type.equals("STUDENT")) {
                customers[i] = new StudentCustomer(amount);
            } else if (type.equals("STAFF")) {
                customers[i] = new StaffCustomer(amount);
            } else if (type.equals("GUEST")) {
                customers[i] = new GuestCustomer(amount);
            }
        }

        double total = 0;

        for (Customer customer : customers) {

            double finalAmount = customer.calculateFinalAmount();

            System.out.printf(
                "%s: %.2f%n",
                customer.getType(),
                finalAmount
            );

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}