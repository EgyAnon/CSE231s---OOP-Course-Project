package Utility;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("resource")
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

  public static int enforceIntReturn() {
    int tempInt = 0;
    Scanner input = new Scanner(System.in);
    try {
      tempInt = input.nextInt();
      return tempInt;
    } catch (InputMismatchException ex) {
      System.out.println("Sorry, invalid input.");
      return enforceIntReturn();
    }
  }

  public static String enforceStringReturn() {
    String tempString = "";
    Scanner input = new Scanner(System.in);
    try {
      tempString = input.nextLine();
      return tempString;
    } catch (InputMismatchException ex) {
      System.out.println("Sorry, invalid input.");
      return enforceStringReturn();
    }
  }

  public static double enforceDoubleReturn() {
    double tempdouble = 0.0;
    Scanner input = new Scanner(System.in);
    try {
      tempdouble = input.nextDouble();
      return tempdouble;
    } catch (InputMismatchException ex) {
      System.out.println("Sorry, invalid input.");
      return enforceDoubleReturn();
    }
  }

  public static String getRandomString(int length) {
    StringBuilder sb = new StringBuilder();
    String charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // Combine uppercase letters and numbers
  
    for (int i = 0; i < length; i++) {
      int charIndex = (int) (Math.random() * charSet.length()); // Generate random index within the charSet
      char randomChar = charSet.charAt(charIndex);
      sb.append(randomChar);
    }
  
    return sb.toString();
  }

  public static String generateRandomId() {
    StringBuilder sb = new StringBuilder();
    // Loop 10 times to generate each digit
    for (int i = 0; i < 10; i++) {
      // Generate random digit between 0 and 9 (inclusive)
      int digit = (int) (Math.random() * 10);
      sb.append(digit);
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
