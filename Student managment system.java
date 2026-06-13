import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    String grade;

    Student(int rollNo, String name, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.grade = grade;
    }

    void display() {
        System.out.println("\nRoll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Grade   : " + grade);
    }
}
class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addStudent() {

        System.out.print("Enter Roll Number : ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Grade : ");
        String grade = sc.nextLine();

        students.add(new Student(rollNo, name, grade));

        System.out.println("Student Added Successfully!");
    }

    public static void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found!");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    public static void searchStudent() {

        System.out.print("Enter Roll Number : ");
        int roll = sc.nextInt();

        for (Student s : students) {

            if (s.rollNo == roll) {
                System.out.println("Student Found!");
                s.display();
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    public static void removeStudent() {

        System.out.print("Enter Roll Number : ");
        int roll = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).rollNo == roll) {

                students.remove(i);
                System.out.println("Student Removed Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    removeStudent();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);
    }
}