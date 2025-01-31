package patterns.strategy.discount.impl;

import patterns.strategy.discount.DiscountStrategy;

/**
 *  Discount by day. Even days - odd days
 */
public class PercentageDiscountStrategy implements DiscountStrategy {
    private final int dayOfMonth;

    public PercentageDiscountStrategy(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    @Override
    public double applyDiscount(double price) {
        double discountPercentage = 0;

        if (dayOfMonth % 2 == 0) {
            if (price >= 150) {
                discountPercentage = 20;
            } else if (price >= 100) {
                discountPercentage = 15;
            } else if (price >= 50) {
                discountPercentage = 10;
            }
        } else {
            if (price >= 150) {
                discountPercentage = 15;
            } else if (price >= 100) {
                discountPercentage = 10;
            } else if (price >= 50) {
                discountPercentage = 5;
            }
        }

        return price - (price * discountPercentage / 100);
    }
}
