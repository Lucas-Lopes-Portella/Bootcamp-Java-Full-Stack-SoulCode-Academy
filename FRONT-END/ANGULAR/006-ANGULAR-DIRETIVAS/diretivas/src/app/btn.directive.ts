import { Directive, ElementRef, Input } from '@angular/core';

@Directive({
  selector: '[appBtn]'
})
export class BtnDirective {

  @Input()
  background: string = 'purple';

  constructor(private referencia: ElementRef<HTMLButtonElement>) { 
   
    this.referencia.nativeElement.style.border='none';
    this.referencia.nativeElement.style.color='white';
    this.referencia.nativeElement.style.display='block'
    this.referencia.nativeElement.style.margin='10px'
    this.referencia.nativeElement.style.fontFamily='Times new roman'
    }

    ngOnInit():void{
      this.referencia.nativeElement.style.backgroundColor=this.background;
    }
  
}
