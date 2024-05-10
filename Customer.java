//following camelCase convention
import java.time.LocalDateTime;
@SuppressWarnings("unused")

public class Customer{
    private String name;
    private String password;

    Customer(String name, String password){
        this.name = name;
        this.password = password;
    }

    void displayCustomer(){
        System.out.println("Name: " + this.getName());
    }

    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String newName) {
        this.name = newName;
    }

    // Getter for password 
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}