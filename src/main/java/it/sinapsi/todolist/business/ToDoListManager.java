package it.sinapsi.todolist.business;

import it.sinapsi.todolist.Dao.ToDoListDao;
import it.sinapsi.todolist.Dto.ToDoListDto;
import it.sinapsi.todolist.model.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/todolist")
public class ToDoListManager {
    @Autowired
    private ToDoListDao dao;
    @Autowired
    private ToDoListRepository repository;
    @GetMapping("")
    public @ResponseBody
    List<ToDoList> getAll(ToDoCriterio criterio) {

        if (criterio.getNome() == null && criterio.getCommento() == null) {
            return repository.findAll();
        } else if (criterio.getNome() == null) {
            return repository.findByCommento(criterio.getCommento());
        } else {
            return repository.findByNome(criterio.getNome());
        }
    }

    @PostMapping("")
    public HttpStatus create(@RequestBody ToDoListDto dto){
        this.dao.create(dto);
        return HttpStatus.CREATED;
    }

    @PutMapping("/{id}")
    public HttpStatus update(@PathVariable("id") Long id, @RequestBody ToDoListDto dto) {
        if(dao.update(id, dto).isEmpty()){
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.ACCEPTED;
    }
    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            return HttpStatus.FOUND;
        }
        return HttpStatus.NOT_FOUND;
    }
}
