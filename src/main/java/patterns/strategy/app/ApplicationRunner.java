package patterns.strategy.app;

import patterns.strategy.discount.DiscountStrategy;
import patterns.strategy.discount.impl.FixedDiscountStrategy;
import patterns.strategy.discount.impl.LoyaltyDiscountStrategy;
import patterns.strategy.discount.impl.PercentageDiscountStrategy;
import patterns.strategy.exception.ProductNotFoundException;
import patterns.strategy.model.card.LoyaltyCard;
import patterns.strategy.model.card.PensionCard;
import patterns.strategy.model.card.RegularCard;
import patterns.strategy.model.product.AlcoholProduct;
import patterns.strategy.model.product.FoodProduct;
import patterns.strategy.model.product.HouseholdProduct;
import patterns.strategy.model.product.Product;

import java.util.Calendar;
import java.util.Map;
import java.util.Scanner;

/** The strategy in this program is:
 *
 * -> The user selects a card.
 * -> The user makes a purchase before 20:00 or after 20:00.
 * -> The program includes a discount system that depends on even or odd days.
 * -> Discount on groceries after 20:00.
 * -> Permanent pension discount of 5 %.
 * -> Permanent discount for individual customers on the card in the amount of 3%.
 * -> There is a discount depending on the quantity of the cost of all goods: 50 -> 100 -> 150 rub.
 * -> Discount on alcohol only if you have an individual customer's card.
 *
 *    Discounts can be combined!
 *
 */

public class ApplicationRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayOfMonth = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        System.out.println("Select a card:");
        System.out.println("1. Pension card (5% -> discount)");
        System.out.println("2. Individual card (3% -> discount)");
        System.out.println("3. No card");

        int cardChoice = scanner.nextInt();
        scanner.nextLine();

        LoyaltyCard loyaltyCard = null;

        if (cardChoice == 1) {
            loyaltyCard = new PensionCard();
        } else if (cardChoice == 2) {
            loyaltyCard = new RegularCard();
        }

        System.out.println("Select time of purchase:");
        System.out.println("1. Before 20:00 PM");
        System.out.println("2. After 20:00 PM");

        int timeChoice = scanner.nextInt();
        scanner.nextLine();

        boolean isAfter8PM = timeChoice == 2;

        System.out.println("Available products:");
        System.out.println("Food products -> " + FoodProduct.getAvailableProducts());
        System.out.println("Alcohol products -> " + AlcoholProduct.getAvailableProducts());
        System.out.println("Household products -> " + HouseholdProduct.getAvailableProducts());

        System.out.print("Enter the names of the products to purchase (separated by commas) -> ");

        String input = scanner.nextLine();
        String[] chosenProducts = input.split(",");

        double totalFinalPrice = 0.0;

        for (String productName : chosenProducts) {
            String trimmedProductName = productName.trim().toLowerCase();
            boolean productFound = false;

            try {
                for (Map.Entry<String, Double> entry : FoodProduct.getAvailableProducts().entrySet()) {
                    if (entry.getKey().toLowerCase().equals(trimmedProductName)) {
                        double price = entry.getValue();
                        Product product = new FoodProduct(entry.getKey(), price);
                        DiscountStrategy fixedDiscountStrategy = new FixedDiscountStrategy(isAfter8PM);
                        double finalPrice = fixedDiscountStrategy.applyDiscount(price);

                        if (loyaltyCard != null) {
                            DiscountStrategy loyaltyDiscountStrategy = new LoyaltyDiscountStrategy(loyaltyCard);
                            finalPrice = loyaltyDiscountStrategy.applyDiscount(finalPrice);
                        }

                        totalFinalPrice += finalPrice;
                        System.out.println("Price of " + product.getName() + " after discount -> " + finalPrice);
                        productFound = true;
                        break;
                    }
                }

                if (!productFound) {
                    for (Map.Entry<String, Double> entry : AlcoholProduct.getAvailableProducts().entrySet()) {
                        if (entry.getKey().toLowerCase().equals(trimmedProductName)) {
                            double price = entry.getValue();
                            Product product = new AlcoholProduct(entry.getKey(), price);
                            double finalPrice = price;

                            if (loyaltyCard instanceof RegularCard) {
                                DiscountStrategy loyaltyDiscountStrategy = new LoyaltyDiscountStrategy(loyaltyCard);
                                finalPrice = loyaltyDiscountStrategy.applyDiscount(finalPrice);
                            }

                            totalFinalPrice += finalPrice;
                            System.out.println("Price of " + product.getName() + " after discount -> " + finalPrice);
                            productFound = true;
                            break;
                        }
                    }
                }

                if (!productFound) {
                    for (Map.Entry<String, Double> entry : HouseholdProduct.getAvailableProducts().entrySet()) {
                        if (entry.getKey().toLowerCase().equals(trimmedProductName)) {
                            double price = entry.getValue();
                            Product product = new HouseholdProduct(entry.getKey(), price);

                            DiscountStrategy percentageDiscountStrategy = new PercentageDiscountStrategy(dayOfMonth);
                            double finalPrice = percentageDiscountStrategy.applyDiscount(price);

                            totalFinalPrice += finalPrice;
                            System.out.println("Price of " + product.getName() + " after discount -> " + finalPrice);
                            productFound = true;
                            break;
                        }
                    }
                }

                if (!productFound) {
                    throw new ProductNotFoundException("Product " + trimmedProductName + " not found.");
                }
            } catch (ProductNotFoundException e) {
                System .out.println(e.getMessage());
            }
        }
        scanner.close();

        System.out.println("Total cost of products after discounts -> " + totalFinalPrice);
    }
}