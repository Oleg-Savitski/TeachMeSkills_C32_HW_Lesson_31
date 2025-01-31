package patterns.strategy.model.card;

public class PensionCard extends LoyaltyCard {
    @Override
    public double applyDiscount(double price) {
        return price * 0.95;
    }
}