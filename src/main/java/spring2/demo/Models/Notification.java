package spring2.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalTime;
@Entity
@Table
@Data
public class Notification {
    private LocalTime time;
    @ManyToOne
    @JoinColumn
    User user;

}
