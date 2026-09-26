import java.time.LocalDate;
import java.util.Scanner;

interface LibraryItem {
    LocalDate calculateDueDate();
    String getTitle();
}

class Book implements LibraryItem {
    private String title;
    private LocalDate currentDate;

    Book(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    public LocalDate calculateDueDate() {
        return currentDate.plusDays(14);
    }

    public String getTitle() {
        return title;
    }
}

class DVD implements LibraryItem {
    private String title;
    private LocalDate currentDate;

    DVD(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    public LocalDate calculateDueDate() {
        return currentDate.plusDays(7);
    }

    public String getTitle() {
        return title;
    }
}

class Magazine implements LibraryItem {
    private String title;
    private LocalDate currentDate;

    Magazine(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    public LocalDate calculateDueDate() {
        return currentDate.plusDays(3);
    }

    public String getTitle() {
        return title;
    }
}

public class LibraryDueDateCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        LocalDate currentDate =
            LocalDate.of(2023, 10, 26);

        LibraryItem[] items =
            new LibraryItem[n];

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            int firstQuote = line.indexOf('"');
            int lastQuote = line.lastIndexOf('"');

            String type =
                line.substring(0, firstQuote).trim();

            String title =
                line.substring(
                    firstQuote + 1,
                    lastQuote
                );

            if (type.equals("BOOK")) {

                items[i] =
                    new Book(title, currentDate);

            } else if (type.equals("DVD")) {

                items[i] =
                    new DVD(title, currentDate);

            } else if (type.equals("MAGAZINE")) {

                items[i] =
                    new Magazine(title, currentDate);
            }
        }

        for (LibraryItem item : items) {

            System.out.printf(
                "%s: %s%n",
                item.getTitle(),
                item.calculateDueDate()
            );
        }

        sc.close();
    }
}