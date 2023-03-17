package be.intecbrussel.Gabriel.LoveShack.mixables.fruits;

public class Banana extends Fruit {
    public Banana(double pricePerPiece) {
        super(pricePerPiece);
    }

    @Override
    public void mix() {
        System.out.println("Banana is mashed and added");
    }
}
