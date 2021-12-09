package com.nothw.checkout.checkout;

import com.nothw.checkout.dto.Product;
import com.nothw.checkout.promotions.BasePromotion;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that holds the entire checkout (products and promotions)
 */
public class CheckoutComputation {
    private List<Product> products = new ArrayList<>();
    private List<BasePromotion> promotions;

    public CheckoutComputation(List<BasePromotion> promotions) {
        this.promotions = promotions;
    }

    public void scan(Product product) {
        products.add(product);
    }

    /**
     * Calculates the total amount for the current products and promotions
     * @return
     */
    public Double total() {
        //promotions are applied in chain/pipeline, one at a time. Used Chain of Responsability Design Pattern.
        promotions.forEach(promotion -> promotion.apply(products));

        double total = products.stream().mapToDouble(Product::getDiscountedPrice).sum();
        //calculated the total and made a rounding
        return Math.ceil(Math.round(total * 100)) / 100;
    }
}
