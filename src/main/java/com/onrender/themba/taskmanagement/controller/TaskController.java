package com.onrender.themba.taskmanagement.controller;

import com.onrender.themba.taskmanagement.model.TaskModel;
import com.onrender.themba.taskmanagement.entity.TaskEntity;
import com.onrender.themba.taskmanagement.repository.TaskRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @GetMapping("/tasks")
    public ResponseEntity<List<TaskEntity>> getAllTask(){
        return findByPagination(1);
    }

    @GetMapping("/tasks/page/{pageNumber}")
    public ResponseEntity<List<TaskEntity>> findByPagination(@PathVariable("pageNumber") int currentPage){

        Pageable pageable = PageRequest.of(currentPage-1, 3);
        Page<TaskEntity> page = taskRepository.findAll(pageable);
        List<TaskEntity> taskList = page.getContent();

        return ResponseEntity.ok(taskList);
    }

    @PostMapping("/tasks/new")
    public ResponseEntity<TaskEntity> createTask(@RequestBody TaskModel taskModel, HttpServletRequest httpServletRequest){
        TaskEntity taskEntity = new TaskEntity(taskModel.title(), taskModel.description());
        TaskEntity savedTask = taskRepository.save(taskEntity);
        return ResponseEntity.ok(savedTask);
    }


    @GetMapping("/testing")
    public ResponseEntity<String> test(HttpServletRequest httpServletRequest){

       // URI uri = UriComponentsBuilder.fromPath( "http:///"+httpServletRequest.getLocalName()+"/tasks/{id}").buildAndExpand("1000").toUri();
      //  System.out.println(uri);

        return ResponseEntity.ok("Testing Rest Controller");
    }
}
