package spring2.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring2.demo.Models.Post;
import spring2.demo.Models.User;
import spring2.demo.Repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void addUser(User user) {
        userRepository.save(user);
    }

    public User findUserWithMostLike() {
        List<User> userList = userRepository.findAll();
        int like = 0;
        User user1 = null;
        for(User user : userList){
            List<Post> postList = user.getPostList();
            for(Post post : postList){
                if(post.getLike() > like){
                    like = post.getLike();
                    user1 = post.getUser();
                }
            }
        }
        return user1;
    }
}
