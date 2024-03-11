package com.test.todolist;

import com.test.todolist.enums.Prioridade;
import com.test.todolist.model.Todo;
import com.test.todolist.services.TodoService;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class TodolistApplicationTests extends TestCase {

    @Autowired
    private TodoService todoService;

    @Test
    public void testeSalvar(){
        Todo todo = new Todo();
        todo.setId(1L);
        todo.setNome("Ajustar");
        todo.setDescricao("Ajustar tela de caminho");
        todo.setPrioridade(Prioridade.valueOf("ALTA"));
        todoService.save(todo);
    }

    @Test
    public void testAtualizar(){
        Todo todo = new Todo();
        todo.setId(1L);
        todo.setNome("Ajustar Atualizado");
        todo.setDescricao("Ajustar tela de caminho, não precisa mais");
        todo.setPrioridade(Prioridade.valueOf("NORMAL"));
        todo.setDatatarefa(new Date());
        todoService.update(todo);

    }

    @Test
    public void testBuscar(){
        List<Todo> t = todoService.list();
        System.out.println(t);
    }

    @Test
    public void testDeletar(){
        todoService.delete(1L);
    }


}
