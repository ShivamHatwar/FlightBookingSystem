import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AddUserComponent } from './component/add-user/add-user.component';
import { ListOperationsComponent } from './component/list-operations/list-operations.component';
import { BookTicketComponent } from './component/book-ticket/book-ticket.component';
import { SearchPipe } from './pipes/search.pipe';
import { ViewTicketComponent } from './component/view-ticket/view-ticket.component';
import { BookingPromptComponent } from './component/booking-prompt/booking-prompt.component';
import { SidebarComponent } from './component/sidebar/sidebar.component';
import { AboutUsComponent } from './component/about-us/about-us.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AddUserComponent,
    ListOperationsComponent,
    BookTicketComponent,
    SearchPipe,
    ViewTicketComponent,
    BookingPromptComponent,
    SidebarComponent,
    AboutUsComponent,
   
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MDBBootstrapModule.forRoot(),
    AppRoutingModule,
    NgbModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
