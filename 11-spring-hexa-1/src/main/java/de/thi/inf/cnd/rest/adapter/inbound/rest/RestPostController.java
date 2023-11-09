package de.thi.inf.cnd.rest.adapter.inbound.rest;

import de.thi.inf.cnd.rest.adapter.inbound.rest.dto.CreatePostRequest;
import de.thi.inf.cnd.rest.adapter.inbound.rest.dto.PostResponse;
import de.thi.inf.cnd.rest.application.ports.inbound.PostController;
import de.thi.inf.cnd.rest.domain.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class RestPostController {
    @Autowired
    private PostController service;

    @PostMapping
    public PostResponse doCreatePost(@RequestBody CreatePostRequest request) {
        Post post = service.createPost(request.getTitle(), request.getContent());
        return PostResponse.fromPost(post);
    }
}
