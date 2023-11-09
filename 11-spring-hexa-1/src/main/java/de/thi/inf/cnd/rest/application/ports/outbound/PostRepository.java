package de.thi.inf.cnd.rest.application.ports.outbound;

import de.thi.inf.cnd.rest.domain.model.Post;

public interface PostRepository {
    public void save(Post post);
}
