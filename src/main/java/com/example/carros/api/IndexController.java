package com.example.carros.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String hello() {
        return "hello";
    }

    /**
     * Aula 17: Get @RequestParam
     */
//    @GetMapping("/login")
//    public String login(@RequestParam("login") String login, @RequestParam("senha") String senha) {
//        return "Login: " + login + "\nSenha: " + senha;
//    }

    /**
     * Aula 18: @PathVariable
     */
//    @GetMapping("/login/{login}/senha/{senha}")
//    public String login(@PathVariable("login") String login, @PathVariable("senha") String senha) {
//        return "Login: " + login + "\nSenha: " + senha;
//    }

    /**
     * Aula 19: POST - @RequestParam
     */
//    @PostMapping
//    public String login(@RequestParam("login") String login, @RequestParam("senha") String senha) {
//        return "Login: " + login + "\nSenha: " + senha;
//    }
}
