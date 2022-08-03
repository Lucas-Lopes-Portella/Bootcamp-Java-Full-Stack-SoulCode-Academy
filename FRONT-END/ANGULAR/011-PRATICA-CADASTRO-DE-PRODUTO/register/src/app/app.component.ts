import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ProductFormComponent } from './components/product-form/product-form.component';
import { Products } from './models/products';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'register';
  Tittle: String = 'Produtos';

  products: Array<Products> = [];

  constructor(private mt: MatDialog) {}

  openDialog(): void {
    const dialogRef = this.mt.open(ProductFormComponent);

    dialogRef.afterClosed().subscribe((showOnScreen) => {
      console.log(showOnScreen);
      console.log(this.products);

      if(showOnScreen){
        this.products.push(showOnScreen);
        console.log(this.products);
      }
    });
  }
}
