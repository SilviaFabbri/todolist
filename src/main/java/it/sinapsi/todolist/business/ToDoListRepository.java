package it.sinapsi.todolist.business;

import it.sinapsi.todolist.model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
    List<ToDoList> findByNome(String nome);
    List<ToDoList> findByCommento(String commento);
}
