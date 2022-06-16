import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-diretiva-ngfor',
  templateUrl: './diretiva-ngfor.component.html',
  styleUrls: ['./diretiva-ngfor.component.css']
})
export class DiretivaNgforComponent implements OnInit { 

  nomes: string[] = ['Dani', 'Daniel', 'Claudia', 'Fernanda Gonzalez', 'Marlon', 'Vitor'];
  idades: number[] = [25,23,27,24,19,23];

  constructor() { }

  ngOnInit(): void {
  }

  add(nome:string):void{
    this.nomes.push(nome);
  }

}
