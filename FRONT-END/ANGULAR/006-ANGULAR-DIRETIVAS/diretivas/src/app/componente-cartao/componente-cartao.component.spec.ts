import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponenteCartaoComponent } from './componente-cartao.component';

describe('ComponenteCartaoComponent', () => {
  let component: ComponenteCartaoComponent;
  let fixture: ComponentFixture<ComponenteCartaoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComponenteCartaoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ComponenteCartaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
