/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { FormsatuComponent } from './formsatu.component';

describe('FormsatuComponent', () => {
  let component: FormsatuComponent;
  let fixture: ComponentFixture<FormsatuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormsatuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormsatuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
