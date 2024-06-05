package com.keyin.hello;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // need this to be able to access say http://localhost:8080/hello
@CrossOrigin
public class GreetingController {
    @GetMapping("hello")
    public Greeting greeting(@RequestParam("name") String name) { // allows use of query in URL (?name=Evan)
        Greeting greeting = new Greeting();
        greeting.setGreeting("Hellooo");
        greeting.setName(name);

        return greeting;
    }
}
