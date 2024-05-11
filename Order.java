/*import java.util.ArrayList;
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
            for(Pair<Item,Integer> P : orderContent){
                System.out.println(P.getFirst().getName() + " x" + P.getSecond());
            }
            System.out.println("----------Total Price = " + totalPrice + "----------");
        }

    }
}
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class OrderGUI extends Application {
    private ArrayList<Pair<Item,Integer>> orderContent;
    private double totalPrice;
    private ListView<String> orderListView;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Online Order System");

        orderContent = new ArrayList<>();
        totalPrice = 0;

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label nameLabel = new Label("Product Name:");
        GridPane.setConstraints(nameLabel, 0, 0);

        TextField nameField = new TextField();
        GridPane.setConstraints(nameField, 1, 0);

        Label quantityLabel = new Label("Quantity:");
        GridPane.setConstraints(quantityLabel, 0, 1);

        TextField quantityField = new TextField();
        GridPane.setConstraints(quantityField, 1, 1);

        Button addButton = new Button("Add to Order");
        GridPane.setConstraints(addButton, 1, 2);
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            Item item = new Item(name); // You need to define the Item class
            addProduct(item, quantity);
        });

        Button totalPriceButton = new Button("Total Price");
        GridPane.setConstraints(totalPriceButton, 0, 2);
        totalPriceButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Total Price");
            alert.setHeaderText(null);
            alert.setContentText("Total Price: " + totalPrice);
            alert.showAndWait();
        });

        orderListView = new ListView<>();
        GridPane.setConstraints(orderListView, 0, 3, 2, 1);

        grid.getChildren().addAll(nameLabel, nameField, quantityLabel, quantityField, addButton, totalPriceButton, orderListView);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void addProduct(Item item, int quantity) {
        orderContent.add(new Pair<>(item, quantity));
        totalPrice += item.calculatePrice(quantity); // You need to define the calculatePrice() method in the Item class
        updateOrderListView();
    }

    public void updateOrderListView() {
        orderListView.getItems().clear();
        for (Pair<Item, Integer> pair : orderContent) {
            String itemName = pair.getFirst().getName();
            int quantity = pair.getSecond();
            orderListView.getItems().add(itemName + " x" + quantity);
        }
    }

 /*   public static void main(String[] args) {
        launch(args);
    }
    */
}
