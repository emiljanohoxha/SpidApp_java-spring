package com.example.springapp.entities;//package com.example.springapp.entities;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
//
//import javax.persistence.*;
//import java.lang.reflect.Type;
//import java.util.Date;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name="spids")
//public class Spid extends Base {
//
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.AUTO)
////    private Long id;
//
//    @OneToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "id")
//    private User user_id;
//
//    @Enumerated(EnumType.STRING)
//    private StatusEnum status;
//
////    @Enumerated(EnumType.STRING)
////    private TypeEnum type;
//    private String description;
//
//}



import com.example.springapp.entities.Base;
import com.example.springapp.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="spid")
public class Spid extends Base {
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User userId;
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    @Enumerated(EnumType.STRING)
    private TypeEnum type;
}