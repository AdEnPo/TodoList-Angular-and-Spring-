import {environment} from '../environments/environment';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {TodoService} from './service/todo.service';
import {HttpClientModule} from '@angular/common/http';
import {VeriComponent} from './components/veri/veri.component';
import {NavigationComponent} from './components/navigation/navigation.component';
import {MarkedComponent} from './components/marked/marked.component';
import {RouterModule, Routes} from '@angular/router';

const appRoutes: Routes = [
  {
    path: '',
    component: NavigationComponent
  },
  {
    path: 'marked',
    component: MarkedComponent
  },
  {
    path: 'notes',
    component: VeriComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    VeriComponent,
    NavigationComponent,
    MarkedComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    TodoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
