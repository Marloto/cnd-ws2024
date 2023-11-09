package de.thi.inf.cnd.rest.adapter.outbound.mqtt.dto;

import de.thi.inf.cnd.rest.domain.model.Post;
import lombok.Data;

import java.util.UUID;

@Data
public class NewPostEvent {
    private UUID id;
    private String title;

    public static NewPostEvent fromPost(Post post) {
        NewPostEvent event = new NewPostEvent();
        event.setId(post.getId());
        event.setTitle(post.getTitle());
        return event;
    }
}
