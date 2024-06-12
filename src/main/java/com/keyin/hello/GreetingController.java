package com.keyin.hello;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // need this to be able to access say http://localhost:8080/hello
@CrossOrigin
public class GreetingController {
    // bridges java code with http layer
    @Autowired
    // determines when to create an instance of the below instance
    private GreetingService greetingService;

//    @GetMapping("hello")
//    public Greeting greeting(@RequestParam(value = "name", required = false) String name) { // allows use of query in URL (?name=Evan)
//        return greetingService.generateGreeting(name);
//    }

    @GetMapping("search_greeting")
    public List<Greeting> searchGreeting(@RequestParam(value = "name", required = false) String name, String greeting) {
        return greetingService.findGreetingsByNameAndGreeting(name, greeting);
    }

    @GetMapping("greetings")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // can do it this way or can do the same as above @GetMapping("search_greeting") - two ways to do the same thing
    @GetMapping("greeting/{index}")
    public Greeting getGreeting(@PathVariable Integer index) {
        return greetingService.getGreeting(index);
    }

    @PostMapping("greeting")
    public Greeting createGreeting(@RequestBody Greeting newGreeting) {
        return greetingService.createGreeting(newGreeting);
    }

    @PutMapping("greeting/{index}")
    public Greeting updateGreeting(@PathVariable Integer index, @RequestBody Greeting updatedGreeting) {
        return greetingService.updateGreeting(index, updatedGreeting);
    }

    @DeleteMapping("greeting/{index}")
    public void deleteGreeting(@PathVariable Integer index) {
        greetingService.deleteGreeting(index);
    }

}
