package com.example.todomgr.repo;


import com.example.todomgr.model.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, String> {
    List<Todo> findByPriority(int priority);
}


