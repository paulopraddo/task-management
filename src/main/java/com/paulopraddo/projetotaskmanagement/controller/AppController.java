package com.paulopraddo.projetotaskmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping
    public String paginaInicial() {
        return "Projeto Task Management";
    }
}
