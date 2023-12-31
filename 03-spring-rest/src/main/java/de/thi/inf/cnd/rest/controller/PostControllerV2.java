package de.thi.inf.cnd.rest.controller;

import de.thi.inf.cnd.rest.model.Post;
import de.thi.inf.cnd.rest.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v2/posts")
public class PostControllerV2 {
    @Autowired
    private PostRepository repository;

    @GetMapping
    public Iterable<Post> getAllPosts() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Post getOnePost(@PathVariable UUID id) {
        Optional<Post> post = repository.findById(id);
        if(post.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return post.get();
    }

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        Post entry = new Post();
        entry.setDate(post.getDate());
        entry.setTitle(post.getTitle());
        entry.setContent(post.getContent());
        Post newEntry = repository.save(entry);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newEntry.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable UUID id, @RequestBody Post post) {
        Optional<Post> oldPost = repository.findById(id);
        if(oldPost.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return repository.save(oldPost.map(p -> {
            p.setContent(post.getContent());
            p.setTitle(post.getTitle());
            return p;
        }).get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable UUID id) {
        repository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
