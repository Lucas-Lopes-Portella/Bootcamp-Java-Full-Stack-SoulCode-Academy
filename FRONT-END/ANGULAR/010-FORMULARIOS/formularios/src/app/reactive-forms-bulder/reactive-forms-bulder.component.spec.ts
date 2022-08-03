import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReactiveFormsBulderComponent } from './reactive-forms-bulder.component';

describe('ReactiveFormsBulderComponent', () => {
  let component: ReactiveFormsBulderComponent;
  let fixture: ComponentFixture<ReactiveFormsBulderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReactiveFormsBulderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReactiveFormsBulderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
