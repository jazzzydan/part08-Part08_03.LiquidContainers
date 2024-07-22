import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = 0;
        int second = 0;

        while (true) {
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");

            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length < 2) {
                System.out.println("Invalid input, please use: <command> <amount>");
                continue;
            }

            String command = parts[0];
            int amount;

            try {
                amount = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount, please enter a number.");
                continue;
            }

            if (amount < 0) {
                System.out.println("Amount must be a non-negative integer.");
                continue;
            }

            switch (command.toLowerCase()) {
                case "add":
                    first = Math.min(first + amount, 100);
                    break;
                case "move":
                    if (first < amount) {
                        amount = first;
                    }
                    first -= amount;
                    second = Math.min(second + amount, 100);
                    break;
                case "remove":
                    second = Math.max(second - amount, 0);
                    break;
                default:
                    System.out.println("Invalid command. Valid commands are: add, move, remove, quit.");
                    break;
            }
        }

        scanner.close();
    }
}
