package com.paulopraddo.projetotaskmanagement.service;

import com.paulopraddo.projetotaskmanagement.repository.TarefaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    private TarefaRepository tarefaRepository;

    public String listarTarefas() {
        return "Tarefas";
    }
}
