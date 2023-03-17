package be.intecbrussel.Gabriel.LoveShack.mixables.vegetables;

public class Celery extends Vegetable {
    public Celery(double pricePerPiece) {
        super(pricePerPiece);
    }

    @Override
    public void mix() {
        System.out.println("Celery is cut and added");
    }
}
