package schoool.management.system.Manipulate_Group;

public class Subject {
    private String subject_ID;
    private String subject_name;
    private int subject_group;
    public Subject(String subject_ID, String subject_name, int subject_group){
        this.subject_ID=subject_ID;
        this.subject_name=subject_name;
        this.subject_group=subject_group;
    }

    public String getSubject_ID() {
        return subject_ID;
    }

    public void setSubject_ID(String subject_ID) {
        this.subject_ID = subject_ID;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getSubject_group() {
        return subject_group;
    }

    public void setSubject_group(int subject_group) {
        this.subject_group = subject_group;
    }
}
