package com.nothw.checkout.service;

import com.nothw.checkout.dto.Product;
import com.nothw.checkout.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Service class responsible for the product business logic
 */
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Returns a list with all products
     *
     * @return
     */
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getByProductCode(String productCode) {
        return productRepository.getByProductCode(productCode);
    }
}
