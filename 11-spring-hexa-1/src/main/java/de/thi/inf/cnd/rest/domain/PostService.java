package de.thi.inf.cnd.rest.domain;

import de.thi.inf.cnd.rest.domain.model.Post;

public interface PostService {
    Post createPost(String titel, String content);
}
