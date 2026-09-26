import java.util.Scanner;

interface Payment {
    double calculateFinalAmount();
    String getType();
}

class CardPayment implements Payment {
    private double amount;

    CardPayment(double amount) {
        this.amount = amount;
    }

    public double calculateFinalAmount() {
        return amount + (amount * 0.02);
    }

    public String getType() {
        return "CARD";
    }
}

class WalletPayment implements Payment {
    private double amount;

    WalletPayment(double amount) {
        this.amount = amount;
    }

    public double calculateFinalAmount() {
        return amount + (amount * 0.01);
    }

    public String getType() {
        return "WALLET";
    }
}

class BankTransferPayment implements Payment {
    private double amount;

    BankTransferPayment(double amount) {
        this.amount = amount;
    }

    public double calculateFinalAmount() {
        return amount;
    }

    public String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentFeeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Payment[] payments = new Payment[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            if (type.equals("CARD")) {
                payments[i] = new CardPayment(amount);

            } else if (type.equals("WALLET")) {
                payments[i] = new WalletPayment(amount);

            } else if (type.equals("BANKTRANSFER")) {
                payments[i] = new BankTransferPayment(amount);
            }
        }

        double total = 0;

        for (Payment payment : payments) {

            double finalAmount =
                payment.calculateFinalAmount();

            System.out.printf(
                "%s: %.2f%n",
                payment.getType(),
                finalAmount
            );

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}