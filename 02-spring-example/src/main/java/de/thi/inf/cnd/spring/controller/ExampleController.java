package de.thi.inf.cnd.spring.controller;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/example")
public class ExampleController {
    @GetMapping("/hello/{msg}")
    public String helloWorld(@PathVariable String msg) {
        return "Hello, " + msg;
    }

    @PostMapping("/hello")
    public String someMethod(@RequestBody Example example) {
        return "Hello, " + example.getMsg();
    }
}
