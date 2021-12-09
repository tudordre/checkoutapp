package com.nothw.checkout.promotions;


import com.nothw.checkout.dto.Product;

import java.util.List;

public abstract class BasePromotion {
    public abstract void apply(List<Product> products);
}
