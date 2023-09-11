package org.gerosd.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname, Model model) {

        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "index.html";
    }

    @ExceptionHandler

    @GetMapping("/calculator")
    public String calc(@RequestParam("a") double a, @RequestParam("b") double b, @RequestParam("condition") String condition, Model model) {
        double result = 0;
        switch (condition) {
            case "division" -> result = a / b;
            case "subtract" -> result = a - b;
            case "multiplication" -> result = a * b;
            case "addiction" -> result = a + b;
        }
        model.addAttribute("result", result);

        return "homework/calculator.html";
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello_world.html";
    }

}
