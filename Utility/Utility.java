package Utility;
import java.util.Random;

public class Utility {
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
