import java.io.Console;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice = Integer.parseInt(scanner.nextLine());
        // write your code here
        String month = switch (choice) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            default -> "error!";
        };
        System.out.println(month);
    }
}