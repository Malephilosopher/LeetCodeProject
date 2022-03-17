package leetcode.Prison;

public class Guard extends Person{
    private int empId;

    public Guard(int empId, String name, String birth) {
        super(name, birth);
        this.empId = empId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "Guard{" +
                "empId='" + empId + '\'' +
                ", name='" + getName() + '\'' +
                ", birth='" + getBirth() + '\'' +
                '}';
    }
}
