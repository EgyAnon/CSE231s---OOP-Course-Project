import Interfaces.*;
import Utility.*;

@SuppressWarnings("unused")
abstract class Item{
    private String name;
    private double unitPrice;
    private int availableQuantity;
    
    public String getName(){
        return name;
    }

    public int getAvailableQuantity(){
        return availableQuantity;
    }
    public void removeQuantity(int quantity){
        availableQuantity-=quantity;
    }

    public void addQuantity(int quantity){
        availableQuantity+=quantity;
    }

    public Item(String name, double unit_price, int initialQuantity){
        this.name = name;
        this.unitPrice = unit_price;
        this.availableQuantity = initialQuantity;
    }
    
    Item(){
        this("IPSUMLOREM",1,1);
    }

    @Override
    public String toString(){
        String returnString = this.name + " - Available Quantity: " + this.availableQuantity;
        return returnString;
    }

    boolean quantityAvailable(int requiredQuantity){
        if(requiredQuantity<=availableQuantity) return true;
        else return false;
    }

    double calculate_price(double requiredQuantity){
        return requiredQuantity * unitPrice;
    }
}


class Food extends Item{
    
    Food(String foodName,double unitPrice, int initialQuantity)
    {
        super(foodName,unitPrice,initialQuantity);
    }
    
    Food(){ //create a random food item
        this(Utility.getRandomString(10),Utility.getRandomPrice(),10);
    }
}

class Tool extends Item{
    Tool(String foodName,double unitPrice, int initialQuantity){
        super(foodName,unitPrice,initialQuantity);
    }
    Tool(){ //create a random Tool item
        this(Utility.getRandomString(10),Utility.getRandomPrice(),10);
    }
}

class Cosmetic extends Item{


    Cosmetic(String CosmeticName,double unitPrice, int initialQuantity){    
        super(CosmeticName, unitPrice, initialQuantity);
    }
    Cosmetic(){ //create a random Cosmetic item
        this(Utility.getRandomString(10),Utility.getRandomPrice(),10);
    }
}