import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-reative-forms',
  templateUrl: './reative-forms.component.html',
  styleUrls: ['./reative-forms.component.css']
})
export class ReativeFormsComponent implements OnInit {

 /*  formName: FormControl = new FormControl('');
  formEmail: FormControl = new FormControl(''); */

   formUser: FormGroup = new FormGroup({
    name:new FormControl('', [ Validators.required]),
    username:new FormControl('',[Validators.required, Validators.minLength(8)]),
    email:new FormControl('',[Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required , Validators.minLength(6)]),
    genre: new FormControl('', [Validators.required]),
    acceptTermsAndConditionsField:new FormControl(true, [Validators.requiredTrue])
  }); 


  constructor() { }

  ngOnInit(): void {
  }

  submit():void{
    console.log(this.formUser.value); // retorna os valores registrados nos campos
    console.log(this.formUser.controls); // retorna todos os dados dos campos
  } 


}

