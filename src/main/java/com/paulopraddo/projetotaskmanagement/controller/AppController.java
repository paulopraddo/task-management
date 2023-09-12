package com.paulopraddo.projetotaskmanagement.controller;

import com.paulopraddo.projetotaskmanagement.model.TarefaData;
import com.paulopraddo.projetotaskmanagement.service.TarefaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AppController {

    private final TarefaService tarefaService;

    @GetMapping
    public String paginaInicial() {
        return "Projeto Task Management";
    }

    @GetMapping("/teste")
    public String teste() {
        return tarefaService.exibirTodasAsTarefas();
    }

    @GetMapping("/exibeTarefaPeloId/id/{idTarefa}")
    public String exibeTarefaPeloId(@PathVariable Long idTarefa) {
        return tarefaService.exibirTarefaPeloId(idTarefa);
    }

    @GetMapping("/listarTarefas")
    public String exibirTodasAsTarefas() {
        return tarefaService.exibirTodasAsTarefas();
    }

    @PostMapping("/salvarTarefa")
    public String salvarNovaTarefa(@RequestBody TarefaData tarefaData) {
        tarefaService.salvarNovaTarefa(tarefaData);
        return "OK";
    }
}
