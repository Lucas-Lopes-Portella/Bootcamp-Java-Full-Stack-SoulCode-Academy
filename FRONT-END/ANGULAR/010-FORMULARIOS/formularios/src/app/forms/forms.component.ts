import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';

@Component({
  selector: 'app-forms',
  templateUrl: './forms.component.html',
  styleUrls: ['./forms.component.css']
})
export class FormsComponent implements OnInit {
  user: User = {
    name: '',
    username: '',
    email: '',
    password: '',
    acceptTermsAndConditions: true,
    genre: '' 
  }

  saveUser():void{
    alert('user saved successfully');
    console.log(this.user);
  }
  constructor() { }

  ngOnInit(): void {
  }

}
