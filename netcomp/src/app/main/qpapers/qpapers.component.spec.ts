import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QpapersComponent } from './qpapers.component';

describe('QpapersComponent', () => {
  let component: QpapersComponent;
  let fixture: ComponentFixture<QpapersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QpapersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QpapersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
