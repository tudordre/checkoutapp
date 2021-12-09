package com.nothw.checkout.repository;


import com.nothw.checkout.promotions.BasePromotion;
import com.nothw.checkout.promotions.cartLevel.MinimumTotalPercetangeDiscountPromotion;
import com.nothw.checkout.promotions.itemLevel.MinimumItemNumberPromotion;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository designed for the promotion resources.
 * Local representation of the Promotion "database". Promotions are stored as an Unmodifiable List.
 */
@Repository
public class PromotionRepository {
    private final List<BasePromotion> promotions = List.of(
            new MinimumItemNumberPromotion("001", 2, 8.5D),
            new MinimumTotalPercetangeDiscountPromotion(60D, 10D)
    );

    /**
     * Returns a list with all the promotions
     *
     * @return
     */
    public List getAllPromotions() {
        return promotions;
    }
}
