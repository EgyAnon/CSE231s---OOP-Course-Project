import java.util.*;
import Utility.Utility;

public class ShoppingSystem {
    private static final String employeePassword = "password";
    private HashMap<String, Item> warehouse;
    private double tempDouble;
    private String tempString;
    private int tempInt;
    private Order currentOrder;
    
    public ShoppingSystem() {
        warehouse = new HashMap<String, Item>();
        tempInt = 0;
        InitializeWarehouse();
    }
    private void InitializeWarehouse() {
        // ====================Food================//
        warehouse.put("apple", new Food("apple", Utility.getRandomPrice(), 5));
        warehouse.put("bread", new Food("bread", Utility.getRandomPrice(), 20));
        warehouse.put("cheese", new Food("cheese", Utility.getRandomPrice(), 7));
        warehouse.put("eggs", new Food("eggs", Utility.getRandomPrice(), 12));
        warehouse.put("pasta", new Food("pasta", Utility.getRandomPrice(), 15));
        warehouse.put("milk", new Food("milk", Utility.getRandomPrice(), 8));
        warehouse.put("yogurt", new Food("yogurt", Utility.getRandomPrice(), 6));
        warehouse.put("cereal", new Food("cereal", Utility.getRandomPrice(), 10));
        warehouse.put("rice", new Food("rice", Utility.getRandomPrice(), 25));
        warehouse.put("beans", new Food("beans", Utility.getRandomPrice(), 18));
        // ====================Tools=======================
        warehouse.put("hammer", new Tool("hammer", Utility.getRandomPrice(), 3));
        warehouse.put("saw", new Tool("saw", Utility.getRandomPrice(), 8));
        warehouse.put("wrench", new Tool("wrench", Utility.getRandomPrice(), 5));
        warehouse.put("pliers", new Tool("pliers", Utility.getRandomPrice(), 4));
        warehouse.put("drill", new Tool("drill", Utility.getRandomPrice(), 15));
        warehouse.put("tape measure", new Tool("tape measure", Utility.getRandomPrice(), 2));
        warehouse.put("knife", new Tool("knife", Utility.getRandomPrice(), 4));
        warehouse.put("screwdriver set", new Tool("screwdriver set", Utility.getRandomPrice(), 10));
        warehouse.put("paintbrush", new Tool("paintbrush", Utility.getRandomPrice(), 1));
        warehouse.put("level", new Tool("level", Utility.getRandomPrice(), 6));
        // ====================Cosmetics=====================
        warehouse.put("shampoo", new Cosmetic("shampoo", Utility.getRandomPrice(), 12));
        warehouse.put("conditioner", new Cosmetic("conditioner", Utility.getRandomPrice(), 10));
        warehouse.put("lotion", new Cosmetic("lotion", Utility.getRandomPrice(), 8));
        warehouse.put("facial cleanser", new Cosmetic("facial cleanser", Utility.getRandomPrice(), 7));
        warehouse.put("moisturizer", new Cosmetic("moisturizer", Utility.getRandomPrice(), 9));
        warehouse.put("lipstick", new Cosmetic("lipstick", Utility.getRandomPrice(), 5));
        warehouse.put("mascara", new Cosmetic("mascara", Utility.getRandomPrice(), 6));
        warehouse.put("eyeliner", new Cosmetic("eyeliner", Utility.getRandomPrice(), 4));
        warehouse.put("foundation", new Cosmetic("foundation", Utility.getRandomPrice(), 15));
        warehouse.put("eyeshadow", new Cosmetic("eyeshadow", Utility.getRandomPrice(), 8));
    }
    
    public void RunSystem() {
        boolean continueOperation = true;
        System.out.println("\t\tWelcome to the Online Shopping System");
        System.out.print("Enter 1 to continue, any other number to terminate: ");
        tempInt = Utility.enforceIntReturn();
        if(tempInt != 1){
            printThanksMessage();
            System.exit(0);
        }

        while (continueOperation) {
            System.out.println("Are you a: ");
            System.out.println("\t1.Customer\n\t2.Employee\n\t3.exit");
            tempInt = Utility.enforceIntReturn();

            if (tempInt == 1)
                customerMenu();
            else if (tempInt == 2)
                EmployeeMenu();
            else if (tempInt == 3)
                continueOperation = false;
            else
                printErrorMessage();
        }
        System.out.println("Thank you for using our online shopping system.");
    }

    private void menuNavigate() {
        smartPrint();
        System.out.print("Enter name of product(enter back if you wish to return): ");
        tempString = Utility.enforceStringReturn();

        if (tempString.contains("back")) {
        } else if (!warehouse.containsKey(tempString)) {
            System.out.println("item doesn't exist.");
        } else {
            Item tempItem = warehouse.get(tempString); // shallow copy required here.
            System.out.print("Enter required quantity: ");
            tempInt = Utility.enforceIntReturn();
            if (tempItem.quantityIsAvailable(tempInt)) {
                System.out.println("Added to cart");
                currentOrder.addProduct(tempItem, tempInt);
                tempItem.removeQuantity(tempInt);
            } else {
                System.out.println("Not enough product available.");
            }
        }
    }
    private void EmployeeMenu() {
        System.out.println("Enter employee password");
        tempString = Utility.enforceStringReturn();
        if (!tempString.equals(employeePassword)) {
            System.out.println("Incorrect employee password.");
        } else {
            while (tempInt != 3) {
                System.out.println("==========Employee Dashbord==========");
                System.out.println("1. Modify Products");
                System.out.println("2. Add Products");
                System.out.println("3. exit");
                tempInt = Utility.enforceIntReturn();
                switch (tempInt) {
                    case 1:
                        modifyProductsMenu();
                        break;
                    case 2:
                        addProductMenu();
                        break;
                    case 3:
                        break;
                    default:
                        printErrorMessage();
                        ;
                        break;
                }
            }
        }

    }
    private void modifyProductsMenu() {
        boolean continueModification = true;
        while (continueModification) {
            System.out.print("Enter Product name (Enter \"back\" to return):");
            tempString = Utility.enforceStringReturn();
            if (tempString.contains("back"))
                continueModification = false;
            else if (warehouse.containsKey(tempString)) {
                System.out.print("How many units do you want to add? ");
                tempInt = Utility.enforceIntReturn();
                warehouse.get(tempString).addQuantity(tempInt);
                System.out.println("Added " + tempInt + " units to " + tempString + " successfully.");
            } else {
                System.out.println("Item not found.");
            }
        }
    }
    private void addProductMenu() {
        int switchInt;
        System.out.print("What type of product to you wish to add?\n\t1.Food\n\t2.Tools\n\t3.Cosmetics\n");
        switchInt = Utility.enforceIntReturn();
        if (switchInt > 3 || switchInt < 1) {
            printErrorMessage();
            return;
        }

        System.out.print("Enter product name: ");
        tempString = Utility.enforceStringReturn();

        System.out.print("Enter product quantity: ");
        tempInt = Utility.enforceIntReturn();

        System.out.print("Enter prodcut price: ");
        tempDouble = Utility.enforceDoubleReturn();

        switch (switchInt) {
            case 1:
                Item I = new Food(tempString, tempDouble, tempInt);
                addProduct(warehouse, I);
                break;

            case 2:
                I = new Tool(tempString, tempDouble, tempInt);
                break;

            case 3:
                I = new Cosmetic(tempString, tempDouble, tempInt);
                addProduct(warehouse, I);
                break;

            default:
                printErrorMessage();
                break;
        }
    }
    private void addProduct(HashMap<String, Item> itemMap, Item I) {
        if (itemMap.containsKey(I.getName())) {
            itemMap.get(I.getName()).addQuantity(I.getAvailableQuantity());
            System.out.println("Quantity updated to " + itemMap.get(I.getName()).getAvailableQuantity());
        } else {
            itemMap.put(I.getName(), I);
            System.out.println("Item: " + I.getName() + " Added Successfully");
        }
    }
    private void customerMenu() {
        currentOrder = new Order();
        while (tempInt != 0) {
            menuNavigate();
            System.out.println("Enter 1 to continue, 0 to finish your order:");
            tempInt = Utility.enforceIntReturn();
        }
        currentOrder.printOrder();
        currentOrder = null;    //freeing memory
    } 
    private static void printErrorMessage() {
        System.out.println("Invalid input. Please try again.");
    }
    private static void printThanksMessage() {
        System.out.println("Thank you for using our shopping system.");
    }
    private void smartPrint() {
        List<Item> values = new ArrayList<Item>(warehouse.values());
        Collections.sort(values);
        System.out.println("\t=========Food Section=========");
        for (Item I : values) {
            if (I instanceof Food && I.getAvailableQuantity() > 0)
                System.out.println(I.toString());
        }

        System.out.println("\t=========Tools Section========");
        for (Item I : values) {
            if (I instanceof Tool && I.getAvailableQuantity() > 0)
                System.out.println(I.toString());
        }
        System.out.println("\t=========Cosmetics Section========");
        for (Item I : values) {
            if (I instanceof Cosmetic && I.getAvailableQuantity() > 0)
                System.out.println(I.toString());
        }
    }
}

