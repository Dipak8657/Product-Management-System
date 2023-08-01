package com.spring_crud_api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_crud_api.model.Products;
import com.spring_crud_api.repository.ProductRepository;
import com.spring_crud_api.services.ProductService;

@RestController
@RequestMapping("/prod")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// add new product
	@PostMapping("/addProduct")
	public Products addProduct(@RequestBody  Products product) {
		return productService.addProduct(product);
		
	}
	
	// add more than 1 product
	@PostMapping("/addProducts")
	public List<Products> addAllEmployees(@RequestBody List<Products> products){
	
      return productService.addAllProducts(products);
}
	
	
	// get prodyct by id 
	@GetMapping("/GetProductByID/{id}")
	public Products GetProductByID(@PathVariable int id) {
		return productService.getProductByID(id);
		
	}
	
	 @GetMapping("/getProductByName/{name}")
	 
	 public  Products getProductByName(@PathVariable String name) {
	        return  productService.getProductByName(name);
	    }
	 
	 // update product 
	 
	 @PutMapping("/editProduct")
	 
	 public Products updateProduct(@RequestBody Products product) {
		 
		 return productService.updateProduct(product);
	 }
	
	
	 // delete product
	 
	 @DeleteMapping("/deleteProductById/{id}")
	 
	    public boolean deleteProductByID(@PathVariable int id) {
	        return productService.deleteProductByID(id);
	    }
	 
	 @GetMapping("/getAll")
	    public List<Products> getAllProduct() {
	        return productService.getAllProduct();
	    }
	
	

}
