package com.example.demotpm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam(defaultValue = "Weekend") String name) {
        return helloService.getMessage(name);
    }
}
