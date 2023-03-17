package be.intecbrussel.Gabriel.LoveShack.shop;

import be.intecbrussel.Gabriel.LoveShack.mixables.Food;
import be.intecbrussel.Gabriel.LoveShack.mixables.fruits.*;
import be.intecbrussel.Gabriel.LoveShack.mixables.vegetables.Celery;
import be.intecbrussel.Gabriel.LoveShack.mixables.vegetables.Spinache;

public enum SmoothieRecipe {
    CITRUS(new Food[]{new Orange(1), new Orange(1), new Lemon(0.75)}),
    STRAWBERRY_DREAM(new Food[]{new StrawBerry(2), new Orange(1), new Orange(1), new Banana(1.25)}),
    BANANA_SLIDE(new Food[]{new Banana(1.25), new Banana(1.25), new Orange(1)}),
    VEGIE_SLURRY(new Food[]{new Banana(1.25), new Celery(1), new Spinache(1.25), new Apple(0.5)}),
    CUSTOM_SMOOTHIE(new Food[]{});

    private double totalPrice;
    private Food[] recipe;

    SmoothieRecipe(Food[] recipe) {
        this.recipe = recipe;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Food[] getRecipe() {
        return recipe;
    }

    public void setRecipe(Food[] recipe) {
        if (recipe.length < 5 && recipe.length > 2 && recipe.equals(CUSTOM_SMOOTHIE) ) {
            this.recipe = recipe;
        } else if (!recipe.equals(CUSTOM_SMOOTHIE)) {
            System.out.println("Invalid action! You can't change our recipes");
        } else {
            System.out.println("Invalid recipe! Please choose min 2 and max 4 ingredients");
        }

    }
}
