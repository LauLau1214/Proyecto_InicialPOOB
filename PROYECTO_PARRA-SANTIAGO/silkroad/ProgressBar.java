import shapes.*;

public class ProgressBar {
    private int profit;
    private Rectangle bar;

    public ProgressBar() {
        profit = 0;
        bar = new Rectangle();
        bar.changeColor("red");
        bar.changeSize(10, 0); // altura fija, ancho según profit
        bar.moveVertical(150); // posición en pantalla
    }

    public void updateProfit(int value) {
        profit += value;
        bar.changeSize(10, profit); // ancho proporcional
    }

    public void makeVisible() { bar.makeVisible(); }
    public void makeInvisible() { bar.makeInvisible(); }
}
