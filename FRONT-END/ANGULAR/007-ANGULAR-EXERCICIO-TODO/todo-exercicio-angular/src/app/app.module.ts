import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ControleToDoComponent } from './controle-to-do/controle-to-do.component';
import { ItemTodoComponent } from './item-todo/item-todo.component';

@NgModule({
  declarations: [
    AppComponent,
    ControleToDoComponent,
    ItemTodoComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
