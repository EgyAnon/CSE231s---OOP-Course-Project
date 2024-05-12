import java.util.*;
import Utility.*;

@SuppressWarnings("unused")
public class ShoppingSystem {
    private static String employeePassword = "password";
    private int tempInt;
    private double tempDouble;
    private String tempString;
    private HashMap<String, Item> warehouse;
    private Customer currentUser;
    private Scanner iScanner;

    public ShoppingSystem() {
        warehouse = new HashMap<String, Item>();
        iScanner = new Scanner(System.in);
        tempInt = 0;
        Initialize();
    }
    private static void printErrorMessage() {
        System.out.println("Invalid input. Please try again.");
    }
    private void mainMenu() {
        boolean continueOperation = true;
        System.out.println("\t\tWelcome to the Online Shopping System");
        System.out.print("Enter 1 to continue: ");
        try {
            tempInt = iScanner.nextInt();
        } catch (InputMismatchException ex) {
            tempInt = 0;
        }
        if (tempInt != 1) {
            iScanner.close();
            System.exit(0);
        }
        while (continueOperation) {
            System.out.println("Are you a: ");
            System.out.println("\t1.Customer\n\t2.Employee\n\t3.exit");
            tempInt = iScanner.nextInt();

            if (tempInt == 1) customerMenu();
            else if (tempInt == 2) EmployeeMenu();
            else continueOperation = false;
        }
        System.out.println("Thank you for using our online shopping system.");
    }
    public void menuNavigate(HashMap<String, Item> itemMap, Order currentOrder) {
        smartPrint();
        System.out.print("Enter name of product(enter back if you wish to return): ");
        tempString = iScanner.nextLine();
        tempString = iScanner.nextLine();

        if(tempString.contains("back")){}
        else if(!itemMap.containsKey(tempString)) {
            System.out.println("item doesn't exist.");
        }
        else{
            Item tempItem = itemMap.get(tempString);    //shallow copy required here.
            System.out.print("Enter required quantity: ");
            tempInt = iScanner.nextInt();
            if (tempItem.quantityAvailable(tempInt)) {
                System.out.println("Added to cart");
                currentOrder.addProduct(tempItem, tempInt);
                tempItem.removeQuantity(tempInt);
            }
            else {
                System.out.println("Not enough product available.");
            }
        } 
    }
    private void EmployeeMenu() {
        System.out.println("Enter employee password");
        tempString = iScanner.nextLine();
        tempString = iScanner.nextLine();
        if (!tempString.equals(employeePassword)) {
            System.out.println("Incorrect employee password.");
        }
        else {
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
    private void modifyProductsMenu() {
        boolean continueModification = true;
        while(continueModification){
            System.out.print("Enter Product name (Enter\"back\" to return):");
            tempString = iScanner.nextLine();
            tempString = iScanner.nextLine();
            if(tempString == "back") continueModification = false;
            else if(warehouse.containsKey(tempString)){
                System.out.print("How many units do you want to add? ");
                tempInt = iScanner.nextInt();
                warehouse.get(tempString).addQuantity(tempInt);
                System.out.println("Added " + tempInt + " units to " + tempString + " successfully.");
            }
            else{
                System.out.println("Item not found.");
            }
        }
    }
    private void addProductMenu() {
        int switchInt;

        System.out.print("What type of product to you wish to add?\n\t1.Food\n\t2.Tools\n\t3.Cosmetics\n");
        switchInt = iScanner.nextInt();

        System.out.print("Enter product name: ");
        tempString = iScanner.nextLine();
        tempString = iScanner.nextLine();

        System.out.print("Enter product quantity: ");
        tempInt = iScanner.nextInt();

        System.out.print("Enter prodcut price: ");
        tempDouble = iScanner.nextDouble();

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
        }
        else {
            itemMap.put(I.getName(), I);
            System.out.println("Item: " + I.getName() + " Added Successfully");
        }
    }

    public void customerMenu() {
        Order currentOrder = new Order();
        while (tempInt != 0) {
            menuNavigate(warehouse, currentOrder);
            System.out.println("Enter 1 to continue, 0 to finish your order:");
            tempInt = iScanner.nextInt();
        }
        currentOrder.printOrder();
    }

    public void RunSystem() {
        mainMenu();
    }

    private void Initialize() {
        warehouse.put("chicken", new Food("chicken", Utility.getRandomPrice(), 10));
        warehouse.put("meat", new Food("meat", Utility.getRandomPrice(), 10));
        warehouse.put("screwdriver", new Tool("screwdriver", Utility.getRandomPrice(), 10));
    }

    private void printAllItems(HashMap<String, Item> itemMap) {
        for (Map.Entry<String, Item> entry : itemMap.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }

    private void smartPrint() {
        System.out.println("\t=========Food Section=========");
        for (Map.Entry<String, Item> entry : warehouse.entrySet()) {
            if (entry.getValue() instanceof Food && entry.getValue().getAvailableQuantity()>0)
            System.out.println(entry.getValue().toString());
        }

        System.out.println("\t=========Tools Section========");
        for (Map.Entry<String, Item> entry : warehouse.entrySet()) {
            if (entry.getValue() instanceof Tool)
            System.out.println(entry.getValue().toString());
        }

        System.out.println("\t=======Cosmetics Section=======");
        for (Map.Entry<String, Item> entry : warehouse.entrySet()) {
            if(entry instanceof Cosmetic)
                System.out.println(entry.getValue().toString());
        }
    }
}