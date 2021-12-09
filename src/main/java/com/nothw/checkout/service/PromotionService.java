package com.nothw.checkout.service;

import com.nothw.checkout.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class responsible for the promotion business logic
 */
@Service
public class PromotionService {
    private final PromotionRepository promotionRepository;

    @Autowired
    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public List getAllPromotions() {
        return promotionRepository.getAllPromotions();
    }
}
