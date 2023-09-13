package com.paulopraddo.projetotaskmanagement.model;

import java.time.LocalDateTime;

public record TarefaData(String titulo, String descricao,LocalDateTime dataEHora) {
}
