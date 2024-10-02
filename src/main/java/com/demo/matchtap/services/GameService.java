package com.demo.matchtap.services;

import com.demo.matchtap.entities.Game;
import com.demo.matchtap.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Game findById(Long id) {
        return gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Game not found"));
    }

    public Game save(Game game) {
        return gameRepository.save(game);
    }

    public void delete(Long id) {
        gameRepository.deleteById(id);
    }
}
