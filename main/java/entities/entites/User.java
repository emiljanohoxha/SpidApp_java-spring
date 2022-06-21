package entities.entites;
import java.util.*;

public class User extends Base{

    private String name;
    private String surname;
    private String username;

    public User(long id, Date createdAt,String createdBy, String name, String surname, String username) {
        super(id, createdAt,createdBy);
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getName() {

        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {

        return username;
    }

}
