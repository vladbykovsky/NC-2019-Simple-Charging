package com.example.backend.controller;

import com.example.backend.entity.Product;
import com.example.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductByName(@PathVariable(name = "name") String name){
        Product product = productService.findByName(name);
        return ResponseEntity.ok(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@PathVariable(name = "id") Integer id){
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()){
            return ResponseEntity.ok(product.get());
        }else {
            return  ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Product> getAllUsers() {
        return (List<Product>) productService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable(name = "id") Integer id) { productService.deleteProduct(id); }

}
