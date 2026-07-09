import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    void display() {
        System.out.println("ID: " + productId +
                ", Name: " + productName +
                ", Category: " + category);
    }
}

public class EcommerceSearch {

    // Linear Search
    static Product linearSearch(Product[] products, String key) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(key)) {
                return p;
            }
        }
        return null;
    }

    // Binary Search
    static Product binarySearch(Product[] products, String key) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = products[mid].productName.compareToIgnoreCase(key);

            if (result == 0)
                return products[mid];
            else if (result < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mouse", "Accessories"),
                new Product(103, "Keyboard", "Accessories"),
                new Product(104, "Mobile", "Electronics"),
                new Product(105, "Speaker", "Audio")
        };

        // Linear Search
        System.out.println("Linear Search:");
        Product p1 = linearSearch(products, "Mobile");

        if (p1 != null)
            p1.display();
        else
            System.out.println("Product Not Found");

        // Sort for Binary Search
        Arrays.sort(products, Comparator.comparing(product -> product.productName));

        // Binary Search
        System.out.println("\nBinary Search:");
        Product p2 = binarySearch(products, "Mobile");

        if (p2 != null)
            p2.display();
        else
            System.out.println("Product Not Found");
    }
}