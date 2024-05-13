import java.util.ArrayList;
import java.time.LocalDate;
/**
 * This class represents a customer of a shopping store. It inherits from a class named `ShoppingStoreEntity`.
 */
public class Customer extends ShoppingStoreEntity {

    /**
     * Stores the date the customer joined the store.
     */
    private LocalDate dateJoined;

    /**
     * Stores the customer's order history as a list of Order objects.
     */
    private ArrayList<Order> orderHistory;

    /**
     * Constructor that initializes a new Customer object.
     *
     * @param name The customer's name.
     */
    public Customer(String name) {
        super(name); // Call superclass constructor (potentially to initialize inherited fields)
        dateJoined = LocalDate.now(); // Set dateJoined to current date
        orderHistory = new ArrayList<Order>(); // Initialize empty order history list
    }

    /**
     * Adds an Order object to the customer's order history.
     *
     * @param order The Order object representing a purchase.
     */
    public void addOrder(Order order) {
        orderHistory.add(order); // Add the order to the orderHistory list
    }

    /**
     * Prints the customer's name, date joined, and order history to the console.
     */
    public void printOrderHistory() {
        System.out.println("User: " + this.getName() + " - Joined: " + dateJoined.toString());
        if (!orderHistory.isEmpty()) {
            for (Order order : orderHistory) {
                order.printOrder(); // Call printOrder method on each Order object in the list
            }
        } else {
            System.out.println("No previous orders. Buy something :)");
        }
    }
}