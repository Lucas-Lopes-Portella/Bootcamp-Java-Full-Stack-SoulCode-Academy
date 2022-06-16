import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'cartao', /// <cartao> </cartao>
  templateUrl: './cartao.component.html',
  styleUrls: ['./cartao.component.css']
})

// propriedade > construtor > método
export class CartaoComponent implements OnInit {

  @Input() // importar método para interação de componentes
  tituloCartao: string = "Test Title";

  @Input()
  textoCartao: string = "Test txt";

  @Input()
  corBorda: string = "orange";

  @Input()
  imgTest: string = "";

  @Output()
  deletar: EventEmitter<any> = new EventEmitter<any>();

  constructor() { }

  ngOnInit(): void {
  }

  emitirDelecaoCartao(): void {
    this.deletar.emit({excluir: true});
  
  }

  gerarCssCartao(): string {
    return `border-color: ${this.corBorda}`;
  }

}
