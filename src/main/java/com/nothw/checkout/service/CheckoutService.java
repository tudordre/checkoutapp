package com.nothw.checkout.service;

import com.nothw.checkout.checkout.CheckoutComputation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class responsible for the checkout business logic
 */
@Service
public class CheckoutService {
    private final ProductService productService;
    private final PromotionService promotionService;

    @Autowired
    public CheckoutService(ProductService productService, PromotionService promotionService) {
        this.productService = productService;
        this.promotionService = promotionService;
    }

    public Double createCheckout(String productCodes) {
        List<String> productCodesList = Arrays.stream(productCodes.split(",")).collect(Collectors.toList());

        CheckoutComputation checkout = new CheckoutComputation(promotionService.getAllPromotions());
        productCodesList.forEach(productCode -> checkout.scan(productService.getByProductCode(productCode)));

        return checkout.total();
    }
}
