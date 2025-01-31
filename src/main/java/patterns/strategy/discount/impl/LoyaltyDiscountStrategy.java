package patterns.strategy.discount.impl;

import patterns.strategy.discount.DiscountStrategy;
import patterns.strategy.model.card.LoyaltyCard;

/** Providing discounts on cards.
 * Pension and individual benefits.
 */

public class LoyaltyDiscountStrategy implements DiscountStrategy {
    private final LoyaltyCard loyaltyCard;

    public LoyaltyDiscountStrategy(LoyaltyCard loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }

    @Override
    public double applyDiscount(double price) {
        return loyaltyCard.applyDiscount(price);
    }
}