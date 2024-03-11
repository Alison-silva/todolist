package com.test.todolist.controller;

import com.test.todolist.infra.ExceptionMensagemJava;
import com.test.todolist.model.Todo;
import com.test.todolist.services.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody @Valid Todo todo) throws Exception {

        if (todo.getNome() == null || todo.getNome().trim().isEmpty()){
            throw new ExceptionMensagemJava("O nome deve ser informado");
        }
        if (todo.getDescricao() == null || todo.getDescricao().trim().isEmpty()){
            throw new ExceptionMensagemJava("A descrição deve ser informada");
        }
        Date data = new Date();
        todo.setDatatarefa(new Date());
        Todo newTodo = todoService.save(todo);
        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> list(){
        List<Todo> todo = todoService.list();
        return new ResponseEntity<List<Todo>>(todo, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Todo> update(@RequestBody Todo todo){
        Todo t = todoService.update(todo);
        return new ResponseEntity<Todo>(t, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable("id") Long id){
        todoService.delete(id);
        return "Deletado com sucesso!";
    }

    @GetMapping(value = "/listarPorPrioridade")
    public ResponseEntity<List<Todo>> listarPorPrioridade(){
        List<Todo> todo = todoService.listarPorPrioridade();
        return new ResponseEntity<List<Todo>>(todo, HttpStatus.OK);
    }

    @GetMapping(value = "/listarPorTarefesRealizadas")
    public ResponseEntity<List<Todo>> listarPorTarefesRealizadas(){
        List<Todo> todo = todoService.listarPorTarefesRealizadas();
        return new ResponseEntity<List<Todo>>(todo, HttpStatus.OK);
    }

    @GetMapping(value = "alterarRealizado/{id}")
    public String alterarRealizado(@PathVariable("id") Long id) throws ExceptionMensagemJava {

        Optional<Todo> t = todoService.buscarId(id);

        if(t.isEmpty()){
            throw new ExceptionMensagemJava("Tarefa não encontrada");
        }

        Optional<Todo> to = todoService.buscarIdTarefa(id);
        if(to.isEmpty()){
            throw new ExceptionMensagemJava("A tarefa já foi concluída");
        }

        todoService.alterarRealizazao(id);
        return "A tarefa foi concluída!";
    }

    @GetMapping(value = "/buscarIdTarefa/{id}")
    public ResponseEntity<Todo> buscarIdTarefa(@PathVariable(value = "id") Long id) throws ExceptionMensagemJava {
        Optional<Todo> todo = todoService.buscarIdTarefa(id);
        if (todo.isEmpty()){
            throw new ExceptionMensagemJava("A tarefa já foi concluída");
        }
        return new ResponseEntity<>(todo.get(), HttpStatus.OK);
    }

}
