package leetcode.Prison;

public class Person {
    private String name;
    private String birth;

    public Person(String name, String birth) {
        this.name = name;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Person a = new Person("aisibi", "20200102");
        System.out.println(a);
    }
}
