import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'diretivas';
  corDoParagrafo: string = 'Chartreuse';

  mudarCorDoParagrafo(cor: string): void {
    this.corDoParagrafo = cor;
  }
}


