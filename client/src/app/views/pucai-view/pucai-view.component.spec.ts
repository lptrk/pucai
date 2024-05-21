import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PucaiViewComponent } from './pucai-view.component';

describe('PucaiViewComponent', () => {
  let component: PucaiViewComponent;
  let fixture: ComponentFixture<PucaiViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PucaiViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PucaiViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
