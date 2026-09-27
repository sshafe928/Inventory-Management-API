package com.studentsabrina.Inventory.Management.API.products;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping(path = "api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    
    //list all products
    
    @GetMapping
    public List<Product> getProducts(@RequestParam(required = false) String category) {

        if (category == null) {
            //returning all products
            return productService.getProducts();

        } else {
            //searching for category's
            return productService.getProductByCategory(category);
        }
    }
        

        //add products
        @PostMapping 
        public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

        @GetMapping("/{id}")
        public Product getProductById(@PathVariable long id) {
            return productService.findProductById(id);
        }

    
}
