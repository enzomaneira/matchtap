package com.demo.matchtap.resources;

import com.demo.matchtap.entities.Reaction;
import com.demo.matchtap.services.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reactions")
public class ReactionResource {

    @Autowired
    private ReactionService reactionService;

    @GetMapping
    public ResponseEntity<List<Reaction>> findAll() {
        List<Reaction> reactions = reactionService.findAll();
        return ResponseEntity.ok().body(reactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reaction> findById(@PathVariable Long id) {
        Reaction reaction = reactionService.findById(id);
        return ResponseEntity.ok().body(reaction);
    }

    @PostMapping
    public ResponseEntity<Reaction> save(@RequestBody Reaction reaction) {
        Reaction savedReaction = reactionService.save(reaction);
        return ResponseEntity.ok().body(savedReaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reactionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
