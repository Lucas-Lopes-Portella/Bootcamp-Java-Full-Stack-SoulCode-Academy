import { Component, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'comunicacao-entre-componentes';

  estiloDoCartao: string = 'display:block;';

  texto: string = '';

  @ViewChild('templateTeste')
  pOlaMundo!: ElementRef<HTMLParagraphElement>;

  ngAfterViewInit(){
    setTimeout(()=>{
      this.pOlaMundo.nativeElement.innerText = "teste texto"
    }, 5000)
  }

  deletarCartao(evento: any): void {
    console.log(evento);
      this.estiloDoCartao = 'display:none;';
  }
    mudarTexto(valor: string): void{
      this.texto = valor;
    }

}
