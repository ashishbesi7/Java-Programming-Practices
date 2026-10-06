import java.util.Scanner;

abstract class Student {

    protected String name;

    protected static final double TRANSPORT_FEE = 12000.0;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();

    String getName() {
        return name;
    }
}

interface BusUser {

    boolean usesBus();
}

class DayScholar extends Student implements BusUser {

    DayScholar(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000 + TRANSPORT_FEE;
    }

    public boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {

    Hosteller(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000 + 60000;
    }
}

class ScholarshipStudent extends Student implements BusUser {

    ScholarshipStudent(String name) {
        super(name);
    }

    double calculateFee() {
        return 20000 + TRANSPORT_FEE;
    }

    public boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            if (type.equals("DAY_SCHOLAR")) {

                students[i] =
                    new DayScholar(name);

            } else if (type.equals("HOSTELLER")) {

                students[i] =
                    new Hosteller(name);

            } else if (type.equals("SCHOLAR")) {

                students[i] =
                    new ScholarshipStudent(name);
            }
        }

        double totalCollected = 0.0;

        for (Student student : students) {

            double fee = student.calculateFee();

            System.out.printf(
                "%s: %.2f%n",
                student.getName(),
                fee
            );

            totalCollected += fee;
        }

        System.out.printf(
            "Total Collected: %.2f%n",
            totalCollected
        );

        sc.close();
    }
}