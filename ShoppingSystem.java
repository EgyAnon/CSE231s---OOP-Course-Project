import java.util.*;
import Utility.*;

@SuppressWarnings("unused")
public class ShoppingSystem {
    private static String employeePassword = "password";
    private int tempInt;
    private double tempDouble;
    private String tempString;
    private HashMap<String, Item> FoodItems;
    private HashMap<String, Item> ToolItems;
    private HashMap<String, Item> CosmeticItems;
    private HashMap<String, Customer> CustomerDatabase; // maps first names to customer objects

    private Customer currentUser;
    private Scanner iScanner;

    public ShoppingSystem() {
        CustomerDatabase = new HashMap<String, Customer>();
        FoodItems = new HashMap<String, Item>();
        ToolItems = new HashMap<String, Item>();
        CosmeticItems = new HashMap<String, Item>();
        // warehouse = new HashMap<String, Item>();
        iScanner = new Scanner(System.in);
        tempInt = 0;
        // Initialize();
    }

    private static void printErrorMessage() {
        System.out.println("Invalid input. Please try again.");
    }

    private void mainMenu() {
        System.out.println("\t\tWelcome to the Online Shopping System");
        System.out.print("Enter 1 to continue: ");
        try {
            tempInt = iScanner.nextInt();
        } catch (InputMismatchException ex) {
            tempInt = 0;
        }
        if (tempInt != 1) {
            iScanner.close();
            System.out.println("Thank you for using our online shopping system.");
            System.exit(0);
        }
        while (true) {
            System.out.println("Are you a: ");
            System.out.println("\t1.Customer\n\t2.Employee\n\t");
            tempInt = iScanner.nextInt();

            // Customer
            if (tempInt == 1) {
                customerMenu();
            }

            else if (tempInt == 2) {
                EmployeeMenu();
            } else {
                printErrorMessage();
            }
        }

    }

    public void menuNavigate(HashMap<String, Item> itemMap, Order currentOrder) {

        printAllItems(itemMap);

        System.out.print("Enter name of product(enter back if you wish to return): ");
        tempString = iScanner.nextLine();
        if (itemMap.containsKey(tempString)) {
            Item tempItem = itemMap.get(tempString);
            System.out.print("Enter required quantity: ");
            tempInt = iScanner.nextInt();
            if (tempItem.check_availability(tempInt)) {
                System.out.println("Added to cart");
                currentOrder.addProduct(tempItem, tempInt);
                tempItem.removeQuantity(tempInt);
            } else {
                System.out.println("Not enough product available.");
            }
        } else {
            System.out.println("item doesn't exist.");
        }
    }

    private void EmployeeMenu() {
        System.out.println("Enter employee password");
        tempString = iScanner.nextLine();
        tempString = iScanner.nextLine();
        if (!tempString.equals(employeePassword)) {
            System.out.println("Incorrect employee password.");
        } else {
            while (tempInt != 3) {
                System.out.println("==========Employee Dashbord==========");
                System.out.println("1. Modify Products");
                System.out.println("2. Add Products");
                System.out.println("3. exit");
                tempInt = iScanner.nextInt();
                switch (tempInt) {
                    case 1:
                        modifyProductsMenu();
                        break;
                    case 2:
                        addProductMenu();
                        break;

                    default:
                        tempInt = 3;
                        break;
                }
            }
        }

    }

    private boolean checkIfContains(HashMap<String, Item> map, String itemName) {
        return map.containsKey(itemName);
    }

    private void modifyProductsMenu() {
        System.out.println("What is the type of the product you wish to modify?");
        System.out.print("1. Food\n2. Tools\n3. Cosmetics");
        int tempType = iScanner.nextInt();
        if (tempType > 3 || tempType < 1) {
            printErrorMessage();
            return;
        }

        System.out.print("Enter Product name:");
        tempString = iScanner.nextLine();
        tempString = iScanner.nextLine();

        System.out.print("How many units do you want to add? ");
        tempInt = iScanner.nextInt();

        switch (tempType) {
            case 1:
                if (checkIfContains(FoodItems, tempString)) {
                    FoodItems.get(tempString).addQuantity(tempInt);
                    System.out.println("Added " + tempInt + " units to " + tempString + "successfully.");
                } else {
                    System.out.println("This item does not exist.");
                }
                break;
                case 2:
                if (checkIfContains(ToolItems, tempString)) {
                    ToolItems.get(tempString).addQuantity(tempInt);
                    System.out.println("Added " + tempInt + " units to " + tempString + "successfully.");
                } else {
                    System.out.println("This item does not exist.");
                }
                break;
                case 3:
                if (checkIfContains(CosmeticItems, tempString)) {
                    CosmeticItems.get(tempString).addQuantity(tempInt);
                    System.out.println("Added " + tempInt + " units to " + tempString + "successfully.");
                } else {
                    System.out.println("This item does not exist.");
                }
                break;

            default:
                break;
        }

    }

    private void addProductMenu() {
        int switchInt;
        System.out.print("Enter product name: ");
        tempString = iScanner.nextLine();
        tempString = iScanner.nextLine();

        System.out.print("Enter product quantity: ");
        tempInt = iScanner.nextInt();

        System.out.print("Enter prodcut price: ");
        tempDouble = iScanner.nextDouble();

        System.out.print("What type of product to you wish to add?\n\t1.Food\n\t2.Tools\n\t3.Cosmetics\n");
        switchInt = iScanner.nextInt();
        Item I;
        switch (switchInt) {
            case 1:
                I = new Food(tempString, tempDouble, tempInt);
                addProduct(FoodItems, I);
                break;

            case 2:
                I = new Tool(tempString, tempDouble, tempInt);
                addProduct(ToolItems, I);
                break;

            case 3:
                I = new Cosmetic(tempString, tempDouble, tempInt);
                addProduct(CosmeticItems, I);
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

    public void customerMenu() {
        Order currentOrder = new Order();
        while (tempInt != 4) {
            System.out.println("Which section do you want to browse?\n1.Food\n2.Tools\n3.Cosmetics\n4.exit");
            tempInt = iScanner.nextInt();
            tempString = iScanner.nextLine();
            switch (tempInt) {
                case 1:
                    menuNavigate(FoodItems, currentOrder);
                    break;

                case 2:
                    menuNavigate(ToolItems, currentOrder);
                    break;

                case 3:
                    menuNavigate(CosmeticItems, currentOrder);
                    break;

                default:
                    break;
            }
        }
        currentOrder.printOrder();
    }

    public void RunSystem() {
        mainMenu();
    }

    private void Initialize() {
        for (int i = 0; i < 10; i++) {
            String randomFoodName = Utility.getRandomString(10);
            String randomToolName = Utility.getRandomString(10);
            String randomCosmeticName = Utility.getRandomString(10);

            FoodItems.put(randomFoodName, new Food(randomFoodName, Utility.getRandomPrice(), 10));
            ToolItems.put(randomToolName, new Tool(randomToolName, Utility.getRandomPrice(), 10));
            CosmeticItems.put(randomCosmeticName, new Cosmetic(randomFoodName, Utility.getRandomPrice(), 10));
        }
    }

    private void printAllItems(HashMap<String, Item> itemMap) {
        for (Map.Entry<String, Item> entry : itemMap.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }

}