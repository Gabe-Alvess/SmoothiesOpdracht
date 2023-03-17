package be.intecbrussel.Gabriel.LoveShack.mixables.vegetables;

public class Spinache extends Vegetable {
    public Spinache(double pricePerPiece) {
        super(pricePerPiece);
    }

    @Override
    public void mix() {
        System.out.println("Spinache is mashed and added");
    }
}
