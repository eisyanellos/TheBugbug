/**
 * Project: Student Learning Management System (SLMS)
 * Module: Student Data Profile
 * Author: NUR BATRISYIA AZUHAIMI 
 * Description: Handles the data attributes and object construction for students.
 */

package slms;


public class PostgradStudent extends Student {
    private String researchField;

    public PostgradStudent(String fn, String ln, String id, String em, String ph, String field) {
        super(fn, ln, id, em, ph); // Reusing Student constructor
        this.researchField = field;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Research Field: " + researchField);
    }
}