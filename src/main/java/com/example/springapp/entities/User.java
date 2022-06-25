//package com.example.springapp.entities;
//
//
//import jakarta.persistence.*;
//import org.springframework.data.annotation.Id;
//
//import java.util.Date;
//
//
//@Entity
//@Table(name = "users")
//public class User extends Base {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String name;
//    private String surname;
//    private String username;
//
//    public User(){
//
//    }
//
//    public User(Long id, Date createdAt, String createdBy, Long id1, String name, String surname, String username) {
//        super(id, createdAt, createdBy);
//        this.id = id1;
//        this.name = name;
//        this.surname = surname;
//        this.username = username;
//    }
//
//
//    @jakarta.persistence.Id
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setId(Long id1) {
//        this.id = id1;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", username='" + username + '\'' +
//                '}';
//    }
//
//
//}

package com.example.springapp.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends Base{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String cardNo;
    private String email;
    private String password;


    public User updateWith(User newUser) {
        return newUser;
    }
}
