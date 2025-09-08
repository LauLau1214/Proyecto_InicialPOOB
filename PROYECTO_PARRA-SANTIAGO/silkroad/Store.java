import shapes.*;
/**
 * La clase Store representa una tienda en el Camino de la Seda.
 * Cada tienda tiene una ubicación fija y una cantidad de tenges disponible,
 * que puede reabastecerse a su cantidad inicial.
 * Se visualiza gráficamente como un cuadrado.
 */
public class Store {
    private int location;
    private int tenges;
    private int initialTenges;
    private Rectangle square;

    /**
     * Crea una tienda en una ubicación dada con una cantidad inicial de tenges.
     * 
     * @param location Posición de la tienda sobre el camino.
     * @param tenges   Cantidad inicial de tenges disponibles en la tienda.
     */
    public Store(int location, int tenges) {
        this.location = location;
        this.tenges = tenges;
        this.initialTenges = tenges;
        square = new Rectangle();
        square.changeColor("green");
        square.moveHorizontal(location * 20 - square.getXPosition());
    }
    
    /**
     * Reabastece la tienda con su cantidad inicial de tenges.
     */
    public void resupply() {
        this.tenges = initialTenges;
    }
    
    /**
     * Obtiene la ubicación de la tienda.
     * 
     * @return La ubicación sobre el camino.
     */
    public int getLocation() { return location; }
    
    /**
     * Obtiene la cantidad actual de tenges en la tienda.
     * 
     * @return Cantidad de tenges disponible.
     */
    public int getTenges() { return tenges; }

    /**
     * Hace visible la tienda .
     */
    public void makeVisible() { square.makeVisible(); }
    
    /**
     * Hace invisible la tienda.
     */
    public void makeInvisible() { square.makeInvisible(); }
    
     /**
     * Cambia el color de la tienda en la interfaz gráfica.
     * 
     * @param color Nombre del color (en formato aceptado por la clase Rectangle).
     */
    public void setColor(String color) {
        square.changeColor(color);
    }
}
