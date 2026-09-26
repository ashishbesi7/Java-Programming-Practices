import java.time.LocalDate;
import java.util.Scanner;

interface SubscriptionPlan {
    LocalDate calculateRenewalDate();
    String getName();
}

class BasicPlan implements SubscriptionPlan {
    private String name;
    private LocalDate startDate;

    BasicPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }

    public String getName() {
        return name;
    }
}

class StandardPlan implements SubscriptionPlan {
    private String name;
    private LocalDate startDate;

    StandardPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }

    public String getName() {
        return name;
    }
}

class PremiumPlan implements SubscriptionPlan {
    private String name;
    private LocalDate startDate;

    PremiumPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }

    public String getName() {
        return name;
    }
}

public class StreamingPlanRenewalReminder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        SubscriptionPlan[] plans =
            new SubscriptionPlan[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            LocalDate startDate =
                LocalDate.parse(sc.next());

            if (type.equals("BASIC")) {

                plans[i] =
                    new BasicPlan(name, startDate);

            } else if (type.equals("STANDARD")) {

                plans[i] =
                    new StandardPlan(name, startDate);

            } else if (type.equals("PREMIUM")) {

                plans[i] =
                    new PremiumPlan(name, startDate);
            }
        }

        for (SubscriptionPlan plan : plans) {

            LocalDate renewalDate =
                plan.calculateRenewalDate();

            System.out.printf(
                "%s: %s%n",
                plan.getName(),
                renewalDate
            );
        }

        sc.close();
    }
}