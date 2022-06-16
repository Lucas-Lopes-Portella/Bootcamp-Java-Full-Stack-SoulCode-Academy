

import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  contador: number = 0
  simbolos: string[] = ['+', '-']

  incrementar(): void{
    this.contador++
  }

  decrementar(): void{
    this.contador--
  }

  adicionarValor(evento: any): void{
    this.contador = parseFloat(evento.target.value);
  }   
}