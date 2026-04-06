/**
 * Project: Course System
 * Author: [Nik Muhammad Airiel bin Roslin]
 * Description: This program allows users to add, search, edit, delete, and view course profiles using direct input and output.
 */



import java.util.ArrayList;
import java.util.Scanner;

public class CourseProfileSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Course> courseList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== COURSE PROFILE SYSTEM =====");
            System.out.println("1. Add Course");
            System.out.println("2. Search Course");
            System.out.println("3. Edit Course");
            System.out.println("4. Delete Course");
            System.out.println("5. View All Courses");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next();
                System.out.print("Enter your choice: ");
            }

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    searchCourse();
                    break;
                case 3:
                    editCourse();
                    break;
                case 4:
                    deleteCourse();
                    break;
                case 5:
                    viewAllCourses();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }

    // Add Course
    public static void addCourse() {
        System.out.println("\n--- Add Course ---");

        System.out.print("Enter Course Name: ");
        String name = sc.nextLine();

        String code;
        while (true) {
            System.out.print("Enter Course Code: ");
            code = sc.nextLine().trim();

            if (code.isEmpty()) {
                System.out.println("Course code cannot be empty.");
            } else if (isDuplicateCode(code)) {
                System.out.println("Course code already exists! Enter a unique code.");
            } else {
                break;
            }
        }

        int credit;
        while (true) {
            System.out.print("Enter Credit Hour: ");
            if (sc.hasNextInt()) {
                credit = sc.nextInt();
                sc.nextLine(); // clear buffer

                if (credit > 0) {
                    break;
                } else {
                    System.out.println("Credit Hour must be greater than 0.");
                }
            } else {
                System.out.println("Invalid input! Credit Hour must be a number.");
                sc.next();
            }
        }

        System.out.print("Enter Course Summary: ");
        String summary = sc.nextLine();

        System.out.print("Enter MS Teams Link: ");
        String link = sc.nextLine();

        Course newCourse = new Course(name, code, credit, summary, link);
        courseList.add(newCourse);

        System.out.println("Course added successfully!");
    }

    // Check duplicate course code
    public static boolean isDuplicateCode(String code) {
        for (Course c : courseList) {
            if (c.getCourseCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    // Search Course
    public static void searchCourse() {
        System.out.println("\n--- Search Course ---");

        if (courseList.isEmpty()) {
            System.out.println("No courses available to search.");
            return;
        }

        System.out.print("Enter Course Code to search: ");
        String searchCode = sc.nextLine().trim();

        boolean found = false;

        for (Course course : courseList) {
            if (course.getCourseCode().equalsIgnoreCase(searchCode)) {
                System.out.println("\nCourse found:");
                course.displayCourse();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Course not found.");
        }
    }

    // Edit Course
    public static void editCourse() {
        System.out.println("\n--- Edit Course ---");

        if (courseList.isEmpty()) {
            System.out.println("No courses available to edit.");
            return;
        }

        System.out.print("Enter Course Code to edit: ");
        String editCode = sc.nextLine().trim();

        boolean found = false;

        for (Course course : courseList) {
            if (course.getCourseCode().equalsIgnoreCase(editCode)) {
                System.out.println("\nCourse found:");
                course.displayCourse();

                System.out.print("Enter New Course Name: ");
                String newName = sc.nextLine();

                int newCredit;
                while (true) {
                    System.out.print("Enter New Credit Hour: ");
                    if (sc.hasNextInt()) {
                        newCredit = sc.nextInt();
                        sc.nextLine();

                        if (newCredit > 0) {
                            break;
                        } else {
                            System.out.println("Credit Hour must be greater than 0.");
                        }
                    } else {
                        System.out.println("Invalid input! Credit Hour must be a number.");
                        sc.next();
                    }
                }

                System.out.print("Enter New Course Summary: ");
                String newSummary = sc.nextLine();

                System.out.print("Enter New MS Teams Link: ");
                String newLink = sc.nextLine();

                course.setCourseName(newName);
                course.setCreditHour(newCredit);
                course.setCourseSummary(newSummary);
                course.setMsTeamsLink(newLink);

                System.out.println("\nCourse updated successfully!");
                System.out.println("Updated Course:");
                course.displayCourse();

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Course not found.");
        }
    }

    // Delete Course
    public static void deleteCourse() {
        System.out.println("\n--- Delete Course ---");

        if (courseList.isEmpty()) {
            System.out.println("No courses available to delete.");
            return;
        }

        System.out.print("Enter Course Code to delete: ");
        String deleteCode = sc.nextLine().trim();

        boolean found = false;

        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseCode().equalsIgnoreCase(deleteCode)) {
                System.out.println("\nCourse found:");
                courseList.get(i).displayCourse();

                System.out.print("Are you sure you want to delete this course? (Y/N): ");
                String confirm = sc.nextLine();

                if (confirm.equalsIgnoreCase("Y")) {
                    courseList.remove(i);
                    System.out.println("Course deleted successfully!");
                    System.out.println("\nUpdated Course List:");
                    viewAllCourses();
                } else {
                    System.out.println("Deletion cancelled.");
                }

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Course not found.");
        }
    }

    // View All Courses
    public static void viewAllCourses() {
        System.out.println("\n--- All Courses ---");

        if (courseList.isEmpty()) {
            System.out.println("No course records available.");
            return;
        }

        for (Course course : courseList) {
            course.displayCourse();
        }
    }
}