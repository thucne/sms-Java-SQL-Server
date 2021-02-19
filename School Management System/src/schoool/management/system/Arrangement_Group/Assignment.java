package schoool.management.system.Arrangement_Group;

public class Assignment {
    private int assignment_ID;
    private int staff_ID;
    private String subject_ID;
    private String assignment_details;
    public Assignment(int assignment_ID, int staff_ID, String subject_ID, String assignment_details){
        this.assignment_ID = assignment_ID;
        this.staff_ID = staff_ID;
        this.subject_ID = subject_ID;
        this.assignment_details =assignment_details;
    }
    public int getAssignment_ID() {
        return assignment_ID;
    }
    public int getStaff_ID() {
        return staff_ID;
    }
    public String getSubject_ID(){
        return subject_ID;
    }
    public String getAssignment_Details(){
        return assignment_details;
    }
}
