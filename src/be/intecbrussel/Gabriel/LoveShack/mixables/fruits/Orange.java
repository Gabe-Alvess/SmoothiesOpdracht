package be.intecbrussel.Gabriel.LoveShack.mixables.fruits;

public class Orange extends Fruit {
    public Orange(double pricePerPiece) {
        super(pricePerPiece);
    }

    @Override
    public void mix() {
        System.out.println("Orange is pressed and added");
    }


}
