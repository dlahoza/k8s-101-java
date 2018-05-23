package com.example.todomgr.repo;

import com.example.todomgr.model.Todo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private StringRedisTemplate template;

    @Override
    public List<Todo> findAll() {
        List<String> values = template.opsForValue().multiGet(template.keys("todos:*"));
        return values.stream().map(this::mapFromString).collect(Collectors.toList());
    }

    @Override
    public void create(Todo todo) {
        template.opsForValue().set("todos:" + todo.getId(), mapToString(todo));
    }

    @Override
    public Todo findById(String id) {
        return mapFromString(template.opsForValue().get("todos:" + id));
    }

    @Override
    public void update(String id, Todo newVersion) {
        template.opsForValue().set("todos:" + id, mapToString(newVersion));
    }

    @Override
    public void delete(String id) {
        template.delete("todos:" + id);
    }

    private String mapToString(Todo todo) {
        try {
            return mapper.writeValueAsString(todo);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException();
        }
    }

    private Todo mapFromString(String s) {
        try {
            return mapper.readValue(s.getBytes(), Todo.class);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }
}
