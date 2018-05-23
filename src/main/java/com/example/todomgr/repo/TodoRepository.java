package com.example.todomgr.repo;


import com.example.todomgr.model.Todo;

import java.util.List;

public interface TodoRepository {

    List<Todo> findAll();

    void create(Todo todo);

    Todo findById(String id);

    void update(String id, Todo newVersion);

    void delete(String id);


}


