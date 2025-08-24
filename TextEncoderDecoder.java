import java.util.*;

public class TextEncoderDecoder {

    public static String encode(String message, int shift) {
        StringBuilder encoded = new StringBuilder();

        for (char c : message.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char ch = (char) ((c - 'A' + shift) % 26 + 'A');
                encoded.append(ch);
            } else if (Character.isLowerCase(c)) {
                char ch = (char) ((c - 'a' + shift) % 26 + 'a');
                encoded.append(ch);
            } else {
                encoded.append(c);
            }
        }

        return encoded.toString();
    }
 
    public static String decode(String message, int shift) {
        return encode(message, 26 - (shift % 26));
    }

    public static void displayMenu() {
        System.out.println("\n--- Basic Text Encoder and Decoder ---");
        System.out.println("1. Encode a message");
        System.out.println("2. Decode a message");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter your message: ");
                    String messageToEncode = scanner.nextLine();
                    System.out.print("Enter shift number: ");
                    int encodeShift = scanner.nextInt();
                    scanner.nextLine();

                    String encodedMessage = encode(messageToEncode, encodeShift);
                    System.out.println("Encoded Message: " + encodedMessage);
                    break;

                case 2: 
                    System.out.print("Enter your message: ");
                    String messageToDecode = scanner.nextLine();
                    System.out.print("Enter shift number: ");
                    int decodeShift = scanner.nextInt();
                    scanner.nextLine();

                    String decodedMessage = decode(messageToDecode, decodeShift);
                    System.out.println("Decoded Message: " + decodedMessage);
                    break;

                case 3: 
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
