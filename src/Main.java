import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean on = true;


        while (on) {
            int count = 0;
            String number;
            number = scanner.nextLine();
            number = number.strip().replaceAll("\\s+", " ").replaceAll("(--)", "\\+")
                    .replaceAll("---", "-").replaceAll("(\\+?-\\++|\\++-\\+?)", "-");
            number = number.replaceAll("\\s*\\++\\s*", " ").replaceAll("\\s+-\\s+", " -");
            String[] numbers = number.split(" ");
            if (number.equals("/exit")) {
                on = exitCalculator(on);
            } else if (number.equals("/help")) {
                help();
            } else if (number.equals("")) {
                continue;
            } else if (numbers.length == 1 && numbers[0].matches("\\d+")) {
                int result = sumNumbers(numbers[0], "0");
                System.out.println(result);
            } else if (numbers.length >= 2) {
                for (int i = 0; i < numbers.length; i++) {
                    count = count + Integer.parseInt(numbers[i]);
                }
                System.out.println(count);
            }
            else {
                System.out.println("I don't know what you mean. Try it again.");
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

    private static int sumNumbers(String number1, String number2) {
        return Integer.parseInt(number1) + Integer.parseInt(number2);
    }
}

