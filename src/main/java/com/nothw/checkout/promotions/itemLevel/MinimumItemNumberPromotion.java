package com.nothw.checkout.promotions.itemLevel;

import com.nothw.checkout.dto.Product;
import com.nothw.checkout.promotions.BasePromotion;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Promotional price if multiple of the same items are added
 */
public class MinimumItemNumberPromotion extends BasePromotion {
    /**
     * Product code for which the promotion is made
     */
    private String productCode;
    /**
     * Minimum items for which the promotion is active
     */
    private int minimumItems;
    /**
     * Promotional price for the product if the promotion is active
     */
    private Double promoPrice;

    public MinimumItemNumberPromotion(String productCode, int minimumItems, Double promoPrice) {
        this.productCode = productCode;
        this.minimumItems = minimumItems;
        this.promoPrice = promoPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getMinimumItems() {
        return minimumItems;
    }

    public Double getPromoPrice() {
        return promoPrice;
    }

    /**
     * Applies the promotion. If the minimum number of items is accomplished the promotion
     * is applied. The new price of the product will be the one from this promotion, will be set
     * in the discountedPrice field (this will be used to calculate the total price of the cart)
     *
     * @param products List of products in the checkout
     */
    @Override
    public void apply(List<Product> products) {
        List<Product> promoItems = products.stream().filter(product -> product.getProductCode().equals(productCode)).collect(Collectors.toList());
        //counts the items with that product code and apply the promotion if the minimum is accomplished
        if (promoItems.size() >= minimumItems) {
            promoItems.forEach(product -> product.setDiscountedPrice(promoPrice));
        }
    }
}
