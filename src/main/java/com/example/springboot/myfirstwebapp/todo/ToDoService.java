package com.example.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ToDoService {

	private static int todosCount = 0;

	private static List<Todo> todos = new ArrayList<>();

	static {
		todos.add(new Todo(++todosCount, "webapp", "Learn aws", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "webapp", "Learn devops", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "webapp", "Learn full stack dev", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "webapp", "Learn spring", LocalDate.now().plusYears(3), false));

	}

	public List<Todo> fingByUsername(String username) {
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}

	public void addToDo(String username, String description, LocalDate targetdate, boolean done) {
		Todo todo = new Todo(++todosCount, username, description, targetdate, done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		 //todo -> todo.getId() ==  id
		Predicate<? super Todo> predicate = todo -> todo.getId() ==  id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() ==  id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
		
	}

	public void updateToDo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		
	}
}
