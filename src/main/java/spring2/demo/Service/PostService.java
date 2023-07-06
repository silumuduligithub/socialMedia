package spring2.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring2.demo.Exceptions.UserNotFound;
import spring2.demo.Models.Notification;
import spring2.demo.Models.Post;
import spring2.demo.Models.User;
import spring2.demo.Repository.PostRepository;
import spring2.demo.Repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    public void addPost(Post post, int userId) throws UserNotFound{
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFound("user not present");
        }
        User user = userOptional.get();
        List<Post> postList = user.getPostList();
        postList.add(post);
        userRepository.save(user);
        postRepository.save(post);
    }

    public Notification likeAPost(int postId) {
        Post post = postRepository.findById(postId).get();
        int like = post.getLike();
        like++;
        post.setLike(like);
        postRepository.save(post);
        Notification notification = new Notification();
        notification.setTime(post.getTime());
        return notification;
    }
}
