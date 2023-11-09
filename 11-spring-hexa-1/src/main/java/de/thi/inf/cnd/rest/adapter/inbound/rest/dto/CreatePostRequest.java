package de.thi.inf.cnd.rest.adapter.inbound.rest.dto;

import lombok.Data;

@Data
public class CreatePostRequest {
    private String title;
    private String content;
}
