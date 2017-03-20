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


export const routes: Routes = [
  {
    path: '',
    component: FrontComponent,
    pathMatch: 'full'
  },
  {
    path: 'admin',
    component: AdminComponent,
    data: {
      title: 'Home'
    },
    children: [
      {
        path: 'login',
        loadChildren: './admin/login/login.module#LoginModule',
      },
      {
        path: 'dashboard',
        component: DashboardComponent,
        canActivate: [CekLoginGuard]
      },
      {
        path: 'tablesatu',
        component: TablesatuComponent,
        canActivate: [CekLoginGuard]
      },
      {
        path: 'tabledua',
        component: TableduaComponent,
        canActivate: [CekLoginGuard]
      },
      {
        path: 'formsatu',
        component: FormsatuComponent,
        canActivate: [CekLoginGuard]
      }
    ]
  },
  { path: '**', component: p404Component }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
