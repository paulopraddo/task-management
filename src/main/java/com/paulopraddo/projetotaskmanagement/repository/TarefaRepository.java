package com.paulopraddo.projetotaskmanagement.repository;

import com.paulopraddo.projetotaskmanagement.entity.Tarefa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE TBTAREFAS SET ID = :newId WHERE id = :id", nativeQuery = true)
    void atualizarId(@Param("id") Long id, @Param("newId") Long newId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TBTAREFAS SET TITULO = :newTitulo WHERE id = :id", nativeQuery = true)
    void atualizarTitulo(@Param("id") Long id, @Param("newTitulo") String newTitulo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TBTAREFAS SET DESCRICAO = :newDescricao WHERE id = :id", nativeQuery = true)
    void atualizarDescricao(@Param("id") Long id, @Param("newDescricao") String newDescricao);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TBTAREFAS SET CONCLUSAO = 'CONCLUIDA' WHERE id = :id", nativeQuery = true)
    void marcarComoConcluida(@Param("id") Long id);
}
