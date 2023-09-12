package com.paulopraddo.projetotaskmanagement.service;

import com.paulopraddo.projetotaskmanagement.entity.Tarefa;
import com.paulopraddo.projetotaskmanagement.model.TarefaData;
import com.paulopraddo.projetotaskmanagement.repository.TarefaRepository;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public void salvarNovaTarefa(TarefaData tarefaData) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(tarefaData.getTitulo());
        tarefa.setDescricao(tarefaData.getDescricao());

        tarefaRepository.save(tarefa);
    }

    public String listarTarefas() {
        return "Tarefas";
    }

}
