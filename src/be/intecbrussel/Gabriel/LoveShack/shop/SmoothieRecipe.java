package be.intecbrussel.Gabriel.LoveShack.shop;

import be.intecbrussel.Gabriel.LoveShack.mixables.Food;
import be.intecbrussel.Gabriel.LoveShack.mixables.fruits.*;
import be.intecbrussel.Gabriel.LoveShack.mixables.vegetables.Celery;
import be.intecbrussel.Gabriel.LoveShack.mixables.vegetables.Spinach;

import java.util.stream.Stream;

public enum SmoothieRecipe {
    CITRUS(new Food[]{new Orange(1), new Orange(1), new Lemon(0.75)}),
    STRAWBERRY_DREAM(new Food[]{new StrawBerry(2), new Orange(1), new Orange(1), new Banana(1.25)}),
    BANANA_SLIDE(new Food[]{new Banana(1.25), new Banana(1.25), new Orange(1)}),
    VEGGIE_SLURRY(new Food[]{new Banana(1.25), new Celery(1), new Spinach(1.25), new Apple(0.5)}),
    CUSTOM_SMOOTHIE(new Food[]{});

    private double totalPrice;
    private Food[] recipe;

    SmoothieRecipe(Food[] recipe) {
        this.recipe = recipe;
    }

    public double getTotalPrice() {
//        totalPrice = 0;
//        for (Food food : recipe) {
//            totalPrice += food.getPricePerPiece();
//        }
//        return totalPrice;

        totalPrice = Stream.of(recipe).mapToDouble(food -> food.getPricePerPiece()).sum();
        return totalPrice;
    }

    public Food[] getRecipe() {
        return recipe;
    }

    public void setRecipe(Food[] recipe) {
//        if (recipe.length < 5 && recipe.length > 2 && recipe.equals(CUSTOM_SMOOTHIE) ) {
//            this.recipe = recipe;
//        } else if (!recipe.equals(CUSTOM_SMOOTHIE)) {
//            System.out.println("Invalid action! You can't change our recipes");
//        } else {
//            System.out.println("Invalid recipe! Please choose min 2 and max 4 ingredients");
//        }
        if (recipe.length < 2 || recipe.length > 4) {// guard clause
            return;
        }

        if (!this.name().equals("CUSTOM_SMOOTHIE")) {
            return;
        }

        this.recipe = recipe;

    }
}
