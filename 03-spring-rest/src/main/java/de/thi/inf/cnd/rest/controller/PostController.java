package de.thi.inf.cnd.rest.controller;

import de.thi.inf.cnd.rest.model.Post;
import de.thi.inf.cnd.rest.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostRepository repository;

    @GetMapping
    public Iterable<Post> listAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Post findOne(@PathVariable UUID id) {
        Optional<Post> result = repository.findById(id);
        if(result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return result.get();
    }

    @PostMapping
    public void addOne(@RequestBody Post post) {
        repository.save(post);
        // 200 od 204
        // neu erzeugte ID mit kommunizieren
        // -> Location-Header
    }
}