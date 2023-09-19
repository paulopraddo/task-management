package com.paulopraddo.projetotaskmanagement.service;

import com.paulopraddo.projetotaskmanagement.model.Tarefa;
import com.paulopraddo.projetotaskmanagement.model.Conclusao;
import com.paulopraddo.projetotaskmanagement.model.TarefaDTO;
import com.paulopraddo.projetotaskmanagement.repository.TarefaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

@Service
@AllArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public ResponseData salvarNovaTarefa(TarefaDTO tarefaDTO) {
        TarefaDTOValidacao.validarTarefaDTO(tarefaDTO);
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(tarefaDTO.titulo());
        tarefa.setDescricao(tarefaDTO.descricao());
        tarefa.setDataEHora(LocalDateTime.parse(tarefaDTO.dataEHora()));
        tarefa.setConclusao(Conclusao.INCONCLUIDA);

        tarefaRepository.save(tarefa);
        return converter(tarefa);
    }

    public ArrayList<ResponseData> exibirTodasAsTarefas() {
        ArrayList<ResponseData> responses = new ArrayList<ResponseData>();

        ArrayList<Tarefa> listaDeTarefas = (ArrayList<Tarefa>) tarefaRepository.findAll();
        for (Tarefa tarefa : listaDeTarefas) {
             responses.add(converter(tarefa));
        }
        if (responses.isEmpty()) {
            throw new NenhumRegistroEncotrado("A lista de tarefas está vazia. Não há tarefas para exibir.");
        }

        return responses;
    }

    public ResponseData exibirTarefaPeloId(Long idTarefa) {
        verificaSeExisteRegistro(idTarefa);
        Tarefa tarefa = tarefaRepository.findById(idTarefa).orElse(null);
        ResponseData response = converter(tarefa);
        return response;
    }

    public ResponseData atualizarIdTarefa(Long idTarefa, Long newIdTarefa) {
        verificaSeExisteRegistro(idTarefa);
        tarefaRepository.atualizarId(idTarefa,newIdTarefa);
        return converter(tarefaRepository.findById(newIdTarefa).orElse(null));
    }

    public ResponseData atualizarTituloTarefa(Long idTarefa, String titulo) {
        verificaSeExisteRegistro(idTarefa);
        tarefaRepository.atualizarTitulo(idTarefa,titulo);
        return converter(tarefaRepository.findById(idTarefa).orElse(null));
    }

    public ResponseData atualizarDescricaoTarefa(Long idTarefa, String descricao) {
        verificaSeExisteRegistro(idTarefa);
        tarefaRepository.atualizarDescricao(idTarefa,descricao);
        return converter(tarefaRepository.findById(idTarefa).orElse(null));
    }

    public ResponseData marcarTarefaComoConcluida(Long idTarefa) {
        verificaSeExisteRegistro(idTarefa);
        tarefaRepository.marcarComoConcluida(idTarefa);
        return converter(tarefaRepository.findById(idTarefa).orElse(null));
    }

    public String deletarTodasAsTarefas() {
        tarefaRepository.deleteAll();
        return "Todas as tarefas foram deletadas";
    }

    public String deletarTarefaPeloId(Long idTarefa) {
        verificaSeExisteRegistro(idTarefa);
        tarefaRepository.delete(tarefaRepository.findById(idTarefa).orElse(null));
        return "Tarefa Deletada";
    }

    public ResponseData converter(Tarefa tarefa) {
        TarefaData tarefaData = new TarefaData(tarefa.getTitulo(),tarefa.getDescricao(),tarefa.getDataEHora(),tarefa.getConclusao());
        ResponseData response = new ResponseData();
        response.setMessage("sucesso");
        response.setHttpStatus(HttpStatus.OK);
        response.setData(tarefaData);
        return response;
    }

    public class TarefaDTOValidacao {
        public static void validarTarefaDTO(TarefaDTO tarefaDTO) throws IllegalArgumentException {
            String dataEHoraStr = tarefaDTO.dataEHora();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

            try {
                LocalDateTime dataEHora = LocalDateTime.parse(dataEHoraStr, formatter);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("A data e hora estão no formato incorreto: " + dataEHoraStr);
            }
        }
    }

    public void verificaSeExisteRegistro(Long idTarefa) {
        Tarefa tarefa = tarefaRepository.findById(idTarefa).orElse(null);
        if(tarefa == null) {
            throw new NenhumRegistroEncotrado("Nenhum registro com esse ID foi encontrado");
        }
    }

    public class NenhumRegistroEncotrado extends RuntimeException {
        public NenhumRegistroEncotrado(String mensagem) {
            super(mensagem);
        }
    }
}
