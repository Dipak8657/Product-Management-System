import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder,FormControl } from '@angular/forms';
import { Product } from 'src/app/model/product';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  proDetail !: FormGroup;

  proObj : Product = new Product(); 
  prodList : Product[]=[];

  searchResult: Product | undefined;

  constructor(private formBuilder : FormBuilder , private proService : ProductService){}

  ngOnInit():void {

    this.getAllProduct();

    this.proDetail=this.formBuilder.group({
      id:[''],
      name:[''],
      qunty:[''],
      price:[''],
      descrip:['']

    });

  }

  addProduct(){
    console.log(this.proDetail);
    this.proObj.name=this.proDetail.value.name;
    this.proObj.id=this.proDetail.value.id;
    this.proObj.qunty=this.proDetail.value.quenty;
    this.proObj.price=this.proDetail.value.price;
    this.proObj.descrip=this.proDetail.value.descrip;




    this.proService.addProduct(this.proObj).subscribe((res: any) =>{
      console.log(res);
      this.getAllProduct();
    },(err: any)=>{
       console.log(err);
    })
  }
   
  getAllProduct() {
    this.proService.getAllProduct().subscribe(res=>{
        this.prodList = res;
    },err=>{
      console.log("error while fetching data.")
    });
  }



      editProduct(prod : Product){
       
      this.proDetail.controls['name'].setValue(prod.name);
      this.proDetail.controls['id'].setValue(prod.id);
      this.proDetail.controls['qunty'].setValue(prod.qunty);
      this.proDetail.controls['price'].setValue(prod.price);
      this.proDetail.controls['descrip'].setValue(prod.descrip);
    }

    updateProduct(){

    this.proObj.name=this.proDetail.value.name;
    this.proObj.id=this.proDetail.value.id;
    this.proObj.qunty=this.proDetail.value.qunty;
    this.proObj.price=this.proDetail.value.price;
    this.proObj.descrip=this.proDetail.value.descrip;

    this.proService.updateProduct(this.proObj).subscribe(res=>{
      console.log(res);
      this.getAllProduct();
    },err=>{
      console.log(err);
    })
    }

    deleteProduct(pro : Product) {

      this.proService.deleteProduct(pro).subscribe((res)=>{
        console.log(res);
        alert('Product deleted successfully');
        this.getAllProduct();
      },err => {
        console.log(err);
      });

    }


    searchProductById() {
      const productId = this.proDetail.value.id;
      if (productId) {
        this.proService.getProductById(productId).subscribe(
          (res) => {
            this.searchResult = res;
          },
          (err) => {
            console.log(err);
            this.searchResult = undefined;
          }
        );
      } else {
        this.searchResult = undefined;
      }
    } 
    
    closeSearchResults() {
      this.searchResult =  undefined; 
    }


    
  }









    
  




