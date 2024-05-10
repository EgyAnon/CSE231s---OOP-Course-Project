import java.util.ArrayList;
import Utility.*;
public class Order {
    ArrayList<Pair<Item,Integer>> orderContent; 
    double totalPrice;
    Order(){
        totalPrice = 0;
        orderContent = new ArrayList<Pair<Item,Integer>>();
    }

    public void addProduct(Item I, int quantity){
       // Pair<Item, Integer> x = new Pair<Item, Integer>(I,quantity);
        orderContent.add(new Pair<Item,Integer>(I,quantity));
        totalPrice += I.calculate_price(quantity);
    }
    void printOrder(){
        System.out.println("========= Order Information ==========");
        if(orderContent.isEmpty()){
            System.out.println("Your cart is empty.");
        }
        else{
            for(Pair<Item,Integer> P : orderContent){
                System.out.println(P.getFirst().getName() + " x" + P.getSecond());
            }
            System.out.println("----------Total Price = " + totalPrice + "----------");
        }

    }
}
