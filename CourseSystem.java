/**
 * Project: Course System
 * Author: [Nik Muhammad Airiel bin Roslin]
 * Description: This program allows users to add, search, edit, delete, and view course profiles using direct input and output.
 */

package slms;

public class CourseSystem {

    public static class Course {
        String courseCode;
        String courseName;
        int creditHour;
        String courseSummary;
        String teamsLink;

        public Course(String code, String name, int credit, String summary, String link) {
            this.courseCode = code;
            this.courseName = name;
            this.creditHour = credit;
            this.courseSummary = summary;
            this.teamsLink = link;
        }
    }

    static final int MAX = 100;
    public static Course[] courses = new Course[MAX];
    public static int courseCount = 0;

    public static void addCourse(String code, String name, int credit, String summary, String link) {
        if (courseCount < MAX) {
            courses[courseCount++] = new Course(code, name, credit, summary, link);
            System.out.println("Course added successfully!");
        } else {
            System.out.println("Course list full!");
        }
    }

    public static void viewAllCourses() {
        System.out.println("\n--- Registered Courses ---");

        if (courseCount == 0) {
            System.out.println("No courses registered yet.");
            return;
        }

        for (int i = 0; i < courseCount; i++) {
            System.out.println("Code: " + courses[i].courseCode);
            System.out.println("Name: " + courses[i].courseName);
            System.out.println("Credit Hour: " + courses[i].creditHour);
            System.out.println("Summary: " + courses[i].courseSummary);
            System.out.println("MS Teams Link: " + courses[i].teamsLink);
            System.out.println("-----------------------------------");
        }
    }

    public static int findCourse(String code) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].courseCode.equalsIgnoreCase(code)) {
                return i;
            }
        }
        return -1;
    }
}
