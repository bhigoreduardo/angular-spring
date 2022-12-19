import { Injectable } from '@angular/core';
import { TodoInput, TodoModel } from './Todo';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  apiURL: string = 'http://localhost:8080/api/todos';

  constructor(
    private http: HttpClient
  ) { }

  insert(todoInput: TodoInput): Observable<TodoModel> {
    return this.http.post<TodoModel>(this.apiURL, todoInput);
  }

  findAll(): Observable<TodoModel[]> {
    return this.http.get<TodoModel[]>(this.apiURL);
  }

  deleteById(id: number): Observable<void> {
    const url = `${this.apiURL}/${id}`;

    return this.http.delete<void>(url);
  }

  activeStatus(id: number): Observable<TodoModel> {
    const url = `${this.apiURL}/${id}/feito`;

    return this.http.patch<TodoModel>(url, {});
  }
}
