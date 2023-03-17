package be.intecbrussel.Gabriel.LoveShack.mixables.fruits;

public class Apple extends Fruit {
    public Apple(double pricePerPiece) {
        super(pricePerPiece);
    }

    @Override
    public void mix() {
        System.out.println("Apple is mashed and added");
    }
}
