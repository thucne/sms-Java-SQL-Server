package schoool.management.system.Finance_Group;

public class Salary {
    private int staff_ID;
    private String staff_name;
    private double salary;
    private String payment_status;

    public Salary(int staff_ID, String staff_name, double salary, String payment_status) {
        this.staff_ID = staff_ID;
        this.staff_name = staff_name;
        this.salary = salary;
        this.payment_status = payment_status;
    }

    public int getStaff_ID() {
        return staff_ID;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPayment_status() {
        return payment_status;
    }
}
