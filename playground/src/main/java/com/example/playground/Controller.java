package com.example.playground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.playground.PlaygroundApplication.ENDPOINT;
import static com.example.playground.PlaygroundApplication.counter;

@RestController
public class Controller {


    @GetMapping("/counter")
    public String counter() {
        counter++;
        return "You have called the " + ENDPOINT + " endpoint for " + counter + " time(s).";
    }
}
