package com.paulopraddo.projetotaskmanagement.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Setter
public record TarefaData(@JsonAlias("Titulo") String titulo, @JsonAlias("Descricao") String descricao, @JsonAlias("Data e Hora") LocalDateTime dataEHora) {
}
