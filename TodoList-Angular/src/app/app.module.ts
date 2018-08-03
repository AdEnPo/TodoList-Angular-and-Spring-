import {environment} from '../environments/environment';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { TodoService } from './service/todo.service';
import { HttpClientModule } from '@angular/common/http';
import { VeriComponent } from './components/veri/veri.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    VeriComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    TodoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
