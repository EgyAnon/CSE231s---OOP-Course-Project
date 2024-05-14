/**
* @author Ahmed Karam - ID: 210176
* @author Ahmed Haitham - ID: 2101629
**/


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import Utility.*;

/**
 * This class represents an order placed in a shopping store.
 */
public class Order {

    /**
     * Stores a list of pairs, where each pair represents an item in the order and the quantity purchased.
     */
    private ArrayList<Pair<Item, Integer>> orderContent;

    /**
     * Stores the total price of the order.
     */
    private double totalPrice;

    /**
     * Stores the time the order was placed.
     */
    private LocalTime orderTime;

    /**
     * Stores the date the order was placed.
     */
    private LocalDate orderDate;

    /**
     * Default constructor that initializes an empty order.
     */
    public Order() {
        totalPrice = 0; //A new order is an empty order with a total of 0
        orderContent = new ArrayList<Pair<Item, Integer>>();
        orderTime = LocalTime.now();
        orderDate = LocalDate.now();
    }

    /**
     * Adds a product (item) and its quantity to the order.
     *
     * @param item     The Item object representing the product.
     * @param quantity The number of units of the product to add.
     */
    public void addProduct(Item item, int quantity) {
        orderContent.add(new Pair<Item, Integer>(item, quantity));
        totalPrice += item.calculatePrice(quantity);
    }

    /**
     * Prints the details of the order to the console.
     */
    public void printOrder() {
        System.out.println("=========  Order Details  =========");
        System.out.println("Date: " + orderDate.toString() + " - " + orderTime.toString());

        if (orderContent.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("ITEM NAME\t-\tQUANTITY\t-\tSUBTOTAL");
            for (Pair<Item, Integer> P : orderContent) {
                System.out.println(P.getFirst().getName() + "\t\t-\tx" + P.getSecond() + "\t-\t" + P.getFirst().calculatePrice(P.getSecond()));
            }
            System.out.println("----------Total Price = " + ((int) (totalPrice * 10)) / 10.0 + "----------");
        }
    }

    /**
     * Finalizes the order by associating it with a customer and updating the order details with the current date and time.
     * @param customer The Customer object who placed the order.
     */
    public void finishOrder(Customer customer) {
        printOrder();
        System.out.println("======================================");
        customer.addOrder(this);
        orderTime = LocalTime.now();
        orderDate = LocalDate.now();
        System.out.println("Thank you, " + customer.getName() + " for using our shopping system.");
    }
}
