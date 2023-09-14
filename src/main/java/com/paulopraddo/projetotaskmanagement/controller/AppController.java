package com.paulopraddo.projetotaskmanagement.controller;

import com.paulopraddo.projetotaskmanagement.model.TarefaDTO;
import com.paulopraddo.projetotaskmanagement.service.ResponseData;
import com.paulopraddo.projetotaskmanagement.service.TarefaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
    public ArrayList<ResponseData> exibirTodasAsTarefas() {
        return tarefaService.exibirTodasAsTarefas();
    }

    @PostMapping("/salvarTarefa")
    public ResponseData salvarNovaTarefa(@RequestBody TarefaDTO tarefaDTO) {
        return tarefaService.salvarNovaTarefa(tarefaDTO);
    }

    @PutMapping("/atualizarId/id/{idTarefa}/newId/{newIdTarefa}")
    public ResponseData atualizarIdTarefa(@PathVariable Long idTarefa, @PathVariable Long newIdTarefa) {
        return tarefaService.atualizarIdTarefa(idTarefa,newIdTarefa);
    }


    @PutMapping("/atualizarTitulo/id/{idTarefa}/titulo/{newTitulo}")
    public ResponseData atualizarTituloTarefa(@PathVariable Long idTarefa, @PathVariable String newTitulo) {
        return tarefaService.atualizarTituloTarefa(idTarefa,newTitulo);
    }

    @PutMapping("/atualizarDescricao/id/{idTarefa}/descricao/{newDescricao}")
    public ResponseData atualizarDescricaoTarefa(@PathVariable Long idTarefa, @PathVariable String newDescricao) {
        return tarefaService.atualizarDescricaoTarefa(idTarefa,newDescricao);
    }

    @PutMapping("/tarefaConcluida/id/{idTarefa}")
    public ResponseData marcarTarefaComoConcluida(@PathVariable Long idTarefa) {
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
