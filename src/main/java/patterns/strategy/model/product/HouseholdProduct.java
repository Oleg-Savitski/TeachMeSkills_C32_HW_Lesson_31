package patterns.strategy.model.product;

import patterns.strategy.discount.DiscountStrategy;

import java.util.HashMap;
import java.util.Map;

public class HouseholdProduct extends Product {
    private static final Map<String, Double> availableProducts = new HashMap<>();

    static {
        availableProducts.put("Cleaning Agent", 5.50);
        availableProducts.put("Wipes", 2.20);
        availableProducts.put("Shampoo", 15.0);
        availableProducts.put("Soap", 1.0);
        availableProducts.put("Diapers", 30.0);
    }

    public HouseholdProduct(String name, double price) {
        super(name, price);
    }

    public static Map<String, Double> getAvailableProducts() {
        return availableProducts;
    }

    @Override
    public double getFinalPrice(DiscountStrategy discountStrategy) {
        return discountStrategy.applyDiscount(price);
    }
}