package be.intecbrussel.Gabriel.LoveShack.mixables.vegetables;

public class Spinach extends Vegetable {
    public Spinach(double pricePerPiece) {
        super(pricePerPiece);
    }

    @Override
    public void mix() {
        System.out.println("Spinach is mashed and added");
    }
}
