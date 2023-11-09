package de.thi.inf.cnd.rest.adapter.outbound.jpa.post;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface JpaPostCrudRepository extends CrudRepository<PostEntity, UUID> {
}
