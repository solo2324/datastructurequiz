package question1;


import java.util.Scanner;

public class NumberSearch {
    public static int countOccurrences(int[] numbers, int target) {
        int count = 0;
        for (int num : numbers) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sequence of numbers (space-separated): ");
        System.out.flush(); // Flush the output stream
        String[] numbersStr = scanner.nextLine().split(" ");
        int[] numbers = new int[numbersStr.length];
        for (int i = 0; i < numbersStr.length; i++) {
            numbers[i] = Integer.parseInt(numbersStr[i]);
        }

        System.out.print("Enter a number to be searched: ");
        int target = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        int occurrences = countOccurrences(numbers, target);

        if (occurrences > 0) {
            System.out.println("The number " + target + " appears " + occurrences + " time(s) in the array.");
        } else {
            System.out.println("The number " + target + " does not appear in the array.");
        }
    }
}
