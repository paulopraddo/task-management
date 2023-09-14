package com.paulopraddo.projetotaskmanagement.controller;

import com.paulopraddo.projetotaskmanagement.model.TarefaDTO;
import com.paulopraddo.projetotaskmanagement.service.ResponseData;
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


    @GetMapping("/exibeTarefaPeloId/id/{idTarefa}")
    public ResponseData exibeTarefaPeloId(@PathVariable Long idTarefa) {
        return tarefaService.exibirTarefaPeloId(idTarefa);
    }

    @GetMapping("/listarTarefas")
    public String exibirTodasAsTarefas() {
        return tarefaService.exibirTodasAsTarefas();
    }

    @PostMapping("/salvarTarefa")
    public String salvarNovaTarefa(@RequestBody TarefaDTO tarefaDTO) {
        tarefaService.salvarNovaTarefa(tarefaDTO);
        return "OK";
    }

    @PutMapping("/atualizarId/id/{idTarefa}/newId/{newIdTarefa}")
    public String atualizarIdTarefa(@PathVariable Long idTarefa, @PathVariable Long newIdTarefa) {
        return tarefaService.atualizarIdTarefa(idTarefa,newIdTarefa);
    }


    @PutMapping("/atualizarTitulo/id/{idTarefa}/titulo/{newTitulo}")
    public String atualizarTituloTarefa(@PathVariable Long idTarefa, @PathVariable String newTitulo) {
        return tarefaService.atualizarTituloTarefa(idTarefa,newTitulo);
    }

    @PutMapping("/atualizarDescricao/id/{idTarefa}/descricao/{newDescricao}")
    public String atualizarDescricaoTarefa(@PathVariable Long idTarefa, @PathVariable String newDescricao) {
        return tarefaService.atualizarDescricaoTarefa(idTarefa,newDescricao);
    }

    @PutMapping("/tarefaConcluida/id/{idTarefa}")
    public String marcarTarefaComoConcluida(@PathVariable Long idTarefa) {
        return tarefaService.marcarTarefaComoConcluida(idTarefa);
    }

    @DeleteMapping("/deletarTarefas")
    public String deletarTodasAsTarefas() {
        return tarefaService.deletarTodasAsTarefas();
    }

    @DeleteMapping("/deletarTarefa/id/{idTarefa}")
    public String deletarTarefaPeloId(@PathVariable Long idTarefa) {
        return tarefaService.deletarTarefaPeloId(idTarefa);
    }
}
