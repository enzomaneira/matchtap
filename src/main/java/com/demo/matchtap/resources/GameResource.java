package com.demo.matchtap.resources;

import com.demo.matchtap.entities.Game;
import com.demo.matchtap.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameResource {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> findAll() {
        List<Game> games = gameService.findAll();
        return ResponseEntity.ok().body(games);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> findById(@PathVariable Long id) {
        Game game = gameService.findById(id);
        return ResponseEntity.ok().body(game);
    }

    @PostMapping
    public ResponseEntity<Game> save(@RequestBody Game game) {
        Game savedGame = gameService.save(game);
        return ResponseEntity.ok().body(savedGame);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        gameService.delete(id);
        return ResponseEntity.noContent().build();
    }
}



