import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String returnString = "";
        String[] morseLetters = { ".- ", "-... ", "-.-. ", "-.. ", ". ", "..-. ", "--. ", ".... ", ".. ", ".--- ",
                "-.- ",
                ".-.. ", "-- ", "-. ", "--- ", ".--.", "--.- ", ".-. ", "... ", "- ", "..- ", "...- ", ".-- ", "-..- ",
                "-.-- ", "--.. " };

        String[] morseNumbers = { ".---- ", "..--- ", "...--", "....- ", ".....", "-.... ", "--... ", "---.. ",
                "----. ", "----- " };

        System.out.println("Enter String to translate");
        String input = scanner.nextLine();
        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == ' ') {
                returnString += "/ ";
                continue;
            }

            if (!isCharNumeric(input.substring(i, i + 1))) {
                char tempChar = input.charAt(i);
                int pos = tempChar - 'a' + 1;
                returnString += morseLetters[pos - 1];
            } else {
                returnString += morseNumbers[Integer.parseInt(input.substring(i, i+ 1)) - 1];
            }
        }
        System.out.println(returnString);
    }

    public static boolean isCharNumeric(String input) {
        if (input == null)
            return false;

        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
