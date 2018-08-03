import {Component, Input, OnInit} from '@angular/core';
import {TodoService} from '../../service/todo.service';
import {Todo} from '../../class/todo';

@Component({
  selector: 'app-veri',
  templateUrl: './veri.component.html',
  styleUrls: ['./veri.component.css']
})
export class VeriComponent implements OnInit {
  liste: Array<any>;
  public todoText: string;


  constructor(private todoService: TodoService) {
    this.todoText = '';
  }


  ngOnInit() {
    this.todoService.getAll().subscribe(data => {
      this.liste = data;
    });
  }

  private removeTodo(id) {
    this.todoService.deleteData(id).subscribe(index => {
      this.todoService.getAll().subscribe(data => {
        this.liste = data;
      });
    });
  }

  private sendValue(): void {
    this.todoService.sendValue(this.todoText, false).subscribe(index => {
      this.todoService.getAll().subscribe(data => {
        this.liste = data;
      });
    });
    this.todoText = '';
  }

  private checked(id, checked: boolean) {
    this.todoService.checked(id, checked).subscribe(index => {
      this.todoService.getAll().subscribe(data => {
        this.liste = data;
      });
    });
  }
}
