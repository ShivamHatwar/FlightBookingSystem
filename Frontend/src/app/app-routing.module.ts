import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './component/login/login.component'
import { AddUserComponent } from './component/add-user/add-user.component'
import { ListOperationsComponent } from './component/list-operations/list-operations.component'
import { BookTicketComponent } from './component/book-ticket/book-ticket.component'  
import { ViewTicketComponent } from './component/view-ticket/view-ticket.component'
import { BookingPromptComponent } from './component/booking-prompt/booking-prompt.component'
import { AboutUsComponent } from './component/about-us/about-us.component'
 


const routes: Routes = [
  {path:'',redirectTo: 'login', pathMatch: 'full'},
{path:'login',component:LoginComponent},
{path:'add-user',component:AddUserComponent},
{path:'list-operation',component:ListOperationsComponent},
{path:'bookTicket',component:BookTicketComponent},
{path:'bookingPrompt',component:BookingPromptComponent},
{path:'viewTicket',component:ViewTicketComponent},
{path:'aboutUs',component:AboutUsComponent},
{path:'**',component:LoginComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
