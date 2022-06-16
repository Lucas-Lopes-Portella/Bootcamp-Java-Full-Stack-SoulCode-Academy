import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'pipes';
  subtitle:string = 'subtitle';
  
  obj = {
    nome: 'Lucas',
    idade: 23
  };
  
  data: Date = new Date();
}
