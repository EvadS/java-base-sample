package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        printCapitalized();
    }

    public static void printCapitalized() {
        int letterPosition = 3;

        String inputRow = "Now is the time to act!";
        System.out.println("Input String : " + inputRow);

        String converted = convertLetterToUpperCase(inputRow, --letterPosition);
        System.out.println("result: " + converted);
    }

    public static String convertLetterToUpperCase(String inputRow, int letterPosition) {
        StringBuilder resultBuilder = new StringBuilder();
        String[] inputStrArray = inputRow.split(" ");
        System.out.println("Split input row to array, length:" + inputStrArray.length);

        for (String element : inputStrArray) {
            if (element.length() > letterPosition) {

                StringBuilder sb = new StringBuilder(element);

                if (letterPosition <= element.length()) {
                    char charAt = element.charAt(letterPosition);
                    if (Character.isAlphabetic(charAt)) {
                        sb.setCharAt(letterPosition, Character.toUpperCase(charAt));
                    }
                }
                element = sb.toString();
            }

            resultBuilder.append(element);
            resultBuilder.append(" ");
        }

        return resultBuilder.toString().trim();
    }
}
