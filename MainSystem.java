/**
 * Project: Student System
 * Author: [Danish Haikal bin Zalipullizam & Muhammad Haziq Iqbal bin Nor Azhari]
 * Description: This program allows users to integrate both Courses and Students profile system.
 */

package slms;

import java.util.Scanner;

public class MainSystem {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== MAIN SYSTEM ===");
            System.out.println("1. Student Module");
            System.out.println("2. Course Module");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice;

            // prevent crash (invalid input)
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Invalid input! Enter number.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    courseMenu();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // =========================
    // STUDENT MODULE
    // =========================
    static void studentMenu() {

        while (true) {
            System.out.println("\n=== STUDENT MODULE ===");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Edit Student");
            System.out.println("4. Delete Student");
            System.out.println("5. View All Students");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose: ");

            int choice;

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Invalid input!");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    StudentSystem.addStudent();
                    break;
                case 2:
                    StudentSystem.searchStudent();
                    break;
                case 3:
                    StudentSystem.editStudent();
                    break;
                case 4:
                    StudentSystem.deleteStudent();
                    break;
                case 5:
                    StudentSystem.viewAll();
                    break;
                case 6:
                    return; // back to main menu
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // =========================
    // COURSE MODULE
    // =========================
    static void courseMenu() {

        while (true) {
            System.out.println("\n=== COURSE MODULE ===");
            System.out.println("1. Add Course");
            System.out.println("2. Search Course");
            System.out.println("3. Edit Course");
            System.out.println("4. Delete Course");
            System.out.println("5. View All Courses");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose: ");

            int choice;

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Invalid input!");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    CourseSystem.addCourse();   // from your previous lab
                    break;
                case 2:
                    CourseSystem.searchCourse();
                    break;
                case 3:
                    CourseSystem.editCourse();
                    break;
                case 4:
                    CourseSystem.deleteCourse();
                    break;
                case 5:
                    CourseSystem.viewAllCourses();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
