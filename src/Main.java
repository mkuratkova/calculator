import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Modify your program to handle different cases when the given expression has an invalid format. The program should print "Invalid expression" in such cases.
The program must never throw the NumberFormatException or any other exception.

        If a user enters an invalid command, the program must print "Unknown command".

        All messages must be printed without quotes.

        Do not forget to write methods to decompose your program.

        Input/Output example

        8 + 7 - 4
        11
        abc
        Invalid expression
        123+
        Invalid expression
        +15
        15
        18 22
        Invalid expression

        -22
        -22
        22-
        Invalid expression
        /go
        Unknown command
        /exit
        Bye!
        The program should not stop until the user enters the /exit command (like before).

        "abc\n123+\n+15\n18 22\n\n-22\n22-\n/exit",
                        "Invalid expression\n" +
                                "Invalid expression\n" +
                                "15\n" +
                                "Invalid expression\n" +
                                "-22\n" +
                                "Invalid expression\n" +
                                "Bye!"
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

