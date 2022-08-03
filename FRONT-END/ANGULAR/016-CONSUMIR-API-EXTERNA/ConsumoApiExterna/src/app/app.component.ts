import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'ConsumoApiExterna';
  public moviesApiContent$!: Observable<any>;
  constructor(private http: HttpClient) {}

  

  ngOnInit(): void {
    this.moviesApiContent$ = this.http.get(
      'https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060'
    );
  }
}
