package com.paulopraddo.projetotaskmanagement.service;

import com.paulopraddo.projetotaskmanagement.entity.Tarefa;
import com.paulopraddo.projetotaskmanagement.model.Conclusao;
import com.paulopraddo.projetotaskmanagement.model.TarefaData;
import com.paulopraddo.projetotaskmanagement.repository.TarefaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public void salvarNovaTarefa(TarefaData tarefaData) {

        Tarefa tarefa = new Tarefa();

        tarefa.setTitulo(tarefaData.titulo());
        tarefa.setDescricao(tarefaData.descricao());
        tarefa.setDataEHora(tarefaData.dataEHora());
        tarefa.setConclusao(Conclusao.INCONCLUIDA);

        System.out.println(tarefaData.dataEHora());
        System.out.println(tarefaData.titulo());

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

    public String atualizarIdTarefa(Long idTarefa, Long newIdTarefa) {
        tarefaRepository.atualizarId(idTarefa,newIdTarefa);
        return "ID da tarefa atualizado";
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

    public String deletarTodasAsTarefas() {
        tarefaRepository.deleteAll();
        return "Todas as tarefas foram deletadas";
    }

    public String deletarTarefaPeloId(Long idTarefa) {
        tarefaRepository.delete(tarefaRepository.findById(idTarefa).orElse(null));
        return "Tarefa Deletada";
    }

}
