/**
 * Project: Student System
 * Author: [Danish Haikal bin Zalipullizam & Muhammad Haziq Iqbal bin Nor Azhari]
 * Description: This program allows users to add, search, edit, delete, and view student profiles using direct input and output.
 */

package slms;
import java.util.*;

public class StudentSystem {
    public static ArrayList<Student> students = new ArrayList<>();
    // Lab 8: Middleware Cache for suggestions
    public static ArrayList<String> studentCache = new ArrayList<>();

    // Regular Student
    public static void addStudent(String fn, String ln, String id, String em, String ph) {
        Student s = new Student(fn, ln, id, em, ph);
        students.add(s);
        studentCache.add(fn.toLowerCase() + " " + ln.toLowerCase());
    }

    // Lab 9: Postgraduate (Inheritance)
    public static void addPostgrad(String fn, String ln, String id, String em, String ph, String topic) {
        PostgradStudent ps = new PostgradStudent(fn, ln, id, em, ph, topic);
        students.add(ps);
        studentCache.add((fn + " " + ln).toLowerCase());
    }
    public void displayAllStudents() {
    System.out.println("\n--- List of Registered Students ---");
    for (int i = 0; i < studentCount; i++) {
        // This is Polymorphism: it calls the correct toString() 
        // whether it is a Student or a PostgradStudent
        System.out.println(students[i].toString());
    }


    public static int findStudentIndex(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equalsIgnoreCase(id)) return i;
        }
        return -1;
    }
}