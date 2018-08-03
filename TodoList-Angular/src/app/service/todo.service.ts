import {Injectable} from '@angular/core';
import {Todo} from '../class/todo';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class TodoService {
  private todo: Todo;

  constructor(private http: HttpClient) {}

  getAll(): Observable<any> {
    return this.http.get('http://localhost:8080/getData');
  }

  sendValue(text: string, checked: boolean) {
    this.todo = new Todo(text, checked);
    return this.http.post('http://localhost:8080/putData', this.todo);
  }

  deleteData(id) {
    return this.http.delete('http://localhost:8080/deleteData/' + id);
  }

  checked(id, checked: boolean) {
    return this.http.patch('http://localhost:8080/updateData/' + id + '/' + checked, null);

  }
}
