import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

const routesEvent : Routes = [];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routesEvent)
  ],
  declarations: []
})
export class EventModule { }
