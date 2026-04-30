/**
 * Project: Student Learning Management System (SLMS)
 * Module: Student Data Profile
 * Author: NIK MUHAMMAD AIRIEL
 * Description: Handles the data attributes and object construction for students.
 */

package slms;

public class Student {
    protected String firstName; // protected so subclass can access
    protected String lastName;
    protected String studentId;
    protected String email;
    protected String phone;

    public Student(String firstName, String lastName, String studentId, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.email = email;
        this.phone = phone;
    }

    public String getStudentId() { return studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    public void display() {
        System.out.println("ID: " + studentId + " | Name: " + firstName + " " + lastName);
    }
}