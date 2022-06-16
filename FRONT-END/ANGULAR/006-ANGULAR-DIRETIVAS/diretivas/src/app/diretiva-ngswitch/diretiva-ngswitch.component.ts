import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-diretiva-ngswitch',
  templateUrl: './diretiva-ngswitch.component.html',
  styleUrls: ['./diretiva-ngswitch.component.css']
})
export class DiretivaNgswitchComponent implements OnInit {

  color: string = 'black';

  constructor() { }

  ngOnInit(): void {
  }

  mudarCor(newColor: string): void {
    this.color = newColor;
  }

}
