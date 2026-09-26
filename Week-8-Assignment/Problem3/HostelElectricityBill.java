import java.util.Scanner;

interface Room {
    double calculateBill();
    String getType();
}

class SingleRoom implements Room {
    private int units;

    SingleRoom(int units) {
        this.units = units;
    }

    public double calculateBill() {
        return units * 8;
    }

    public String getType() {
        return "SINGLE";
    }
}

class SharedRoom implements Room {
    private int units;
    private int occupants;

    SharedRoom(int units, int occupants) {
        this.units = units;
        this.occupants = occupants;
    }

    public double calculateBill() {
        return (units * 6) / occupants;
    }

    public String getType() {
        return "SHARED";
    }
}

class AcRoom implements Room {
    private int units;

    AcRoom(int units) {
        this.units = units;
    }

    public double calculateBill() {
        return (units * 10) + 200;
    }

    public String getType() {
        return "AC";
    }
}

public class HostelElectricityBill {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Room[] rooms = new Room[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int units = sc.nextInt();

            if (type.equals("SINGLE")) {

                rooms[i] = new SingleRoom(units);

            } else if (type.equals("SHARED")) {

                int occupants = sc.nextInt();
                rooms[i] = new SharedRoom(units, occupants);

            } else if (type.equals("AC")) {

                rooms[i] = new AcRoom(units);
            }
        }

        double total = 0;

        for (Room room : rooms) {

            double bill = room.calculateBill();

            System.out.printf(
                "%s: %.2f%n",
                room.getType(),
                bill
            );

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}