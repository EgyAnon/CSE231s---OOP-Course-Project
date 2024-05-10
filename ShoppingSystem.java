import java.util.*;
import Utility.Utility;

@SuppressWarnings("unused")
public class ShoppingSystem{
    private ArrayList<Food> FoodItems;
    private ArrayList<Tool> ToolItems;
    private ArrayList<Cosmetic> CosmeticItems;

    public void RunSystem(){
        Initialize();
        System.out.println("\t\tWelcome to the Online Shopping System");
        System.out.println("Are you a: ");
        System.out.println("\t1.User\n\t2.Administrator");
        int tempOption;
        Scanner input = new Scanner(System.in);
        tempOption = input.nextInt();
        if(tempOption == 1){
            printAllItems();
        }
        else if(tempOption == 2){

        }
        else{

        }
        input.close();
    }

    private void Initialize(){
        FoodItems = new ArrayList<Food>();
        ToolItems = new ArrayList<Tool>();
        CosmeticItems = new ArrayList<Cosmetic>();

        for(int i = 0; i<10; i++){
            FoodItems.add(new Food());
            CosmeticItems.add(new Cosmetic());
            ToolItems.add(new Tool());
        }
    }

    private void printAllItems(){
        for(Item I : FoodItems){
            System.out.println(I.toString());
            if(I instanceof Expirable){
                System.out.println(((Expirable)I).getExpiryDate());
            }
        }
    }

}