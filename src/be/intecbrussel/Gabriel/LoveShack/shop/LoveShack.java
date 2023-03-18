package be.intecbrussel.Gabriel.LoveShack.shop;

import be.intecbrussel.Gabriel.LoveShack.mixables.fruits.*;
import be.intecbrussel.Gabriel.LoveShack.mixables.vegetables.Celery;
import be.intecbrussel.Gabriel.LoveShack.mixables.vegetables.Spinache;

import java.util.Scanner;

public class LoveShack {
    private SmoothieRecipe[] orders = new SmoothieRecipe[]{};
    private double totalPrice;
    private Orange orange;
    private StrawBerry strawBerry;
    private Banana banana;
    private Apple apple;
    private Lemon lemon;
    private Spinache spinache;
    private Celery celery;

    public LoveShack() {
    }

    public void order() {
        System.out.println("""
                Please place your order!
                1.Citrus (Orange and lemon)
                2.Strawberry Dream (Strawberry, orange and banana)
                3.Banana Slide (Banana and orange)
                4.Vegie Slurry (Banana, celery, spinache and apple)
                5.Custom Smoothie (minimum 2 and maximum 4 ingredients)"""
        );
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        while (true) {
            input = scanner.nextInt();
            while (input < 1 && input > 5) {
                System.out.println("Invalid input! Please enter 1, 2, 3, 4 or 5 to place your order.");
                input = scanner.nextInt();
            }

            switch (input) {
                case 1:
                    orders = new SmoothieRecipe[]{SmoothieRecipe.CITRUS}
            }
        }
    }

    private double orderFromSmoothieRecipe() {
        return
    }

    private double customOrder() {
        return
    }
}
