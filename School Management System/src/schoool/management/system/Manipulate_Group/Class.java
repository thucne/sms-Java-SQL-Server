package schoool.management.system.Manipulate_Group;

public class Class {
    private String class_ID;
    private String class_section;

    public Class(String class_ID, String class_section) {
        this.class_ID = class_ID;
        this.class_section = class_section;
    }

    public String getClass_ID() {
        return class_ID;
    }

    public String getClass_section() {
        return class_section;
    }
}
