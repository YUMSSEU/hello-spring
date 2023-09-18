package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name; // "hello spring"
    }


    @GetMapping("hello-api")
    @ResponseBody
//  json 방식
//  웹브라우저 -> localhost:8080/hello-api -> 내장 톰캣 서버 -> helloController
//  -> @ResponseBody(return: hello(name:spring) -> HttpMessageConverter(jsonConverter/StringConverter)
//  -> {name:spring} -> 웹브라우저
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
