package slms;

/**
 * Project: Student Learning Management System (SLMS)
 * Author: NUR BATRISYIA AZUHAIMI && NIK MUHAMMAD AIRIEL
 * Description: Responsible for system integration, middleware API,and relationship management logic.
 */

public class EnrollmentManager {
    // Lab 7: 2D Array [StudentIndex][CourseIndex]
    private static final int MAX = 100;
    // Lab 7 Requirement: Using a 2D Array to map student-to-course relationships
    private static boolean[][] enrollmentMap = new boolean[MAX][MAX];
/**
 * Validates and saves the link between a student and course.
 * Defensive Programming: Checks for -1 (not found) indices.
 */
    public static void enroll(int sIdx, int cIdx) {
        if (sIdx == -1 || cIdx == -1) {
            System.out.println("Error: Student or Course not found in the system.");
            return;
        }

        if (enrollmentMap[sIdx][cIdx]) {
            System.out.println("Validation: Student is already enrolled in this course.");
        } else {
            enrollmentMap[sIdx][cIdx] = true;
            System.out.println("Enrollment recorded successfully !");
        }
    }
}