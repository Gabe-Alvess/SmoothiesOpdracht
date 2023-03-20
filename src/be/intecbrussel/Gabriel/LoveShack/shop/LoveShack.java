package be.intecbrussel.Gabriel.LoveShack.shop;

import be.intecbrussel.Gabriel.LoveShack.mixables.Food;
import be.intecbrussel.Gabriel.LoveShack.mixables.fruits.*;
import be.intecbrussel.Gabriel.LoveShack.mixables.vegetables.Celery;
import be.intecbrussel.Gabriel.LoveShack.mixables.vegetables.Spinach;

import java.util.Scanner;
import java.util.stream.Stream;

public class LoveShack {
    private SmoothieRecipe[] orders; // max 4
    private double totalPrice;
    private Orange orange;
    private StrawBerry strawberry;
    private Banana banana;
    private Apple apple;
    private Lemon lemon;
    private Spinach spinach;
    private Celery celery;

    public LoveShack() {
        this.orders = new SmoothieRecipe[4];
        this.orange = new Orange(1);
        this.strawberry = new StrawBerry(2);
        this.banana = new Banana(1.25);
        this.apple = new Apple(0.5);
        this.lemon = new Lemon(0.75);
        this.spinach = new Spinach(1.25);
        this.celery = new Celery(1);
    }

    public SmoothieRecipe[] getOrders() {
        return orders;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void order() {
        boolean spaceAvailable = false;
        System.out.println("""
                    Please place your order! (max 4 smoothies and 1 custom smoothie per order!)
                    1.Citrus (Orange and lemon)
                    2.Strawberry Dream (Strawberry, orange and banana)
                    3.Banana Slide (Banana and orange)
                    4.Veggie Slurry (Banana, celery, spinach and apple)
                    5.Custom Smoothie (minimum 2 and maximum 4 ingredients)"""
        );

        while (true) {
            spaceAvailable = false;

            for (SmoothieRecipe order : orders) {
                if (order == null) {
                    spaceAvailable = true;
                    break;
                }
            }

            if (!spaceAvailable) {
                System.out.println("You already ordered 4 smoothies. That is the limit.");
                break;
            }

            Scanner scanner = new Scanner(System.in);

            int userInput = scanner.nextInt();
            SmoothieRecipe recipe;
            switch (userInput) {
                case 1 -> recipe = SmoothieRecipe.CITRUS;
                case 2 -> recipe = SmoothieRecipe.STRAWBERRY_DREAM;
                case 3 -> recipe = SmoothieRecipe.BANANA_SLIDE;
                case 4 -> recipe = SmoothieRecipe.VEGGIE_SLURRY;
                case 5 -> recipe = SmoothieRecipe.CUSTOM_SMOOTHIE;
                default -> {
                    System.out.println("INVALID INPUT!");
                    return;
                }
            }

            if (recipe.equals(SmoothieRecipe.CUSTOM_SMOOTHIE)) {
                for (SmoothieRecipe order : orders) {
                    if (order != null && order.equals(SmoothieRecipe.CUSTOM_SMOOTHIE)) {
                        System.out.println("YOU ALREADY HAVE A CUSTOM SMOOTHIE");
                        return;
                    }
                }

                Food[] flavors = new Food[4];
                int flavorIndex = 0;

                flavors:
                while (true) {

                    if (flavorIndex > 3) {
                        break;
                    }

                    System.out.println("WHAT FLAVORS DO YOU WANT? \n" +
                            "1.apple - 2.banana - 3.lemon - 4.orange - 5.strawberry - 6.celery - 7.spinach - 8.stop");

                    int flavor = scanner.nextInt();

                    Food food;

                    switch (flavor) {
                        case 1 -> food = apple;
                        case 2 -> food = banana;
                        case 3 -> food = lemon;
                        case 4 -> food = orange;
                        case 5 -> food = strawberry;
                        case 6 -> food = celery;
                        case 7 -> food = spinach;
                        case 8 -> {
                            break flavors;
                        }
                        default -> {
                            System.out.println("WRONG INPUT");
                            return;
                        }
                    }

                    for (Food flavor1 : flavors) {
                        if (flavor1 != null && flavor1.equals(food)) {
                            System.out.println("FLAVOR ALREADY EXISTS!");
                            continue flavors;
                        }
                    }
                    flavors[flavorIndex++] = food;

                    if (flavorIndex < 2) {
                        System.out.println("TOO LITTLE FLAVOR");
                        return;
                    }

                    Food[] arrayToSet;
                    int arrToSetIndex = 0;

                    switch (flavorIndex) {
                        case 2 -> arrayToSet = new Food[2];
                        case 3 -> arrayToSet = new Food[3];
                        case 4 -> arrayToSet = new Food[4];
                        default -> {
                            return;
                        }
                    }

                    for (Food foods : flavors) {
                        if (food != null) {
                            arrayToSet[arrToSetIndex++] = food;
                        }
                    }

                    SmoothieRecipe.CUSTOM_SMOOTHIE.setRecipe(flavors);
                }
            }

            for (int i = 0; i < orders.length; i++) {
                SmoothieRecipe arrRecipe = orders[i];
                if (arrRecipe == null) {
                    orders[i] = recipe;
                    break;
                }
            }

            totalPrice += orderFromSmoothieRecipe();
            totalPrice += customOrder();

            for (SmoothieRecipe order : orders) {
                if (order == null) {
                    continue;
                }

                System.out.println(order.name());
                Stream.of(order.getRecipe())
                        .forEach(Food::mix);
            }
        }

        System.out.println("TOTAL PRICE: " + totalPrice);

    }

    private double orderFromSmoothieRecipe() {
        double total = 0;
        for (SmoothieRecipe order : orders) {
            if (order == null || order.equals(SmoothieRecipe.CUSTOM_SMOOTHIE)) {
                continue;
            }

            total += order.getTotalPrice();
        }

        return total;
    }

    private double customOrder() {
        double total = 0;
        for (SmoothieRecipe order : orders) {
            if (order == null || !order.equals(SmoothieRecipe.CUSTOM_SMOOTHIE)) {
                continue;
            }

            total += order.getTotalPrice();
        }

        return total;
    }
}
