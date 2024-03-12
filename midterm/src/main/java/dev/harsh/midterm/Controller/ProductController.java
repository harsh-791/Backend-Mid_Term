package dev.harsh.midterm.Controller;

import dev.harsh.midterm.DTO.FakeStoreDto;
import dev.harsh.midterm.Models.Product;
import dev.harsh.midterm.Services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    ProductService ps;
    ProductController(ProductService ps){
        this.ps = ps;
    }

    @GetMapping("/products")
    public FakeStoreDto[] getAllProducts(){
        return ps.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public FakeStoreDto getProductById(@PathVariable Long id){
        return ps.getProductById(id);
    }

    @PostMapping("/product/")
    public Product createProduct(@RequestBody Product product){
        return ps.createProduct(product);
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@RequestBody Product product,@PathVariable Long id){
        return ps.updateProduct(product,id);
    }

    @DeleteMapping("/products/delete/{id}")
    public FakeStoreDto deleteProduct(@PathVariable Long id){
        return ps.deleteProduct(id);
    }



}
