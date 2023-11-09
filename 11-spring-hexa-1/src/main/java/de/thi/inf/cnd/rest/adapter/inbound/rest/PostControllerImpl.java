package de.thi.inf.cnd.rest.adapter.inbound.rest;

import de.thi.inf.cnd.rest.application.ports.inbound.PostController;
import de.thi.inf.cnd.rest.domain.model.Post;
import de.thi.inf.cnd.rest.domain.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostControllerImpl implements PostController {

    @Autowired
    private PostService domainService;

    @Override
    public Post createPost(String title, String content) {
        return domainService.createPost(title, content);
    }
}
