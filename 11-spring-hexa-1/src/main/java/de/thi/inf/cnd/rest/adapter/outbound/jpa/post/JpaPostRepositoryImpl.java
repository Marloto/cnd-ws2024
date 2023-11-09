package de.thi.inf.cnd.rest.adapter.outbound.jpa.post;

import de.thi.inf.cnd.rest.application.ports.outbound.PostRepository;
import de.thi.inf.cnd.rest.domain.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaPostRepositoryImpl implements PostRepository {

    @Autowired
    private JpaPostCrudRepository repo;

    @Override
    public void save(Post post) {
        repo.save(PostEntity.fromPost(post));
    }
}
