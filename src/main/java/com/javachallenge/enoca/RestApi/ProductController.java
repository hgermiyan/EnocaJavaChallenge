package com.javachallenge.enoca.RestApi;

import com.javachallenge.enoca.Business.ProductService;
import com.javachallenge.enoca.Entities.Customer;
import com.javachallenge.enoca.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/GetProduct/{id}")
    public Product getProduct(@PathVariable int id) {
        return this.productService.productDal.getProduct(id);
    }

    @PostMapping("/CreateProduct")
    public void createProduct(@RequestBody Product product) {
        this.productService.productDal.createProduct(product);
    }

    @PostMapping("/UpdateProduct")
    public void updateProduct(@RequestBody Product product) {
        this.productService.productDal.updateProduct(product);
    }

    @PostMapping("/DeleteProduct")
    public void deleteProduct(@RequestBody Product product) {
        this.productService.productDal.deleteProduct(product);
    }

}
