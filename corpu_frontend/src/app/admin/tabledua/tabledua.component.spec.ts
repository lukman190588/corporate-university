/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { TableduaComponent } from './tabledua.component';

describe('TableduaComponent', () => {
  let component: TableduaComponent;
  let fixture: ComponentFixture<TableduaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableduaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableduaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
