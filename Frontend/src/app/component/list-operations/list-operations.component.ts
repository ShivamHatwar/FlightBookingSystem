import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbCarouselConfig} from '@ng-bootstrap/ng-bootstrap';
import { UserService } from'../../service/user.service';

@Component({
  selector: 'app-list-operations',
  templateUrl: './list-operations.component.html',
  styleUrls: ['./list-operations.component.css'],
  providers: [NgbCarouselConfig]
})
export class ListOperationsComponent implements OnInit {

  constructor(private router: Router,config:NgbCarouselConfig) { 
    config.interval = 5000;
    config.wrap = true;
    config.keyboard = true;
    config.pauseOnHover=false;
  }

  ngOnInit(){
    if (localStorage.username == null) {
      this.router.navigate(['/login']); 
   
  }
  }
}
