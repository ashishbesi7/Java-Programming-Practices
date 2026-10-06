import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();

    String getTitle() {
        return title;
    }
}

class BookItem extends LibraryItem {

    BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate * 2;
    }
}

class DVDItem extends LibraryItem {

    DVDItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {

        double fine = daysLate * 5;

        if (fine > 50) {
            fine = 50;
        }

        return fine;
    }
}

class MagazineItem extends LibraryItem {

    MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate;
    }
}

public class LibraryLateFineCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();

            if (type.equals("BOOK")) {

                items[i] =
                    new BookItem(title, daysLate);

            } else if (type.equals("DVD")) {

                items[i] =
                    new DVDItem(title, daysLate);

            } else if (type.equals("MAGAZINE")) {

                items[i] =
                    new MagazineItem(title, daysLate);
            }
        }

        double totalFines = 0;

        for (LibraryItem item : items) {

            double fine = item.calculateFine();

            System.out.printf(
                "%s: %.2f%n",
                item.getTitle(),
                fine
            );

            totalFines += fine;
        }

        System.out.printf(
            "Total Fines: %.2f%n",
            totalFines
        );

        sc.close();
    }
}