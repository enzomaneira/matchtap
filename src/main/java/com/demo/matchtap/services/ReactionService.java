package com.demo.matchtap.services;

import com.demo.matchtap.entities.Reaction;
import com.demo.matchtap.repositories.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactionService {

    @Autowired
    private ReactionRepository reactionRepository;

    public List<Reaction> findAll() {
        return reactionRepository.findAll();
    }

    public Reaction findById(Long id) {
        return reactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Reaction not found"));
    }

    public Reaction save(Reaction reaction) {
        return reactionRepository.save(reaction);
    }

    public void delete(Long id) {
        reactionRepository.deleteById(id);
    }
}
