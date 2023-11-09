package de.thi.inf.cnd.rest.adapter.inbound.rest.dto;

import de.thi.inf.cnd.rest.domain.model.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class PostResponse {
    private UUID id;
    private String title;
    private String content;
    private LocalDateTime date;
    private String userRef;

    public static PostResponse fromPost(Post post) {
        PostResponse response = new PostResponse();
        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setContent(post.getContent());
        response.setDate(post.getDate());
        response.setUserRef(post.getUserRef());
        return response;
    }
}
