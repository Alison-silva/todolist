package com.test.todolist.services;

import com.test.todolist.model.Todo;
import com.test.todolist.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> list(){
        return todoRepository.findAll();
    }

    public Todo update(Todo todo){
        return todoRepository.save(todo);
    }

    public void delete(Long id){
        todoRepository.deleteById(id);
    }

    public List<Todo> listarPorPrioridade(){
        return todoRepository.findByPrioridade();
    }

    public List<Todo> listarPorTarefesRealizadas(){
        return todoRepository.findByTarefaRealizadas();
    }

    public void alterarRealizazao(Long idTodo) {
        String sql = "begin; UPDATE todos SET realizado = true  where id = "+ idTodo +"; commit;";
        jdbcTemplate.execute(sql);
    }

    public Optional<Todo> buscarIdTarefa(Long id) {
        return Optional.ofNullable(todoRepository.findByTaredaId(id));
    }

    public Optional<Todo> buscarId(Long id){
        return todoRepository.findById(id);
    }




}













