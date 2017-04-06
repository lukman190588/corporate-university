import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthService } from './shared/auth.service';
import { CekLoginGuard } from './shared/ceklogin';

// Layouts
import { AdminComponent } from './templates/admin.component';

// Front
import { FrontComponent } from './templates/front.component';

//page not found
import { p404Component } from './404/404.component';

//content
import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { TablesatuComponent } from './admin/tablesatu/tablesatu.component';
import { TableduaComponent } from './admin/tabledua/tabledua.component';
import { FormsatuComponent } from './admin/formsatu/formsatu.component';
import { TablesearchComponent } from './admin/tablesearch/tablesearch.component';


export const routes: Routes = [
  { path: '',  component: FrontComponent, pathMatch: 'full'},
  { path: 'login', loadChildren: './admin/login/login.module#LoginModule'},
  {
    path: 'admin',
    component: AdminComponent,
    data: { title: 'Home'},
    canActivate: [CekLoginGuard],
    children: [
      { path: 'dashboard', component: DashboardComponent},
      { path: 'tablesatu', component: TablesatuComponent},
      { path: 'tabledua', component: TableduaComponent},
      { path: 'formsatu', component: FormsatuComponent},
      { path: 'tablesearch', component: TablesearchComponent},
    ]
  },
  { path: '**', component: p404Component }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
