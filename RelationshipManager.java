/**
 * Project: Student Learning Management System (SLMS)
 * Author: NUR BATRISYIA AZUHAIMI && NIK MUHAMMAD AIRIEL
 * Description: Responsible for system integration, middleware API,and relationship management logic.
 */

package slms;

public class RelationshipManager {
    // Lab 7: 2D Array to store links [StudentIndex][CourseIndex]
    private static final int MAX = 100;
    private static boolean[][] enrollmentMap = new boolean[MAX][MAX];

    // Method to link a student to a course
    public static void assignStudentToCourse(int studentIdx, int courseIdx) {
        if (studentIdx == -1 || courseIdx == -1) {
            System.out.println("Error: Student or Course not found.");
            return;
        }

        // Lab 7 Requirement: Prevent duplicates
        if (enrollmentMap[studentIdx][courseIdx]) {
            System.out.println("Validation Error: This enrollment already exists.");
        } else {
            enrollmentMap[studentIdx][courseIdx] = true;
            System.out.println("Relationship saved successfully !");
        }
    }

    // Lab 7 Requirement: View students by course
    public static void listStudentsByCourse(int courseIdx) {
        System.out.println("\n--- Enrolled Students ---");
        boolean found = false;
        for (int i = 0; i < StudentSystem.students.size(); i++) {
            if (enrollmentMap[i][courseIdx]) {
                Student s = StudentSystem.students.get(i);
                System.out.println("- " + s.getFirstName() + " " + s.getLastName());
                found = true;
            }
        }
        if (!found) System.out.println("No students enrolled in this course.");
    }
}