package be.intecbrussel.Gabriel.LoveShack.shop;

import be.intecbrussel.Gabriel.LoveShack.mixables.Food;
import be.intecbrussel.Gabriel.LoveShack.mixables.fruits.*;
import be.intecbrussel.Gabriel.LoveShack.mixables.vegetables.Celery;
import be.intecbrussel.Gabriel.LoveShack.mixables.vegetables.Spinach;

import java.util.Scanner;

public class LoveShack {
    private SmoothieRecipe[] orders = new SmoothieRecipe[]{};
    private double totalPrice;
    private final Orange orange = new Orange(1);
    private final StrawBerry strawBerry = new StrawBerry(2);
    private final Banana banana = new Banana(1.25);
    private final Apple apple = new Apple(0.5);
    private final Lemon lemon = new Lemon(0.75);
    private final Spinach spinach = new Spinach(1.25);
    private final Celery celery = new Celery(1);

    public LoveShack() {
    }

    public SmoothieRecipe[] getOrders() {
        return orders;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void order() {
        Scanner scanner = new Scanner(System.in);
        int input;
        int stopInput = 0;
        int smoothieCount = 0;
        int customSmoothieCount = 0;
        Food[] customRecipe = new Food[]{};

        System.out.println("""
                Please place your order! (max 4 smoothies and 1 custom smoothie per order!)
                1.Citrus (Orange and lemon)
                2.Strawberry Dream (Strawberry, orange and banana)
                3.Banana Slide (Banana and orange)
                4.Veggie Slurry (Banana, celery, spinach and apple)
                5.Custom Smoothie (minimum 2 and maximum 4 ingredients)"""
        );

        while (true) {
            input = scanner.nextInt();

            if (smoothieCount == 4) {
                System.out.println("Maximum 4 smoothies per order! Do you want to add a custom smoothie? (1.Yes | 2.No)");
                stopInput = scanner.nextInt();

                if (stopInput == 1) {
                    System.out.println("Please enter '5' to add a custom smoothie!");
                    continue;
                } else if (stopInput == 2) {
                    System.out.println("Order successfully placed!\n");
                    break;
                } else {
                    System.out.println("Invalid input! Try again.");
                    stopInput = scanner.nextInt();
                }
            }

            switch (input) {
                case 1:
                    smoothieCount++;
                    orders = new SmoothieRecipe[]{SmoothieRecipe.CITRUS};
                    System.out.println("Order successfully placed!");
                    break;
                case 2:
                    smoothieCount++;
                    orders = new SmoothieRecipe[]{SmoothieRecipe.STRAWBERRY_DREAM};
                    System.out.println("Order successfully placed!");
                    break;
                case 3:
                    smoothieCount++;
                    orders = new SmoothieRecipe[]{SmoothieRecipe.BANANA_SLIDE};
                    System.out.println("Order successfully placed!");
                    break;
                case 4:
                    smoothieCount++;
                    orders = new SmoothieRecipe[]{SmoothieRecipe.VEGGIE_SLURRY};
                    System.out.println("Order successfully placed!");
                    break;
                case 5:
                    customSmoothieCount++;

                    if (customSmoothieCount > 1) {
                        System.out.println("Maximum 1 custom smoothie per order! Please choose one of our recipes.");
                        break;
                    }

                    int customSmoothieInput = 0;

                    System.out.println("""
                            Please choose minimum 2 and maximum 4 ingredients from the list below.
                            1.Orange
                            2.Lemon
                            3.Banana
                            4.Strawberry
                            5.Apple
                            6.Celery
                            7.Spinach"""
                    );


                    while (customRecipe.length < 4) {
                        customSmoothieInput = scanner.nextInt();

                        if (customRecipe.length == 2) {
                            System.out.println("Do you want to add more ingredients? (1.Yes | 2.No)");
                            stopInput = scanner.nextInt();
                        }

                        if (stopInput == 1) {
                            System.out.println("Two more ingredients to go!");
                            continue;
                        } else if (stopInput == 2) {
                            break;
                        } else {
                            System.out.println("Invalid input! Try again.");
                            stopInput = scanner.nextInt();
                        }

                        switch (customSmoothieInput){
                            case 1:
                                orange.mix();
                                customRecipe = new Food[]{orange};
                                break;
                            case 2:
                                lemon.mix();
                                customRecipe = new Food[]{lemon};
                                break;
                            case 3:
                                banana.mix();
                                customRecipe = new Food[]{banana};
                                break;
                            case 4:
                                strawBerry.mix();
                                customRecipe = new Food[]{strawBerry};
                                break;
                            case 5:
                                apple.mix();
                                customRecipe = new Food[]{apple};
                                break;
                            case 6:
                                celery.mix();
                                customRecipe = new Food[]{celery};
                                break;
                            case 7:
                                spinach.mix();
                                customRecipe = new Food[]{spinach};
                                break;
                            default:
                                System.out.println("Invalid input! Please enter a number between 1 and 7.");
                        }
                    }
                    System.out.println("Custom order successfully placed!");
                    SmoothieRecipe.CUSTOM_SMOOTHIE.setRecipe(customRecipe);
                break;
                default:
                    System.out.println("Invalid input! Please enter a number between 1 and 5.");
            }

            if (orders.length == 5) {
                System.out.println("Maximum of 5 orders reached!\n");
                break;
            }
        }
        int i = 1;
        for (SmoothieRecipe order: orders) {
            System.out.println("Your orders:\n" + i + "." + order.toString().toLowerCase());
            i++;
        }
    }

    private double orderFromSmoothieRecipe() {
        return 2.2;
    }

    private double customOrder() {
        return 2.2;
    }
}
