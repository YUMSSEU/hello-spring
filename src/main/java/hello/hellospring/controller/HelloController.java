package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// MVC : Model, View, Controller

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

//    웹브라우저 localhost:8080/hello-mvc -> 내장 톰캣 서버 -> helloController
//    -> return: hello-template, model(name=spring) -> viewResolver(templates/hello-template.html) - > 웹 브라우저
    @GetMapping("hello-mvc")
    public  String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }}
