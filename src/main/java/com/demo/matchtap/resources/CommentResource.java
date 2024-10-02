package com.demo.matchtap.resources;

import com.demo.matchtap.entities.Comment;
import com.demo.matchtap.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentResource {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> findAll() {
        List<Comment> comments = commentService.findAll();
        return ResponseEntity.ok().body(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> findById(@PathVariable Long id) {
        Comment comment = commentService.findById(id);
        return ResponseEntity.ok().body(comment);
    }

    @PostMapping
    public ResponseEntity<Comment> save(@RequestBody Comment comment) {
        Comment savedComment = commentService.save(comment);
        return ResponseEntity.ok().body(savedComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
