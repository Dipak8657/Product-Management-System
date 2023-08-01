package com.spring_crud_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_crud_api.model.Products;
import com.spring_crud_api.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	
	private  ProductRepository  productRepository;

	public Products addProduct(Products product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	public List<Products> addAllProducts(List<Products> products) {
		// TODO Auto-generated method stub
		return productRepository.saveAll(products);
	}

	public Products getProductByID(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).orElse(null);
	}
	
	

	public Products getProductByName(String name) {
        return  productRepository.getByName(name);
    }

	public Products updateProduct(Products product) {
		// TODO Auto-generated method stub
		
		Products existingpro=productRepository.findById(product.getId()).orElse(null);
		  System.out.println(product);
	        if(existingpro == null) {
	            System.out.println("pro not found");
	            return  productRepository.save(product);
	        }else  {
	            existingpro.setName(product.getName());
	            existingpro.setQunty(product.getQunty());
	            existingpro.setPrice(product.getPrice());
	            existingpro.setdescrip(product.getdescrip());
	            productRepository.save(existingpro);
	        }
	        return product;
	}

	public boolean deleteProductByID(int id) {
        Products existingpro = productRepository.getById(id);
        if(existingpro != null) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

	public List<Products> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}
	
     
	

	

}
