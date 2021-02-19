package schoool.management.system.Manipulate_Group;

public class Student {
    private int studentID;
    private String studentName;
    private String gender;
    private String classID;
    private String level;

    public Student(int studentID, String studentName, String gender, String classID, String level){
        this.studentID = studentID;
        this.studentName = studentName;
        this.gender = gender;
        this.classID = classID;
        this.level = level;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getGender() {
        return gender;
    }

    public String getClassID() {
        return classID;
    }

    public String getLevel() {
        return level;
    }
}
