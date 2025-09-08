import shapes.*;
/**
 * La clase Robot representa un robot en el Camino de la Seda.
 * Cada robot tiene una posición inicial y actual, así como una cantidad de tenges que transporta.
 * Se puede mover a lo largo del camino y visualizar gráficamente mediante un círculo.
 */
public class Robot {
    private int location;
    private int initialLocation;
    private int tenges;
    private Circle circle;

    /**
     * Crea un nuevo robot en una ubicación dada con una cantidad inicial de tenges.
     * 
     * @param location La posición inicial del robot sobre el camino.
     * @param tenges   La cantidad inicial de tenges que lleva el robot.
     */
    public Robot(int location, int tenges) {
        this.location = location;
        this.initialLocation = location;
        this.tenges = tenges;
        circle = new Circle();
        circle.changeColor("blue");
        circle.moveHorizontal(location * 20- circle.getXPosition()); 
    }
    
    /**
     * Obtiene la ubicación actual del robot.
     * 
     * @return La ubicación actual sobre el camino.
     */
    public int getLocation() { return location; }
    
    /**
     * Obtiene la cantidad de tenges que lleva el robot.
     * 
     * @return Cantidad de tenges.
     */
    public int getTenges() { return tenges; }
    
    /**
     * Establece una nueva ubicación para el robot.
     * También actualiza la posición del círculo en la interfaz gráfica.
     * 
     * @param newLocation Nueva ubicación sobre el camino.
     */
    public void setLocation(int newLocation) {
        this.location = newLocation;
        circle.moveHorizontal(newLocation * 20 - circle.getXPosition());
    }
    
    /**
     * Devuelve el robot a su ubicación inicial.
     */
    public void returnRobots() {
        setLocation(initialLocation);
    }

    /**
     * Hace visible al robot.
     */
    public void makeVisible() { circle.makeVisible(); }
    
    /**
     * Hace invisible al robot.
     */
    public void makeInvisible() { circle.makeInvisible(); }
    
    /**
     * Cambia el color del robot en la interfaz gráfica.
     * 
     * @param color Nombre del color (en formato aceptado por la clase Circle).
     */
    public void setColor(String color) {
        circle.changeColor(color);
    }
}

