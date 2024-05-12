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
        orderContent.add(new Pair<Item,Integer>(I,quantity));
        totalPrice += I.calculate_price(quantity);
    }
    void printOrder(){
        System.out.println("========= Order Information ==========");
        if(orderContent.isEmpty()){
            System.out.println("Your cart is empty.");
        }
        else{
            System.out.println("ITEM NAME\t-\tQUANTITY\t-\tSUBTOTAL");
            for(Pair<Item,Integer> P : orderContent){
                System.out.println(P.getFirst().getName()+ "\t\t-\tx" + P.getSecond()+"\t-\t" + P.getSecond()*P.getFirst().getUnitPrice());
            }
            System.out.println("----------Total Price = " + ((int)(totalPrice*10))/10.0 + "----------");

            ShoppingSystem.printThanksMessage();
        }

    }
}
