import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookingPromptComponent } from './booking-prompt.component';

describe('BookingPromptComponent', () => {
  let component: BookingPromptComponent;
  let fixture: ComponentFixture<BookingPromptComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookingPromptComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookingPromptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
