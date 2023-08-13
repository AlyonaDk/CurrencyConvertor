
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome!");
        System.out.println("From currency list: USD, EUR, GBP.");
        System.out.println("To currency list: USD, EUR, GBP.\n");
        Boolean repeat = true;
        Scanner reader = new Scanner(System.in);
        while (repeat) {
            System.out.println("Please insert your original currency type (Press \"q\" to exit): ");
            String fromType = reader.nextLine();
            if (fromType.equals("q")) {
                repeat = false;
                break;
            } else {
                System.out.println("\nPlease insert the currency type you'd like to convert to (Press \"q\" to exit): ");
                String toType = reader.nextLine();
                if (toType.equals("q")) {
                    repeat = false;
                    break;
                } else {
                    System.out.println("\nPlease enter conversion amount: ");
                    try {
                        Float moneyAmount = Float.parseFloat(reader.nextLine());
                        Currency curObj = new Currency();
                        try {
                            Float rate = curObj.getRate(fromType, toType);
                            Float converted = rate * moneyAmount;
                            System.out.println("\nYour amount converted to " + toType + ": ");
                            System.out.printf("%.2f %n %n", converted);
                        } catch (Exception e) {
                            System.out.println("\nBase currency value not found or invalid.\n");
                        }
                    } catch (Exception e) {
                        System.out.println("\nInvalid money value.\n");
                    }
                }
            }
        }
        reader.close();
        System.out.println("\nThanks for using Currency Converter!");
        System.out.println("\nExited program... \n");
    }
}
