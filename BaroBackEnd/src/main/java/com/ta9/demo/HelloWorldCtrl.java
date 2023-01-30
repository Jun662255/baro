package com.ta9.demo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api2")
public class HelloWorldCtrl {

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello!";
    }
}