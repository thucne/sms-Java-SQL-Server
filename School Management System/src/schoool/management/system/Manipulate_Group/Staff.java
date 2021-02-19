package schoool.management.system.Manipulate_Group;

public class Staff {
    private int staff_id;
    private String  staff_name;
    public Staff(int staff_id, String staff_name) {
        this.staff_id = staff_id;
        this.staff_name = staff_name;
    }
    public int getStaffId(){
        return staff_id;
    }
    public String getStaffName(){
        return staff_name;
    }
}
