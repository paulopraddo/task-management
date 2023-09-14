package com.paulopraddo.projetotaskmanagement.service;

import com.paulopraddo.projetotaskmanagement.model.Conclusao;

import java.time.LocalDateTime;

public record TarefaData(String titulo, String descricao, LocalDateTime dataEHora, Conclusao conclusao) {
}
