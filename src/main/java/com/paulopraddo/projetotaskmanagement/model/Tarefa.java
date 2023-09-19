package com.paulopraddo.projetotaskmanagement.model;

import com.paulopraddo.projetotaskmanagement.model.Conclusao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbtarefas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    private LocalDateTime dataEHora;

    @Enumerated(EnumType.STRING)
    private Conclusao conclusao;

}
