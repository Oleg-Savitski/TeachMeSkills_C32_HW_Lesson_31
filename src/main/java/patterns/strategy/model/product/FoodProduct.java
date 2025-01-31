package patterns.strategy.model.product;

import patterns.strategy.discount.DiscountStrategy;

import java.util.HashMap;
import java.util.Map;

public class FoodProduct extends Product {
    private static final Map<String, Double> availableProducts = new HashMap<>();

    static {
        availableProducts.put("Pizza", 15.0);
        availableProducts.put("Salad", 5.30);
        availableProducts.put("Soup", 3.20);
        availableProducts.put("Pie", 12.40);
        availableProducts.put("Pasta", 10.0);
    }

    public FoodProduct(String name, double price) {
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