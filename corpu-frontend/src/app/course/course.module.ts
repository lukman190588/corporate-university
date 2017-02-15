import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

const routesCourse : Routes = [];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routesCourse)
  ],
  declarations: [],
})
export class CourseModule { }
