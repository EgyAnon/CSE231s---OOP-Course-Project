import java.util.*;

public static void main(String[] args) {
    ShoppingSystem mySystem = new ShoppingSystem();
    mySystem.initialize();
    mySystem.displayMenu();
}

class ShoppingSystem{
       private ArrayList<Food> FoodItems;
       private ArrayList<Tools> ToolItems;
       private ArrayList<Cosmetics> CosmeticItems;

       void Initialize(){

       } 

       void SignUser(){
        DisplayMainMenu();
       }

       void DisplayMainMenu(){
       }
}

class Item{
    private String name;
    private double unit_price;
    private double available_quantity;

    boolean check_availability(double ordered){
        if(ordered<=available_quantity) return true;
        else return false;
    }

    double calculate_price(double ordered){

    }
}

interface Expirable{
    //marker interface
    Date expiry_date;
}

class Food extends Item implements Expirable{

}

class Tools extends Item{

}

class Cosmetics extends Item implements Expirable{

}

//Enter details: _>
//Menu: Food, Tools, Cosmetics


class User{
    private String name;
    private String Password;
    private String ID;
    private String Address;
    private String PhoneNumber;
}

class Order{
    enum Delivery_Option{
        DELIVERY,
        TAKEAWAY,
    }

    Delivery_Option option;
    java.util.ArrayList<Item> Cart; //if empty-> exit, else->confirm order.
                                    //shallow copies of Items
    double total_price;             //
    double calculate_total_price();
    void UpdateQuantity(){
    }
    double paid_amount;
    void printOrderDetails(){
        //TBI - To be Implemented
    }
}

