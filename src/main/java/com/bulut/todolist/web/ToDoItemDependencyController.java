package com.bulut.todolist.web;

import com.bulut.todolist.model.ToDoItemDependency;
import com.bulut.todolist.service.ToDoItemDependencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("/todoitemdependency")
@RequestMapping(value = "/api/todoitemdependency")
@CrossOrigin
public class ToDoItemDependencyController {
    @Autowired
    private ToDoItemDependencyService toDoItemDependencyService;

    @Autowired
    private MessageSource messageProvider;

    @PostMapping("/saveorupdate")
    private ToDoItemDependency saveOrUpdateTodoItemDependency(@Valid @RequestBody ToDoItemDependency toDoItemDependency){
        return toDoItemDependencyService.saveOrUpdateDependency(toDoItemDependency);
    }

    @PostMapping("/delete")
    private void deleteToDoItem(Long id){
        toDoItemDependencyService.deleteById(id);
    }

    @GetMapping("/itemdependencylist")
    private List<ToDoItemDependency> getItemsDependencyList(Long list_id, Long id){
        return toDoItemDependencyService.getItemDependencys(list_id, id);
    }
}
