package com.studentsabrina.Inventory.Management.API.products;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product){
        Optional<Product> existing = 
            productRepository.findBySku(product.getSku());

            if (existing.isPresent()) {
                Product oldProduct = existing.get();

                oldProduct.setAmount(
                    oldProduct.getAmount() + product.getAmount()
                );

                return productRepository.save(oldProduct);
            }

            return productRepository.save(product);

            }

    public Product findProductById(long id){
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getProductByCategory(String category){
        return productRepository.findByCategory(category);
    }

            
    }
