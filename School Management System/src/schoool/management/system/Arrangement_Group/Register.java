package schoool.management.system.Arrangement_Group;

public class Register {
    /*
    CREATE TABLE Check_student_enrollment(
	enrollment_ID		   INT					PRIMARY KEY ,
	student_ID			   INT					REFERENCES Student (student_ID),
	subject_name	       VARCHAR(255),
	subject_ID		       VARCHAR(255)			REFERENCES Subject (subject_ID),
	UNIQUE (student_ID, subject_name)
)
     */
    private int enrollment_ID;
    private int student_ID;
    private String subject_name;
    private String subject_ID;

    public Register(int enrollment_ID, int student_ID, String subject_name, String subject_ID) {
        this.enrollment_ID = enrollment_ID;
        this.student_ID = student_ID;
        this.subject_name = subject_name;
        this.subject_ID = subject_ID;
    }

    public int getEnrollment_ID() {
        return enrollment_ID;
    }

    public int getStudent_ID() {
        return student_ID;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public String getSubject_ID() {
        return subject_ID;
    }
}
