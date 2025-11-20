import java.util.HashSet;
import java.util.Set;

public class User {
    private String name;
    private String lastName;
    private String city;
    private int age;
    private Set<String> hobby;

    User(String name, String lastName, String city, int age) {
        this.name = name;
        this.lastName = lastName;
        this.city = city;
        this.age = age;
        this.hobby = new HashSet<String>();
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public Set<String> getHobby() {
        return hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}
