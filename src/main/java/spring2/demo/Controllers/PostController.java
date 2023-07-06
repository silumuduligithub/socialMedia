package spring2.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring2.demo.Models.Notification;
import spring2.demo.Models.Post;
import spring2.demo.Service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/addPost")
    public ResponseEntity<String> addPost(@RequestBody Post post, @RequestParam int userId){
        try{
            postService.addPost(post, userId);
            return new ResponseEntity<>("post added under the user", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/giveLike")
    public ResponseEntity<Notification> likeAPost(@RequestParam int postId){
       Notification notification =  postService.likeAPost(postId);

        return new ResponseEntity<>(notification, HttpStatus.OK);
    }
}
