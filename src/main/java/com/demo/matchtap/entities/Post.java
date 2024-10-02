package com.demo.matchtap.entities;

import jakarta.persistence.*;

import javax.xml.stream.events.Comment;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_post")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "post")
    private Set<Reaction> reactions = new HashSet<>();

    public Post() {
    }

    public Post(Long id, String content, User user, Game game) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.game = game;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Set<Reaction> getReactions() {
        return reactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return Objects.equals(getId(), post.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
