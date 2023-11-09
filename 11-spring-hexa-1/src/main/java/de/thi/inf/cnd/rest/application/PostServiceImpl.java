package de.thi.inf.cnd.rest.application;

import de.thi.inf.cnd.rest.application.ports.outbound.PostRepository;
import de.thi.inf.cnd.rest.application.ports.outbound.PostEvents;
import de.thi.inf.cnd.rest.domain.model.Post;
import de.thi.inf.cnd.rest.domain.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository repository;

    @Autowired
    private PostEvents events;

    @Override
    public Post createPost(String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        repository.save(post);
        events.publishNewPost(post);
        return post;
    }
}
