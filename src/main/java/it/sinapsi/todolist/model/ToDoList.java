package it.sinapsi.todolist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity(name = "todolist")
public class ToDoList {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column()
    private String commento;
}
