package com.nothw.checkout.dto;

/**
 * Class describing a product/item
 */
public class Product implements Cloneable {
    /**
     * Product code
     */
    private String productCode;
    /**
     * Product name
     */
    private String name;
    /**
     * Product price
     */
    private Double price;
    /**
     * Product price after the discounts are applied
     */
    private Double discountedPrice;

    public Product(String productCode, String name, Double price) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.discountedPrice = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discountedPrice=" + discountedPrice +
                '}';
    }

    //added in order to use the same products and apply discounts on them as the "database" is mocked and a "global" list is used for all the scenarios
    @Override
    public Product clone() {
        try {
            Product clone = (Product) super.clone();
            clone.setProductCode(productCode);
            clone.setName(name);
            clone.setPrice(price);
            clone.setDiscountedPrice(discountedPrice);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
