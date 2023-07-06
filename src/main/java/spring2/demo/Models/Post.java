package spring2.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
@Table
@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    private LocalTime time;
    private int like;
    @ManyToOne
    @JoinColumn
    private User user;
}
