import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import { FormsComponent } from './forms/forms.component';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ReativeFormsComponent } from './reative-forms/reative-forms.component';
import { ReactiveFormsBulderComponent } from './reactive-forms-bulder/reactive-forms-bulder.component';

@NgModule({
  declarations: [
    AppComponent,
    FormsComponent,
    ReativeFormsComponent,
    ReactiveFormsBulderComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule, 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
