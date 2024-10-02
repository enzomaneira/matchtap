package com.demo.matchtap.resources;

import com.demo.matchtap.entities.Post;
import com.demo.matchtap.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAll() {
        List<Post> posts = postService.findAll();
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody Post post) {
        Post savedPost = postService.save(post);
        return ResponseEntity.ok().body(savedPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
