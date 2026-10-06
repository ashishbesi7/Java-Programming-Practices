import java.util.Scanner;

abstract class Appliance {

    protected double hours;

    private static final double COST_PER_UNIT = 8.0;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPowerRating();

    abstract String getApplianceType();

    double calculateUnits() {

        return (getPowerRating() * hours) / 1000;
    }

    double calculateCost(double units) {

        return units * COST_PER_UNIT;
    }
}

interface SaverMode {

    double applySaver(double units);
}

class Fridge extends Appliance {

    Fridge(double hours) {
        super(hours);
    }

    double getPowerRating() {
        return 150.0;
    }

    String getApplianceType() {
        return "FRIDGE";
    }
}

class AirConditioner extends Appliance
        implements SaverMode {

    AirConditioner(double hours) {
        super(hours);
    }

    double getPowerRating() {
        return 1500.0;
    }

    String getApplianceType() {
        return "AC";
    }

    public double applySaver(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {

    TV(double hours) {
        super(hours);
    }

    double getPowerRating() {
        return 100.0;
    }

    String getApplianceType() {
        return "TV";
    }
}

class WashingMachine extends Appliance
        implements SaverMode {

    WashingMachine(double hours) {
        super(hours);
    }

    double getPowerRating() {
        return 500.0;
    }

    String getApplianceType() {
        return "WASHER";
    }

    public double applySaver(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Appliance[] appliances = new Appliance[n];
        boolean[] saverRequested = new boolean[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saver = true;
            }

            saverRequested[i] = saver;

            if (type.equals("FRIDGE")) {

                appliances[i] = new Fridge(hours);

            } else if (type.equals("AC")) {

                appliances[i] =
                    new AirConditioner(hours);

            } else if (type.equals("TV")) {

                appliances[i] = new TV(hours);

            } else if (type.equals("WASHER")) {

                appliances[i] =
                    new WashingMachine(hours);
            }
        }

        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {

            Appliance appliance = appliances[i];

            if (saverRequested[i]
                    && !(appliance instanceof SaverMode)) {

                System.out.printf(
                    "%s: saver mode not supported%n",
                    appliance.getApplianceType()
                );

                continue;
            }

            double units = appliance.calculateUnits();

            if (saverRequested[i]) {

                SaverMode saverAppliance =
                    (SaverMode) appliance;

                units =
                    saverAppliance.applySaver(units);
            }

            double cost =
                appliance.calculateCost(units);

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                appliance.getApplianceType(),
                units,
                cost
            );

            totalCost += cost;
        }

        System.out.printf(
            "Total Cost: %.2f%n",
            totalCost
        );

        sc.close();
    }
}