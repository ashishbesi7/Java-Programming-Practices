public class ProductInventoryCSVParser {

    public static void parseInventoryRecord(String csvLine) {

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        System.out.println(
                "Product: " + productName
                + " | SKU: " + sku
                + " | Qty: " + quantity
        );
    }

    public static void main(String[] args) {

        String csvLine =
        "Wireless Mouse,WM-2201,150";

        parseInventoryRecord(csvLine);
    }
}