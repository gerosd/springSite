package org.gerosd.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        return "/WEB-INF/views/index.html";
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "/WEB-INF/views/hello_world.html";
    }

}
