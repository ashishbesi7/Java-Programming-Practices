import java.util.Scanner;

abstract class Parcel {

    protected double weightKg;
    protected double declaredValue;

    Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();

    abstract String getType();
}

interface Insurable {

    double calculateInsurance();
}

class StandardParcel extends Parcel {

    StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double calculateCharge() {
        return 40 + (10 * weightKg);
    }

    String getType() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel implements Insurable {

    ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double calculateCharge() {
        return 80 + (15 * weightKg);
    }

    String getType() {
        return "EXPRESS";
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {

    FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double calculateCharge() {
        return 40 + (10 * weightKg) + 50;
    }

    String getType() {
        return "FRAGILE";
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDesk {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Parcel[] parcels = new Parcel[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            if (type.equals("STANDARD")) {
                parcels[i] =
                    new StandardParcel(weight, declaredValue);

            } else if (type.equals("EXPRESS")) {
                parcels[i] =
                    new ExpressParcel(weight, declaredValue);

            } else if (type.equals("FRAGILE")) {
                parcels[i] =
                    new FragileParcel(weight, declaredValue);
            }
        }

        double grandTotal = 0.0;

        for (Parcel parcel : parcels) {

            double charge = parcel.calculateCharge();
            double insurance = 0.0;

            if (parcel instanceof Insurable) {
                Insurable insurableParcel =
                    (Insurable) parcel;

                insurance =
                    insurableParcel.calculateInsurance();
            }

            double total = charge + insurance;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                parcel.getType(),
                charge,
                insurance,
                total
            );

            grandTotal += total;
        }

        System.out.printf(
            "Grand Total: %.2f%n",
            grandTotal
        );

        sc.close();
    }
}