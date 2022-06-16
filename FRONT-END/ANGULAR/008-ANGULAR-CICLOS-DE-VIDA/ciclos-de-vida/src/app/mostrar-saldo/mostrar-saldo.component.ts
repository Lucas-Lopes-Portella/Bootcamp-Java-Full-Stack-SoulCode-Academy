import { AfterContentInit, Component, DoCheck, ElementRef, Input, OnChanges, OnDestroy, OnInit, SimpleChanges, ViewChild } from '@angular/core';

@Component({
  selector: 'app-mostrar-saldo',
  templateUrl: './mostrar-saldo.component.html',
  styleUrls: ['./mostrar-saldo.component.css']
})
export class MostrarSaldoComponent implements OnInit, OnChanges, DoCheck, AfterContentInit, OnDestroy {

  @Input()
  appSaldo: number = 10;
  saldoAnterior: number | string = '';

  @ViewChild('paraSaldoAnterior')
  paraSaldoAnterior!: ElementRef<HTMLParagraphElement>
  
  

  constructor() {
    console.log(this.appSaldo)
   }
  
  

   //1º
  ngOnChanges(changes: SimpleChanges): void {

    console.log('%cngOnChanges executado!', 'font-size: 20px; color: red;')

    if(changes['appSaldo'].previousValue != undefined ) {
      this.saldoAnterior = changes['appSaldo'].previousValue
    } else {
      this.saldoAnterior = 'Saldo não informado'
    }
    

  }


  //2º
  ngOnInit(): void {
    console.log('%cngOnInit executado!', 'font-size: 20px; color: red;')
    console.log(this.appSaldo)
  }


  // 3º
  ngDoCheck(): void {
    console.log('%cngDoChecked executado!', 'font-size: 20px; color: red;')
  }

  // 4º
  ngAfterContentInit(): void {
    console.log('%cngAfterContentInit executado!', 'font-size: 20px; color: red;')
  }

  ngOnDestroy(): void {
    console.log('%cngOnDestroy executado!', 'font-size: 20px; color: green;')
  }
}
