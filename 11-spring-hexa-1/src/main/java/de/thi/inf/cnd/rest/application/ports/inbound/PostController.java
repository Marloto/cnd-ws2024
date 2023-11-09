package de.thi.inf.cnd.rest.application.ports.inbound;

import de.thi.inf.cnd.rest.domain.model.Post;

public interface PostController {
    public Post createPost(String title, String content);
}
