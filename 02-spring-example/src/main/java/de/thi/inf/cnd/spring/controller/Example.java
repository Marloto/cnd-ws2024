package de.thi.inf.cnd.spring.controller;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Example {
    @Setter(AccessLevel.NONE)
    private UUID id = UUID.randomUUID();
    private String msg;
}
