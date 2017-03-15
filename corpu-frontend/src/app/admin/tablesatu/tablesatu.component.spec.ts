/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { TablesatuComponent } from './tablesatu.component';

describe('TablesatuComponent', () => {
  let component: TablesatuComponent;
  let fixture: ComponentFixture<TablesatuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TablesatuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TablesatuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
