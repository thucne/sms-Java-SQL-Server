package schoool.management.system.Finance_Group;

public class Fee {
    private int fee_ID;
    private int student_ID;
    private double fee;
    private String payment_status;
    private String day_of_payment;

    public Fee(int fee_ID, int student_ID, double fee, String payment_status, String day_of_payment) {
        this.fee_ID = fee_ID;
        this.student_ID = student_ID;
        this.fee = fee;
        this.payment_status = payment_status;
        this.day_of_payment = day_of_payment;
    }

    public int getFee_ID() {
        return fee_ID;
    }

    public int getStudent_ID() {
        return student_ID;
    }

    public double getFee() {
        return fee;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public String getDay_of_payment() {
        return day_of_payment;
    }
}
