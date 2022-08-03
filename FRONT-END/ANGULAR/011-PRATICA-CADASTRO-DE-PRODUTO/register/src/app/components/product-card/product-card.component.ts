import { Component, Input, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css'],
})
export class ProductCardComponent implements OnInit {
  @Input()
  productName: string = '';

  @Input()
  productPrice: number = 0;

  @Input()
  productPhoto: string = '';

  constructor(private _snackBar: MatSnackBar) {}

  openSnackBar() {
    this._snackBar.open(`${this.productName} comprado.`,'Ok', {
      duration:5000,
      horizontalPosition: 'center',
      verticalPosition:'top'
    });
    
  }

  ngOnInit(): void {}
}
