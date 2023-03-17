package be.intecbrussel.Gabriel.LoveShack.mixables;

public abstract class Food implements Mixable {
    private double pricePerPiece;

    public Food(double pricePerPiece) {
        this.pricePerPiece = pricePerPiece;
    }

    public double getPricePerPiece() {
        return pricePerPiece;
    }
}
