package com.paulopraddo.projetotaskmanagement.service;

import com.paulopraddo.projetotaskmanagement.entity.Tarefa;
import com.paulopraddo.projetotaskmanagement.model.Conclusao;
import com.paulopraddo.projetotaskmanagement.model.TarefaData;
import com.paulopraddo.projetotaskmanagement.repository.TarefaRepository;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public void salvarNovaTarefa(TarefaData tarefaData) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(tarefaData.getTitulo());
        tarefa.setDescricao(tarefaData.getDescricao());
        tarefa.setConclusao(Conclusao.INCONCLUIDA);

        tarefaRepository.save(tarefa);
    }

    public String exibirTodasAsTarefas() {
        String resposta = "Tarefas: ";
        ArrayList<Tarefa> listaDeTarefas = (ArrayList<Tarefa>) tarefaRepository.findAll();
        for (Tarefa tarefa : listaDeTarefas) {
            resposta += exibirTarefa(tarefa);
        }
        return resposta;
    }

    public String exibirTarefaPeloId(Long idTarefa) {
        Tarefa tarefa = tarefaRepository.findById(idTarefa).orElse(null);
        return exibirTarefa(tarefa);
    }

    public String exibirTarefa(Tarefa tarefa) {
        return "/ Titulo: " + tarefa.getTitulo() +
                ", Descrição: " + tarefa.getDescricao() + " /";
    }


    public String atualizarTituloTarefa(Long idTarefa, String titulo) {
        tarefaRepository.atualizarTitulo(idTarefa,titulo);
        return "Tarefa atualizada - " + exibirTarefaPeloId(idTarefa);
    }

    public String atualizarDescricaoTarefa(Long idTarefa, String descricao) {
        tarefaRepository.atualizarDescricao(idTarefa,descricao);
        return "Tarefa atualizada - " + exibirTarefaPeloId(idTarefa);
    }

    public String marcarTarefaComoConcluida(Long idTarefa) {
        tarefaRepository.marcarComoConcluida(idTarefa);
        return "Tarefa Concluida";
    }

}
