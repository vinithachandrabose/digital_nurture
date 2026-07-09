import java.util.ArrayList;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + productId +
                ", Name: " + productName +
                ", Quantity: " + quantity +
                ", Price: " + price;
    }
}

public class InventoryManagementSystem {

    static ArrayList<Product> inventory = new ArrayList<>();

    // Add Product
    static void addProduct(Product product) {
        inventory.add(product);
        System.out.println("Product Added");
    }

    // Update Product
    static void updateProduct(int id, int quantity, double price) {
        for (Product p : inventory) {
            if (p.productId == id) {
                p.quantity = quantity;
                p.price = price;
                System.out.println("Product Updated");
                return;
            }
        }
        System.out.println("Product Not Found");
    }

    // Delete Product
    static void deleteProduct(int id) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).productId == id) {
                inventory.remove(i);
                System.out.println("Product Deleted");
                return;
            }
        }
        System.out.println("Product Not Found");
    }

    // Display Inventory
    static void displayInventory() {
        for (Product p : inventory) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {

        // Add Products
        addProduct(new Product(101, "Laptop", 20, 50000));
        addProduct(new Product(102, "Mouse", 50, 500));

        System.out.println("\nInventory:");
        displayInventory();

        // Update Product
        updateProduct(101, 25, 52000);

        // Delete Product
        deleteProduct(102);

        System.out.println("\nUpdated Inventory:");
        displayInventory();
    }
}