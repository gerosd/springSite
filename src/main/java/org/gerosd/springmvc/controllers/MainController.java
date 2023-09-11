package org.gerosd.springmvc.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello" + name + " " + surname);

        return "index.html";
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello_world.html";
    }

}
