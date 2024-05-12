package Utility;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Utility {
  public static boolean isAllDigits(String s) {
    if (s.length() == 0)
      return false;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!Character.isDigit(c))
        return false;
    }
    return true;
  }

  public static int enforceIntReturn(){
    int tempInt = 0;
    Scanner input = new Scanner(System.in);
    try{
      tempInt = input.nextInt();
      return tempInt;
    }
    catch(InputMismatchException ex){
      System.out.println("Sorry, invalid input.");
      return enforceIntReturn();
    }
  }
  public static String enforceStringReturn(){
    String tempString = "";
    Scanner input = new Scanner(System.in);
    try{
      tempString = input.nextLine();
      return tempString;
    }
    catch(InputMismatchException ex){
      System.out.println("Sorry, invalid input.");
      return enforceStringReturn();
    }
  }
  public static double enforceDoubleReturn(){
    double tempdouble = 0.0;
    Scanner input = new Scanner(System.in);
    try{
      tempdouble = input.nextDouble();
      return tempdouble;
    }
    catch(InputMismatchException ex){
      System.out.println("Sorry, invalid input.");
      return enforceDoubleReturn();
    }
  }

  public static String getRandomString(int length) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
      int charIndex = (int) (Math.random() * 26); // Generate random index for a-z characters
      char randomChar = (char) ('a' + charIndex);
      sb.append(randomChar);
    }
    return sb.toString();
  }

  public static double getRandomPrice() {
    // Generate a random integer between 100 (inclusive) and 1000 (exclusive)
    Random random = new Random();
    int randomInt = random.nextInt(900) + 100;

    // Convert the integer to a double and divide by 10 to get one decimal place
    // precision
    double price = randomInt / 10.0;

    return price;
  }
}
