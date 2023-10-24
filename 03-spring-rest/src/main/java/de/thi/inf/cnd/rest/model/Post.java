package de.thi.inf.cnd.rest.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@Entity
public class Post {
    @Setter(AccessLevel.NONE)
    @Id
    private UUID id;
    private String title;
    private String content;
    private LocalDateTime date;
    private String userRef;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Post() {
        this.id = UUID.randomUUID();
        this.comments = new ArrayList<>();
    }
}
