package com.nothw.checkout.controller;

import com.nothw.checkout.promotions.BasePromotion;
import com.nothw.checkout.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * Controller class used for promotion resources
 */
@RestController
@RequestMapping("/promotions")
public class PromotionsController {
    private final PromotionService promotionService;

    @Autowired
    public PromotionsController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping
    public ResponseEntity<List<BasePromotion>> getAllPromotions(){
        return ResponseEntity.ok(promotionService.getAllPromotions());
    }
}
