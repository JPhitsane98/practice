import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Micro4Component } from './micro4.component';

describe('Micro4Component', () => {
  let component: Micro4Component;
  let fixture: ComponentFixture<Micro4Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Micro4Component]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(Micro4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
