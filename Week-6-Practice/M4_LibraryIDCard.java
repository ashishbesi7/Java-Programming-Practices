
class IdCard {
    String name;
    int booksIssued;

    IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class M4_LibraryIDCard {
    public static void main(String[] args) {

        // Create one object
        IdCard ravi = new IdCard("Ravi", 0);

        // Both variables point to the same object
        IdCard duplicate = ravi;

        // Modify the object through duplicate
        duplicate.booksIssued = 3;

        System.out.println(
            "Ravi's booksIssued (via first variable): "
            + ravi.booksIssued
        );

        System.out.println("duplicate == ravi: "
                + (duplicate == ravi));

        // Create a separate object with identical values
        IdCard separate = new IdCard("Ravi", 3);

        System.out.println("separate == ravi: "
                + (separate == ravi));
    }
}