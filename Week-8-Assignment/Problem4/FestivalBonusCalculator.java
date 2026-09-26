import java.util.Scanner;

interface Employee {
    double calculateBonus();
    String getName();
}

class FullTimeEmployee implements Employee {
    private String name;
    private double salary;

    FullTimeEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.10;
    }

    public String getName() {
        return name;
    }
}

class PartTimeEmployee implements Employee {
    private String name;
    private double salary;

    PartTimeEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.05;
    }

    public String getName() {
        return name;
    }
}

class InternEmployee implements Employee {
    private String name;
    private double salary;

    InternEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateBonus() {
        return 2000;
    }

    public String getName() {
        return name;
    }
}

public class FestivalBonusCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("FULLTIME")) {
                employees[i] =
                    new FullTimeEmployee(name, salary);

            } else if (type.equals("PARTTIME")) {
                employees[i] =
                    new PartTimeEmployee(name, salary);

            } else if (type.equals("INTERN")) {
                employees[i] =
                    new InternEmployee(name, salary);
            }
        }

        double totalBonus = 0;

        for (Employee employee : employees) {

            double bonus = employee.calculateBonus();

            System.out.printf(
                "%s: %.2f%n",
                employee.getName(),
                bonus
            );

            totalBonus += bonus;
        }

        System.out.printf(
            "Total Bonus: %.2f%n",
            totalBonus
        );

        sc.close();
    }
}