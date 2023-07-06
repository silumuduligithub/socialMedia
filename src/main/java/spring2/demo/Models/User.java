package spring2.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;
@Table
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    private int age;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Post> postList = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade =  CascadeType.ALL)
    List<Notification> notificationList = new ArrayList<>();
}
