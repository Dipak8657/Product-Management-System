import { Injectable } from '@angular/core';
import { HttpClient ,HttpClientModule } from '@angular/common/http';
import { Product } from '../model/product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  addProdURL :string ;
  getProdURL : string ;
  updateProdUrl : string;
  deleteProdUrl : string;
  getProdbyidURL:string;


  constructor(private http :HttpClient ) { 

  this.addProdURL= 'http://localhost:8081/prod/addProduct';
  this.getProdURL= 'http://localhost:8081/prod/getAll';
  this.updateProdUrl='http://localhost:8081/prod/editProduct';
  this.deleteProdUrl='http://localhost:8081/prod/deleteProductById';
  this.getProdbyidURL='http://localhost:8081/prod/GetProductByID'; 

  }

  addProduct(pro : Product):Observable<Product>{

    return this.http.post<Product>(this.addProdURL,pro);

  }

  getAllProduct(): Observable<Product[]>{
    return this.http.get<Product[]>(this.getProdURL);
  }


  updateProduct(prod :Product) : Observable<Product>{
    return this.http.put<Product>(this.updateProdUrl, prod);
  }

  deleteProduct(prod : Product) : Observable<Product> {
    return this.http.delete<Product>(this.deleteProdUrl+'/'+prod.id);
  }



  getProductById(productId: number): Observable<Product> {
    return this.http.get<Product>(this.getProdbyidURL + '/'+ productId );
  }

  
}
