import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { TodoInput, TodoModel } from './Todo';
import { TodoService } from './todo.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'frontend';

  todos: TodoModel[] = [];
  form: FormGroup = new FormGroup({
    descricao: new FormControl('', [Validators.required, Validators.minLength(4)])
  });

  constructor(
    private service: TodoService
  ) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void {
    this.service.findAll()
      .subscribe(todos => this.todos = todos);
  }

  insert(): void {
    const todoInput: TodoInput = { ...this.form.value };

    this.service
      .insert(todoInput)
      .subscribe(todo => {
        this.todos.push(todo);
        this.form.reset();
      });
  }

  deleteById(todoModel: TodoModel): void {
    this.service.deleteById(todoModel.id)
      .subscribe(response => this.findAll());
  }

  activeStatus(todoModel: TodoModel): void {
    this.service.activeStatus(todoModel.id)
      .subscribe(todo => {
        todoModel.status = todo.status;
        todoModel.dataFinalizacao = todo.dataFinalizacao;
      })
  }
}
