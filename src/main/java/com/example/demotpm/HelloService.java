package com.example.demotpm;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String getMessage(String name) {

        return "Hello " + name + "!";
    }
}
