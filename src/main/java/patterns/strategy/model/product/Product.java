package patterns.strategy.model.product;

import patterns.strategy.discount.DiscountStrategy;

public abstract class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract double getFinalPrice(DiscountStrategy discountStrategy);

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}