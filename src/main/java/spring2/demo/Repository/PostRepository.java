package spring2.demo.Repository;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.data.jpa.repository.JpaRepository;
import spring2.demo.Models.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
