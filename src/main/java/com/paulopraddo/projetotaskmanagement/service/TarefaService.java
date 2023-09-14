package com.paulopraddo.projetotaskmanagement.service;

import com.paulopraddo.projetotaskmanagement.entity.Tarefa;
import com.paulopraddo.projetotaskmanagement.model.Conclusao;
import com.paulopraddo.projetotaskmanagement.model.TarefaDTO;
import com.paulopraddo.projetotaskmanagement.repository.TarefaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public void salvarNovaTarefa(TarefaDTO tarefaDTO) {

        Tarefa tarefa = new Tarefa();

        tarefa.setTitulo(tarefaDTO.titulo());
        tarefa.setDescricao(tarefaDTO.descricao());
        tarefa.setDataEHora(tarefaDTO.dataEHora());
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

    public ResponseData exibirTarefaPeloId(Long idTarefa) {
        Tarefa tarefa = tarefaRepository.findById(idTarefa).orElse(null);
        ResponseData response = converter(tarefa);
        return response;
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

    public ResponseData converter(Tarefa tarefa) {
        TarefaData tarefaData = new TarefaData(tarefa.getTitulo(),tarefa.getDescricao(),tarefa.getDataEHora(),tarefa.getConclusao());
        ResponseData response = new ResponseData();
        response.setMessage("sucesso");
        response.setCodigoHttp("OK");
        response.setData(tarefaData);
        return response;
    }

}
