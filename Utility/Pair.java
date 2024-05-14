/**
* @description a simple data structures that allows us to pair two entities together 
* @author Ahmed Karam - ID: 210176
* @author Ahmed Haitham - ID: 2101629
**/


package Utility;
public class Pair<K, V>{
    private K first;
    private V second;
  
    public Pair(K first, V second) {
      this.first = first;
      this.second = second;
    }
  
    // Getter for first
    public K getFirst() {
      return first;
    }
  
    // Setter for first
    public void setFirst(K first) {
      this.first = first;
    }
  
    // Getter for second
    public V getSecond() {
      return second;
    }
  
    // Setter for second
    public void setSecond(V second) {
      this.second = second;
    }
  }
  