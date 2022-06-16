import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ControleToDoComponent } from './controle-to-do.component';

describe('ControleToDoComponent', () => {
  let component: ControleToDoComponent;
  let fixture: ComponentFixture<ControleToDoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ControleToDoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ControleToDoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
