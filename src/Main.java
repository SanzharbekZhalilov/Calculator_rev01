import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your operation from 1 to 10 (arabic) or I to X (roman):");
        String input = scanner.nextLine();
        int num1;
        int num2;
        String operator;

        String[] operators = input.split("\\w");
        operator = operators[operators.length - 1];

        if (Character.isLetter(input.charAt(0))) {
            try {
                String[] romanStr = input.split("\\W");
                num1 = RomanNum.romanToArabic(romanStr[0]);
                num2 = RomanNum.romanToArabic(romanStr[1]);
                checkNumber(num1);
                checkNumber(num2);
                System.out.println(romanStr[0] + operator + romanStr[0] + "="
                        + RomanNum.arabicToRoman(calculate(num1, num2, operator)));
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        //Arabic Number Calculator
        else {
            try {
                String[] arabicStr = input.split("\\W");
                num1 = Integer.parseInt(arabicStr[0]);
                num2 = Integer.parseInt(arabicStr[1]);
                checkNumber(num1);
                checkNumber(num2);
                System.out.println(num1 + operator + num2 + "="
                        + calculate(num1, num2, operator));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int calculate(int num1, int num2, String operator) {
        return switch (operator) {
            case "+" -> Operation.add(num1, num2);
            case "-" -> Operation.subtract(num1, num2);
            case "*" -> Operation.multiply(num1, num2);
            case "/" -> Operation.divide(num1, num2);
            default -> throw new IllegalArgumentException("Exception: Operator must be [-, +, /, *]");
        };
    }

    public static void checkNumber(int num) throws IllegalArgumentException {
        if (num > 10 || num < 1) {
            throw new IllegalArgumentException("Exception: Numbers must be 1-10 or I-X");
        }
    }
}