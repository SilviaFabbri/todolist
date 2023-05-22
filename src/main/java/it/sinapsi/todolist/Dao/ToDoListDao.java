package it.sinapsi.todolist.Dao;

import it.sinapsi.todolist.Dto.ToDoListDto;
import it.sinapsi.todolist.business.ToDoListRepository;
import it.sinapsi.todolist.model.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ToDoListDao {
    @Autowired
    private ToDoListRepository repository;

    public void create(ToDoListDto dto){
        ToDoList todo = new ToDoList();
        todo.setNome(dto.getNome());
        todo.setCommento(dto.getCommento());
        try{
             this.repository.save(todo);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public Optional<ToDoList> update(Long id, ToDoListDto dto){
        Optional<ToDoList> todoDB = repository.findById(id);
        try {
            ToDoList todoAggiornato = todoDB.get();
            todoAggiornato.setNome(dto.getNome());
            todoAggiornato.setCommento(dto.getCommento());
            return Optional.of(repository.save(todoAggiornato));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void delete(Long id){
        Optional<ToDoList> todoDB = repository.findById(id);
        try{
            repository.delete(todoDB.get());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
