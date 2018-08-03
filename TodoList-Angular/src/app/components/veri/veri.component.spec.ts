import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VeriComponent } from './veri.component';

describe('VeriComponent', () => {
  let component: VeriComponent;
  let fixture: ComponentFixture<VeriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VeriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VeriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
