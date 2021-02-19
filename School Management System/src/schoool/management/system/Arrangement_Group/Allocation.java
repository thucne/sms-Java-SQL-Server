package schoool.management.system.Arrangement_Group;

public class Allocation {
    /*
    CREATE TABLE Class_allocation (
	enrollment_ID		   INT					REFERENCES Check_student_enrollment(enrollment_ID),
    subject_ID			   VARCHAR(255)			REFERENCES Subject (subject_ID),
    staff_ID			   INT					REFERENCES Staff (staff_ID),
    student_ID		       INT					REFERENCES Student (student_ID),
	class_ID			   VARCHAR(255)			REFERENCES Class (class_ID),
	room			       VARCHAR(255)			NOT NULL,
);

     */
    private int enrollment_ID;
    private String subject_ID;
    private int staff_ID;
    private int student_ID;
    private String class_ID;
    private String room;

    public Allocation(int enrollment_ID, String subject_ID, int staff_ID, int student_ID, String class_ID, String room) {
        this.enrollment_ID = enrollment_ID;
        this.subject_ID = subject_ID;
        this.staff_ID = staff_ID;
        this.student_ID = student_ID;
        this.class_ID = class_ID;
        this.room = room;
    }

    public int getEnrollment_ID() {
        return enrollment_ID;
    }

    public String getSubject_ID() {
        return subject_ID;
    }

    public int getStaff_ID() {
        return staff_ID;
    }

    public int getStudent_ID() {
        return student_ID;
    }

    public String getClass_ID() {
        return class_ID;
    }

    public String getRoom() {
        return room;
    }
}
