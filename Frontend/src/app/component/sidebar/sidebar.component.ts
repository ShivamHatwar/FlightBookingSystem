import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
  }

  toggleSidebar(){

    document.getElementById("sb").classList.toggle('active');
  }
  logOut(){
    localStorage.clear();
    sessionStorage.clear();
    this.router.navigate(['/login'])
  }

}
