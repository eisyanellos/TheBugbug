/**
 * Project: Student Learning Management System (SLMS)
 * Author: NIK MUHAMMAD AIRIEL 
 * Description: This class display and stores the course details such as course name, course code, credit hour, course summary, and MS Teams link.
 */

package slms;


public class Course { // Added the missing '{' here
    private String courseName;
    private String courseCode;
    private int creditHour;
    private String courseSummary;
    private String msTeamsLink;

    public Course(String courseName, String courseCode, int creditHour, String courseSummary, String msTeamsLink) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHour = creditHour;
        this.courseSummary = courseSummary;
        this.msTeamsLink = msTeamsLink;
    }

    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
}