import {Component, OnInit} from '@angular/core';
import {TodoService} from '../../service/todo.service';
import {Todo} from '../../class/todo';
import {VeriComponent} from '../veri/veri.component';

@Component({
  selector: 'app-marked',
  templateUrl: './marked.component.html',
  styleUrls: ['./marked.component.css']
})
export class MarkedComponent implements OnInit {
  liste: Array<any>;

  constructor(private todoService: TodoService) {
  }

  ngOnInit() {
    this.todoService.getChecked().subscribe(data => {
      this.liste = data;
    });
  }

  private removeTodo(id) {
    this.todoService.deleteData(id).subscribe(index => {
      this.todoService.getChecked().subscribe(data => {
        this.liste = data;
      });
    });
  }

  private checked(id, checked: boolean) {
    this.todoService.checked(id, checked).subscribe(index => {
      this.todoService.getChecked().subscribe(data => {
        this.liste = data;
      });
    });
  }
}
