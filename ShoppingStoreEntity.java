/**
 * This abstract class represents a base entity for various shopping store items.
 * It provides a foundation for building specific shopping store entities like Product or Service.
 * 
 * @author Ahmed Haitham - ID: 2101629
 * @author Ahmed Karam - ID: 2101767
 */

public abstract class ShoppingStoreEntity {

    /**
     * The name of the shopping store entity.
     */
    private String name;
  
    /**
     * Constructor for the ShoppingStoreEntity class.
     * 
     * @param name The name of the shopping store entity.
     */
    public ShoppingStoreEntity(String name) {
      this.name = name;
    }
  
    /**
     * Getter method for the name property.
     * 
     * @return The name of the shopping store entity.
     */
    public String getName() {
      return name;
    }
  
    /**
     * Setter method for the name property.
     * 
     * @param name The name to set for the shopping store entity.
     */
    public void setName(String name) {
      this.name = name;
    }
  }