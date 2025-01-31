package patterns.strategy.model.product;

import patterns.strategy.discount.DiscountStrategy;

import java.util.HashMap;
import java.util.Map;

public class AlcoholProduct extends Product {
    private static final Map<String, Double> availableProducts = new HashMap<>();

    static {
        availableProducts.put("Wine", 30.0);
        availableProducts.put("Beer", 6.60);
        availableProducts.put("Vodka", 12.0);
        availableProducts.put("Cognac 5* ", 25.0);
        availableProducts.put("Cognac 7* ", 35.0);
    }

    public AlcoholProduct(String name, double price) {
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