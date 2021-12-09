package com.nothw.checkout.repository;

import com.nothw.checkout.dto.Product;
import com.nothw.checkout.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository designed for the product resources.
 * Local representation of the Product/Item "database". Products are stored as an Unmodifiable List.
 */
@Repository
public class ProductRepository {
    private final List<Product> products = List.of(
            new Product("001", "Travel Card Holder", 9.25D),
            new Product("002", "Personalised cufflinks", 45D),
            new Product("003", "Kids T-shirt", 19.95D));

    /**
     * Returns a list with all products
     *
     * @return
     */
    public List<Product> getAllProducts() {
        return products;
    }

    /**
     * Returns the product with the specified productCode. If the product is not present a run time exception will be thrown
     *
     * @param productCode product code
     * @return the desidered product
     */
    public Product getByProductCode(String productCode) {
        return products.stream().filter(p -> p.getProductCode().equals(productCode)).findFirst()
                .orElseThrow(ProductNotFoundException::new).clone();
        //this uses clone in order to have a fresh product for each case of the requirements as this does not use a actual database
    }
}
