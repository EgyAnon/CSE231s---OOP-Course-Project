import Interfaces.*;
import java.time.LocalDateTime;
import Utility.Utility;

@SuppressWarnings("unused")
abstract class Item{
    private String name;
    private double unit_price;
    private int available_quantity;
    
    Item(String name, double unit_price, int initialQuantity){
        this.name = name;
        this.unit_price = unit_price;
        this.available_quantity = initialQuantity;
    }
    
    private Item(){
        this("IPSUMLOREM",1,1);
    }

    @Override
    public String toString(){
        String returnString = this.name + " - Available Quantity: " + this.available_quantity;
        return returnString;
    }

    boolean check_availability(int requiredQuantity){
        if(requiredQuantity<=available_quantity) return true;
        else return false;
    }

    double calculate_price(double requiredQuantity){
        return requiredQuantity * unit_price;
    }
}

abstract class Expirable extends Item{
    LocalDateTime expiryDate;
    Expirable(String ExpirableName,double unitPrice, int initialQuantity,
    int expiryMonth, int expiryDay,int expiryHour, int expiryMinute){
        super(ExpirableName,unitPrice,initialQuantity);
        expiryDate = getCustomDate(expiryMonth,expiryDay,expiryHour,expiryMinute);
    }

    Expirable(String ExpirableName,double unitPrice, int initialQuantity,
    int expiryMonth, int expiryDay){
        super(ExpirableName,unitPrice,initialQuantity);
        expiryDate = getCustomDate(expiryMonth,expiryDay,23,59);
    }

    static LocalDateTime getCustomDate(int expiryMonth, int expiryDay, int expiryHour, int expiryMinute) {
        LocalDateTime CustomDate = LocalDateTime.now();
        CustomDate = CustomDate.of(CustomDate.getYear(), expiryMonth, expiryDay, expiryHour, expiryMinute);
        return CustomDate;
    }

    String getExpiryDate(){
        return expiryDate.toString();
    }


}

class Food extends Expirable{
    
    Food(String foodName,double unitPrice, int initialQuantity,
    int expiryMonth, int expiryDay,int expiryHour, int expiryMinute){
        super(foodName,unitPrice,initialQuantity,expiryMonth,expiryDay,expiryHour,expiryMinute);
    }

    Food(String foodName,double unitPrice, int initialQuantity,
    int expiryMonth, int expiryDay){
        super(foodName,unitPrice,initialQuantity,expiryMonth,expiryDay);
    }

    Food(){ //create a random food item
        this(Utility.getRandomString(10),Utility.getRandomPrice(),10,5,29);
    }
}

class Tool extends Item{
    Tool(String foodName,double unitPrice, int initialQuantity){
        super(foodName,unitPrice,initialQuantity);
    }
    Tool(){ //create a random food item
        this(Utility.getRandomString(10),Utility.getRandomPrice(),10);
    }
}

class Cosmetic extends Expirable{
    Cosmetic(String CosmeticName,double unitPrice, int initialQuantity,
    int expiryMonth, int expiryDay,int expiryHour, int expiryMinute){
        super(CosmeticName,unitPrice,initialQuantity,expiryMonth,expiryDay,expiryHour,expiryMinute);
    }

    Cosmetic(String CosmeticName,double unitPrice, int initialQuantity,
    int expiryMonth, int expiryDay){
        super(CosmeticName,unitPrice,initialQuantity,expiryMonth,expiryDay);
    }

    Cosmetic(String CosmeticName,double unitPrice, int initialQuantity){    
        this(CosmeticName, unitPrice, initialQuantity,12, 25,10,0);
    }
    Cosmetic(){ //create a random Cosmetic item
        this(Utility.getRandomString(10),Utility.getRandomPrice(),10);
    }
}