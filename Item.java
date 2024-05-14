import Utility.*;
/**
 * This abstract class represents an item in a shopping store. It inherits from `ShoppingStoreEntity` (which we assume provides basic functionality for entities)
 * and implements the `Comparable` interface to enable sorting items based on specific criteria.
 * @author Ahmed Karam - ID: 210176
 * @author Ahmed Haitham - ID: 2101629
 **/
abstract class Item extends ShoppingStoreEntity implements Comparable<Item> {
    /**
     * Stores the unit price of the item.
     */
    private double unitPrice;
    /**
     * Stores the current available quantity of the item in stock.
     */
    private int availableQuantity;

    /**
     * Compares two Item objects based on their unit price.
     *
     * @param item The Item object to compare to.
     * @return -1 if this item's unit price is less than the argument's price, 1 if it's greater, and 0 if they are equal.
     */
    @Override
    public int compareTo(Item item) {
        if (this.unitPrice < item.getUnitPrice()) {
            return -1;
        } else if (this.unitPrice > item.getUnitPrice()) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Returns a string representation of the item, including its name, unit price, and available quantity.
     *
     * @return A formatted string representing the item details.
     */
    @Override
    public String toString() {
        String returnStr = this.getName() + "\t-\tprice: " + unitPrice + "\t-\t" + availableQuantity + " - units available.";
        return returnStr;
    }

    /**
     * Getter method to access the item's unit price.
     *
     * @return The unit price of the item.
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Getter method to access the current available quantity of the item.
     *
     * @return The number of units of the item currently in stock.
     */
    public int getAvailableQuantity() {
        return availableQuantity;
    }

    /**
     * Reduces the available quantity of the item by the specified amount.
     *
     * @param quantity The number of units to remove from stock.
     */
    public void removeQuantity(int quantity) {
        availableQuantity -= quantity;
    }

    /**
     * Increases the available quantity of the item by the specified amount.
     *
     * @param quantity The number of units to add to stock.
     */
    public void addQuantity(int quantity) {
        availableQuantity += quantity;
    }

    /**
     * Constructor that initializes a new Item object with a name, unit price, and initial quantity.
     *
     * @param name          The name of the item.
     * @param unitPrice     The unit price of the item.
     * @param initialQuantity The initial quantity of the item in stock.
     */
    public Item(String name, double unitPrice, int initialQuantity) {
        super(name); // Call superclass constructor (potentially to initialize inherited fields)
        this.unitPrice = unitPrice;
        this.availableQuantity = initialQuantity;
    }

    /**
     * Private no-argument constructor (suppressed from Javadoc with @SuppressWarnings) used potentially for testing purposes.
     * This constructor should not be used in normal operation.
     */
    @SuppressWarnings("unused")
    private Item() {
        this("IPSUMLOREM", 1, 1);
    }

    /**
     * Checks if the required quantity of the item is available in stock.
     *
     * @param requiredQuantity The number of units needed.
     * @return True if the required quantity is less than or equal to the available quantity, false otherwise.
     */
    public boolean quantityIsAvailable(int requiredQuantity) {
        return requiredQuantity <= availableQuantity;
    }

    /**
     * Calculates the total price for a given quantity of the item.
     *
     * @param requiredQuantity The number of units to calculate the price for.
     * @return The total price based on the unit price and quantity.
     */
    public double calculatePrice(int requiredQuantity) {
        return requiredQuantity * unitPrice;
    }
}

/**
 * Concrete subclass of Item representing a food item.
 */
class Food extends Item {

    /**
     * Constructor that initializes a Food object with a name, unit price, and initial quantity.
     *
     * @param foodName        The name of the food item.
     * @param unitPrice     The unit price of the food item.
     * @param initialQuantity The initial quantity of the food item in stock.
     */
    Food(String foodName, double unitPrice, int initialQuantity) {
        super(foodName, unitPrice, initialQuantity);
    }

    /**
     * No-argument constructor that creates a random Food item with a random name, price, and quantity (for testing purposes).
     */
    Food() {
        this(Utility.getRandomString(10), Utility.getRandomPrice(), 10);
    }
}

/**
 * Concrete subclass of Item representing a tool item.
 */
class Tool extends Item {

    /**
     * Constructor that initializes a Tool object with a name, unit price, and initial quantity.
     *
     * @param toolName        The name of the tool item.
     * @param unitPrice     The unit price of the tool item.
     * @param initialQuantity The initial quantity of the tool item in stock.
     */
    Tool(String toolName, double unitPrice, int initialQuantity) {
        super(toolName, unitPrice, initialQuantity);
    }

    /**
     * No-argument constructor that creates a random Tool item with a random name, price, and quantity (for testing purposes).
     */
    Tool() {
        this(Utility.getRandomString(10), Utility.getRandomPrice(), 10);
    }
}

/**
 * Concrete subclass of Item representing a cosmetic item.
 */
class Cosmetic extends Item {

    /**
     * Constructor that initializes a Cosmetic object with a name, unit price, and initial quantity.
     *
     * @param CosmeticName  The name of the cosmetic item.
     * @param unitPrice     The unit price of the cosmetic item.
     * @param initialQuantity The initial quantity of the cosmetic item in stock.
     */
    Cosmetic(String CosmeticName, double unitPrice, int initialQuantity) {
        super(CosmeticName, unitPrice, initialQuantity);
    }

    /**
     * No-argument constructor that creates a random Cosmetic item with a random name, price, and quantity (for testing purposes).
     */
    Cosmetic() {
        this(Utility.getRandomString(10), Utility.getRandomPrice(), 10);
    }
}