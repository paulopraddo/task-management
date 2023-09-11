package com.paulopraddo.projetotaskmanagement.repository;

import com.paulopraddo.projetotaskmanagement.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
