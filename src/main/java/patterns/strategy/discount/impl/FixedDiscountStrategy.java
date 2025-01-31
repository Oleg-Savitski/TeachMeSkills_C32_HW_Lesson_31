package patterns.strategy.discount.impl;

import patterns.strategy.discount.DiscountStrategy;

/**
 * Fixed discount. It is provided only after 20:00 and when buying food products.
 */

public class FixedDiscountStrategy implements DiscountStrategy {
    private final boolean isAfter8PM;

    public FixedDiscountStrategy(boolean isAfter8PM) {
        this.isAfter8PM = isAfter8PM;
    }

    @Override
    public double applyDiscount(double price) {
        if (isAfter8PM) {
            return price * 0.8;
        } else {
            return price;
        }
    }
}