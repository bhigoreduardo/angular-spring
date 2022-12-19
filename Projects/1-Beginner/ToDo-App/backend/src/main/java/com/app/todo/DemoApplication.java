package com.app.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.todo.domain.model.Todo;
import com.app.todo.domain.repository.TodoRepository;

@SpringBootApplication
public class DemoApplication {
	
	@Autowired
	private TodoRepository todoRepository;
	
	@Bean
	public CommandLineRunner init() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				Todo todo = new Todo();
				todo.setDescricao("Estudar Spring");
				
				todoRepository.save(todo);
				for(Todo t : todoRepository.findAll()) {
					System.out.println(t.toString());
				}
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
