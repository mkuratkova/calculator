import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*

*/


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("-?\\d\\s-?\\d|\\+?\\d\\s\\+?\\d");
        Matcher matcher;
        boolean on = true;


        while (on) {
            int count = 0;
            String number;
            number = scanner.nextLine();
            String number1 = number.strip().replaceAll("\\s+", " ").replaceAll("(--)", "\\+")
                    .replaceAll("---", "-").replaceAll("(\\+?-\\++|\\++-\\+?)", "-");
            number1 = number1.replaceAll("\\s+\\++\\s+", " ").replaceAll("\\s+-\\s+", " -");
            String[] numbers = number1.strip().split(" ");
            matcher = pattern.matcher(number);
            try {
                if (number.equals("/exit")) {
                    on = exitCalculator(on);
                } else if (number.equals("/help")) {
                    help();
                } else if (number.equals("")) {
                    continue;
                } else if (numbers.length == 1 && numbers[0].matches("-?\\d+|\\+?\\d+")) {
                    int result = sumNumbers(Integer.parseInt(numbers[0]), 0);
                    System.out.println(result);
                } else if (matcher.find()) {
                    System.out.println("Invalid expression");
                } else if (number.contains("/")) {
                    throw new Exception();
                }
                else if (numbers.length >= 2) {
                    for (int i = 0; i < numbers.length; i++) {
                        count = sumNumbers(count, Integer.parseInt(numbers[i]));
                    }
                    System.out.println(count);
                } else {
                    System.out.println("Invalid expression");
                }

            } catch (Exception e) {
                System.out.println("Unknown command");
            }
        }
    }


    private static boolean exitCalculator(boolean on) {
        System.out.println("Bye!");
        on = false;
        return on;
    }

    private static void help() {
        System.out.println("The program calculates the sum of numbers or substraction of numbers " +
                "based on the input.");
    }

    private static int sumNumbers(int number1, int number2) {
        return number1 + number2;
    }
}

