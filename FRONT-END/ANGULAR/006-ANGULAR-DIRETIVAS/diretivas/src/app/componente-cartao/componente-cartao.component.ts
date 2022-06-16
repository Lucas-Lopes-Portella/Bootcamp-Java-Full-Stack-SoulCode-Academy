import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente-cartao',
  templateUrl: './componente-cartao.component.html',
  styleUrls: ['./componente-cartao.component.css']
})
export class ComponenteCartaoComponent implements OnInit {
  titulo: string = "Titulo";

  constructor() { }

  ngOnInit(): void {
  }

  

}
