package leetcode.Prison;

public class Prisoner extends Person{
    private int prisId;

    public Prisoner(int prisId, String name, String birth) {
        super(name, birth);
        this.prisId = prisId;
    }

    public int getPrisId() {
        return prisId;
    }

    public void setPrisId(int prisId) {
        this.prisId = prisId;
    }

    @Override
    public String toString() {
        return "Prisoner{" +
                "prisId='" + prisId + '\'' +
                ", name='" + getName() + '\'' +
                ", birth='" + getBirth() + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Person p = new Prisoner(1, "二蛋", "2020-03-04");
        System.out.println(p);
    }
}
