import java.util.Arrays;

public class Exercise1 {

    // 1. Return all failing grades (below 40).
    public static int[] failingGrades(int[] grades) {
        return Arrays.stream(grades)
                .filter(grade -> grade < 40)
                .toArray();
    }

    // 2. Calculate the average grade.
    public static double averageGrade(int[] grades) {
        if (grades == null || grades.length == 0) {
            throw new IllegalArgumentException(
                    "Grades cannot be empty.");
        }

        long sum = 0;

        for (int grade : grades) {
            sum += grade;
        }

        return (double) sum / grades.length;
    }

    // Round one grade according to the assignment's rules.
    public static int roundGrade(int grade) {
        if (grade < 38) {
            return grade;
        }

        int nextMultiple = ((grade / 5) + 1) * 5;

        if (nextMultiple - grade < 3) {
            return nextMultiple;
        }

        return grade;
    }

    // 3. Return all rounded grades.
    public static int[] roundedGrades(int[] grades) {
        int[] result = new int[grades.length];

        for (int i = 0; i < grades.length; i++) {
            result[i] = roundGrade(grades[i]);
        }

        return result;
    }

    // 4. Return the highest rounded grade.
    public static int highestRoundedGrade(int[] grades) {
        if (grades == null || grades.length == 0) {
            throw new IllegalArgumentException(
                    "Grades cannot be empty.");
        }

        int highest = roundGrade(grades[0]);

        for (int i = 1; i < grades.length; i++) {
            int rounded = roundGrade(grades[i]);

            if (rounded > highest) {
                highest = rounded;
            }
        }

        return highest;
    }
}