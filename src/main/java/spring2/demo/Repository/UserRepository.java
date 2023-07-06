package spring2.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring2.demo.Models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
