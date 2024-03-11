package com.test.todolist.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.test.todolist.enums.Prioridade;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

@Entity(name = "todos")
@Table(name = "todos")
@SequenceGenerator(name = "seq_todos", sequenceName = "seq_todos", allocationSize = 1, initialValue = 1)
public class Todo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_todos")
    private Long id;

    @NotNull(message = "O nome deve ser informado")
    private String nome;

    @NotNull(message = "A descrição deve ser informada")
    private String descricao;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date datatarefa;

    private boolean realizado = false;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDatatarefa() {
        return datatarefa;
    }

    public void setDatatarefa(Date datatarefa) {
        this.datatarefa = datatarefa;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", datatarefa=" + datatarefa +
                ", realizado=" + realizado +
                ", prioridade=" + prioridade +
                '}';
    }
}
