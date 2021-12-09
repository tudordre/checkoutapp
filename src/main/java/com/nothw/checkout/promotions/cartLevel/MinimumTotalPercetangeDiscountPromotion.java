package com.nothw.checkout.promotions.cartLevel;

import com.nothw.checkout.dto.Product;
import com.nothw.checkout.promotions.BasePromotion;

import java.util.List;

/**
 * Percentage Discount applied based on the total amount of the cart.
 */
public class MinimumTotalPercetangeDiscountPromotion extends BasePromotion {
    /**
     * Minimum total amount for which the promotion is active
     */
    private Double minimumTotal;

    /**
     * Percentage discount applied to all cart elements
     */
    private Double discount;

    public MinimumTotalPercetangeDiscountPromotion(Double minimumTotal, Double discount) {
        this.minimumTotal = minimumTotal;
        this.discount = discount;
    }

    public Double getMinimumTotal() {
        return minimumTotal;
    }

    public void setMinimumTotal(Double minimumTotal) {
        this.minimumTotal = minimumTotal;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    /**
     * Applies the promotion. If the total amount is bigger than the required the promotion
     * is applied. The new price of each product will be reduced by X% (which is defined by the promotion),
     * will be set the discountedPrice field (this will be used to calculate the total price of the cart)
     * for each product in the checkout
     *
     * @param products List of products in the checkout
     */
    @Override
    public void apply(List<Product> products) {
        //calculates the remaining value in percents after the discount is done. 10% discount => the actual price will be 90% of the one displayed
        var appliedDiscount = 1D - discount / 100;

        //total price for all products
        var total = products.stream().mapToDouble(Product::getDiscountedPrice).sum();

        //if total amount is bigger than the minimum for the cart then apply the percentage discount
        if (total >= minimumTotal) {
            products.forEach(product -> product.setDiscountedPrice(product.getDiscountedPrice() * appliedDiscount));
        }
    }
}
