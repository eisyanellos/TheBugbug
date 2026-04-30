/**
 * Project: Student System
 * Author: [Danish Haikal bin Zalipullizam & Muhammad Haziq Iqbal bin Nor Azhari]
 * Description: This program allows users to integrate both Courses and Students profile system.
 */

package slms;

import java.util.List;
import java.util.Scanner;

public class MainSystem {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== SLMS MAIN MENU =====");
            System.out.println("1. Student Module");
            System.out.println("2. Course Module");
            System.out.println("3. Enrollment Module");
            System.out.println("4. Search Suggestions");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); // clear buffer
            } else {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1: studentMenu(); break;
                case 2: courseMenu(); break;
                case 3: enrollmentMenu(); break;
                case 4: suggestionMenu(); break;
                case 5: 
                    System.out.println("Exiting System...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Lab 9: Inheritance Selection
    static void studentMenu() {
        System.out.println("\n--- Student Registration ---");
        System.out.println("1. Undergraduate");
        System.out.println("2. Postgraduate");
        System.out.print("Choice: ");
        int type = sc.nextInt(); sc.nextLine();

        System.out.print("First Name: "); String fn = sc.nextLine();
        System.out.print("Last Name: "); String ln = sc.nextLine();
        System.out.print("ID: "); String id = sc.nextLine();
        System.out.print("Email: "); String em = sc.nextLine();
        System.out.print("Phone: "); String ph = sc.nextLine();

        if (type == 2) {
            System.out.print("Research Topic: "); String topic = sc.nextLine();
            StudentSystem.addPostgrad(fn, ln, id, em, ph, topic);
        } else {
            StudentSystem.addStudent(fn, ln, id, em, ph);
        }
        System.out.println("Student saved and cached successfully!");
    }

    static void courseMenu() {
    System.out.println("\n--- Course Module ---");
    System.out.println("1. Add Course");
    System.out.println("2. View All Courses");
    System.out.print("Choice: ");
    int c = sc.nextInt();
    sc.nextLine();

    if (c == 1) {
        System.out.print("Enter Course Code: ");
        String code = sc.nextLine();

        System.out.print("Enter Course Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Credit Hour: ");
        int credit = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course Summary: ");
        String summary = sc.nextLine();

        System.out.print("Enter MS Teams Link: ");
        String link = sc.nextLine();

        CourseSystem.addCourse(code, name, credit, summary, link);

    } else {
        CourseSystem.viewAllCourses();
    }
}

    // Lab 7: Delegating to EnrollmentManager
    static void enrollmentMenu() {
        System.out.print("Enter Student ID: ");
        String sid = sc.nextLine();
        System.out.print("Enter Course Code: ");
        String ccode = sc.nextLine();

        int sIdx = StudentSystem.findStudentIndex(sid);
        int cIdx = CourseSystem.findCourse(ccode);

        EnrollmentManager.enroll(sIdx, cIdx);
    }

    // Lab 8: Delegating to SuggestionAPI
    static void suggestionMenu() {
        System.out.print("Search Name (Type at least 1 letter): ");
        String prefix = sc.nextLine();
        
        List<String> results = SuggestionAPI.getSuggestions(prefix);
        
        if (results.isEmpty()) {
            System.out.println("No matching students found in cache.");
        } else {
            System.out.println("Did you mean: " + results);
        }
    }
}
