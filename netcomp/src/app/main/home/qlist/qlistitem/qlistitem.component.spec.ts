import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QlistitemComponent } from './qlistitem.component';

describe('QlistitemComponent', () => {
  let component: QlistitemComponent;
  let fixture: ComponentFixture<QlistitemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QlistitemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QlistitemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
