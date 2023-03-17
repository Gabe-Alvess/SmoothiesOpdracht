package be.intecbrussel.Gabriel.LoveShack.mixables.fruits;

public class StrawBerry extends Fruit{
    public StrawBerry(double pricePerPiece) {
        super(pricePerPiece);
    }

    @Override
    public void mix() {
        System.out.println("Strawberry is mashed and added");
    }
}
