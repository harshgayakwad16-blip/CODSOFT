import java.util.Scanner;

 class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== STUDENT GRADE CALCULATOR =====");

        System.out.print("Enter Number of Subjects: ");
        int subjects = sc.nextInt();

        int totalMarks = 0;

        for (int i = 1; i <= subjects; i++) {

            int marks;

            do {
                System.out.print("Enter Marks for Subject " + i + " (0-100): ");
                marks = sc.nextInt();

                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid Marks! Please enter between 0 and 100.");
                }

            } while (marks < 0 || marks > 100);

            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / subjects;

        String grade;

        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("\n========== RESULT ==========");
        System.out.println("Total Marks        : " + totalMarks);
        System.out.println("Average Percentage : " + averagePercentage + "%");
        System.out.println("Grade              : " + grade);

        if (grade.equals("A+") || grade.equals("A")) {
            System.out.println("Performance : Excellent!");
        } else if (grade.equals("B")) {
            System.out.println("Performance : Good!");
        } else if (grade.equals("C")) {
            System.out.println("Performance : Average!");
        } else {
            System.out.println("Performance : Needs Improvement!");
        }

        sc.close();
    }
}