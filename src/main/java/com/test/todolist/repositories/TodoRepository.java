package com.test.todolist.repositories;

import com.test.todolist.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM TODOS where realizado = false order by case PRIORIDADE "
            + " when 'ALTA' THEN 1 "
            + " when 'NORMAL' THEN 2 "
            + " end, datatarefa")
    List<Todo> findByPrioridade();

    @Query(nativeQuery = true, value = "SELECT * FROM TODOS where realizado = true")
    List<Todo> findByTarefaRealizadas();

    @Query(nativeQuery = true, value = "select * from todos where realizado = false and id = ?1")
    Todo findByTaredaId(Long id);


}
