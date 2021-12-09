package com.nothw.checkout.controller;

import com.nothw.checkout.repository.ProductRepository;
import com.nothw.checkout.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Controller class used for product resources
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
