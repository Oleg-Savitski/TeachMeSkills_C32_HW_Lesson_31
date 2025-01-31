package patterns.strategy.model.card;

public class RegularCard extends LoyaltyCard {
    @Override
    public double applyDiscount(double price) {
        return price * 0.97;
    }
}