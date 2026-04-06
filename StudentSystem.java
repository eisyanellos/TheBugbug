/**
 * Project: Student System
 * Author: [Danish Haikal bin Zalipullizam & Muhammad Haziq Iqbal bin Nor Azhari]
 * Description: This program allows users to add, search, edit, delete, and view student profiles using direct input and output.
 */

package slms;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private String email;
    private String phone;

    public Student(String firstName, String lastName, String studentId, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.email = email;
        this.phone = phone;
    }

    // Getters
    public String getStudentId() { return studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    // Setters
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }

    // Display
    public void display() {
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("---------------------------");
    }
}

public class StudentSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== STUDENT PROFILE SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Edit Student");
            System.out.println("4. Delete Student");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");
            System.out.println("---------------------------");
            System.out.println("");
            System.out.print("Choose: ");

            int choice;

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); // clear buffer
            } else {
                System.out.println("Invalid input! Please enter number (1-6).");
                sc.nextLine(); // clear invalid input
                continue; // go back to menu
            }
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    viewAll();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // VALIDATION
    static boolean isValidInput(String input) {
        return !input.trim().isEmpty();
    }

    static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
    
    static boolean isValidPhone(String phone) {
        return phone.matches("\\d+");
    }

    // ADD
    static void addStudent() {
        System.out.print("\n--- Add Student ---");
        System.out.print("\nEnter First Name: ");
        String fn = sc.nextLine();
        if (!isValidInput(fn)) {
            System.out.println("Invalid first name!");
            return;
        }

        System.out.print("Enter Last Name: ");
        String ln = sc.nextLine();
        if (!isValidInput(ln)) {
            System.out.println("Invalid last name!");
            return;
        }

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        if (!isValidInput(id)) {
            System.out.println("Invalid ID!");
            return;
        }

        if (findStudent(id) != null) {
            System.out.println("ID already exists!");
            return;
        }

        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        while (!isValidEmail(email)) {
            System.out.print("Invalid email! Re-enter: ");
            email = sc.nextLine();
        }

        System.out.print("Enter Phone: ");
        String phone;
        while (true) {
            phone = sc.nextLine();

            if (isValidPhone(phone)) break;
            System.out.println("Invalid phone! Numbers only.");
        }

        students.add(new Student(fn, ln, id, email, phone));
        System.out.println("Student added successfully!");
    }

    // SEARCH
    static void searchStudent() {
        System.out.print("\n--- Search Student ---");
        System.out.print("\nEnter ID: ");
        String id = sc.nextLine();
        
        Student s = findStudent(id);

        if (s != null) {
            System.out.println("");
            System.out.println("=== STUDENT FOUND! ===");
            s.display();
        } else {
            System.out.println("Student not found!");
        }
    }

    // EDIT
    static void editStudent() {
        System.out.print("\n--- Edit Student ---");
        System.out.print("\nEnter ID: ");
        String id = sc.nextLine();

        Student s = findStudent(id);

        if (s != null) {
            System.out.println("");
            System.out.println("=== STUDENT FOUND! ===");
            s.display();
            System.out.print("\n**Leave blank if no changes");
            System.out.print("\nEnter New First Name: ");
            String fn = sc.nextLine().trim();
            if (!fn.isEmpty()) {
                s.setFirstName(fn);
            }

            System.out.print("Enter New Last Name: ");
            String ln = sc.nextLine().trim();
            if (!ln.isEmpty()) {
                s.setLastName(ln);
            }

            System.out.print("Enter New Email: ");
            String email = sc.nextLine().trim();
            if (!email.isEmpty()) {
                while (!isValidEmail(email)) {
                    System.out.print("Invalid email! Re-enter: ");
                    email = sc.nextLine().trim();
                }
                s.setEmail(email);
            }

            System.out.print("Enter New Phone: ");
            String phone = sc.nextLine().trim();
            if (!phone.isEmpty()) {
                while (!isValidPhone(phone)) {
                    System.out.print("Invalid phone! Re-enter: ");
                    phone = sc.nextLine().trim();
                }
                s.setPhone(phone);
            }

            System.out.println("Updated successfully!");
            
            System.out.println("");
            System.out.println("=== UPDATED PROFILE ===");
            s.display();

        } else {
            System.out.println("Student not found!");
        }
    }

    // DELETE
    static void deleteStudent() {
        System.out.print("\n--- Delete Student ---");
        System.out.print("\nEnter ID: ");
        String id = sc.nextLine();

        Student s = findStudent(id);

        if (s != null) {
            s.display();
            System.out.print("Confirm delete? (y/n): ");
            String confirm = sc.nextLine();

            if (confirm.equalsIgnoreCase("y")) {
                students.remove(s);
                System.out.println("Deleted successfully!");
            } if (confirm.equalsIgnoreCase("n")) {
                System.out.println("Deletion cancelled!");
              }
        } else {
            System.out.println("Student not found!");
        }
        viewAll();
    }

    // VIEW ALL
    static void viewAll() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n=== ALL STUDENTS ===");
        for (Student s : students) {
            s.display();
        }
    }

    // LINEAR SEARCH
    static Student findStudent(String id) {
        for (Student s : students) {
            if (s.getStudentId().equals(id)) {
                return s;
            }
        }
        return null;
    }
}