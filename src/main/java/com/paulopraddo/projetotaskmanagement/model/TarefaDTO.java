package com.paulopraddo.projetotaskmanagement.model;

import java.time.LocalDateTime;

public record TarefaDTO(String titulo, String descricao, LocalDateTime dataEHora) {
}
