import java.util.Scanner;
import java.util.Arrays;


public class StudentsScores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = 5;
        int[] scores = new int[N];

        //Input
        for (int i = 0; i < N; i++) {
            scores[i] =readScore(sc, "Student " + (i + 1) + "score");
        }
        // Average
        double sum = 0;
        for (int s : scores) sum += s;
        double average = sum / N;

        // Students above average
        int above = 0;
        for (int s : scores) if (s > average) above++;

        // Highest and lowest score
        int min = scores[0], max = scores[0];
        for (int s : scores) {
            if (s < min) min = s;
            if (s > max) max = s;
        }
        System.out.println("\n Results");
        System.out.println("Scores: " + Arrays.toString(scores));
        System.out.printf("Class average: %.2f%n", average);
        System.out.println("Count above average: " + above);
        System.out.println("Highest score:" + max);
        System.out.println("Lowest score: " + min);

    }
    private static int readScore(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt + "(0-100): ");
            String line = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(line);
                if (v < 0 || v > 100) {
                    System.out.println("Score must be between 0 and 100.");
                } else {
                    return v;
                }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Try again.");
                }
            }
        }
    }

