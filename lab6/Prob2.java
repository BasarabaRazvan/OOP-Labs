public class Prob2 {
    public static void main(String[] args) {
        Rectangle o1 = new Rectangle();
        Rectangle o2 = new Square();

        Square aux = new Square();
        if(aux instanceof Rectangle) {
            Rectangle rect = (Rectangle) aux;
        }
        if(aux instanceof Shape) {
            Shape s = (Shape) aux;
        }

        //Conversie 1
        //Circle c1 = new Circle();
        //Square sq = (Square) c1;
        Square sq;
        //Conversie 2
        Rectangle r = new Square(5.0);
        sq = (Square) r;
        //Conversie 3
        sq = new Square(7.0);
        r = sq;
    }
}