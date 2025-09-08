import java.util.*;
/**
 * La clase SilkRoad simula una ruta comercial con robots que transportan "tenges"
 * y tiendas que los almacenan. También lleva el control de ganancias mediante una barra de progreso.
 * 
 * Funcionalidades principales:
 * - Colocar y remover robots y tiendas.
 * - Mover robots sobre el camino.
 * - Reabastecer tiendas.
 * - Registrar ganancias.
 * - Controlar visibilidad de los elementos.
 * 
 * @author [Tu Nombre]
 * @version 1.0
 */

public class SilkRoad {
    private int length;
    private ArrayList<Robot> robots;
    private ArrayList<Store> stores;
    private ProgressBar progress;
    private boolean lastOk;
    private String[] robotColors = {"blue", "cyan", "magenta", "black"};
    private int robotColorIndex = 0;

    private String[] storeColors = {"green", "orange", "pink", "yellow"};
    private int storeColorIndex = 0;
    
    /**
     * Constructor de SilkRoad.
     * 
     * @param length Longitud del camino (valor máximo de ubicación para robots y tiendas).
     */
    public SilkRoad(int length) {
        this.length = length;
        robots = new ArrayList<>();
        stores = new ArrayList<>();
        progress = new ProgressBar();
        progress.makeVisible();
        lastOk = true;
    }

    // ---------- Métodos de Tiendas ----------
    /**
     * Coloca una tienda en una ubicación específica con una cantidad de tenges inicial.
     * 
     * @param location Ubicación de la tienda (debe estar dentro del camino).
     * @param tenges Cantidad inicial de tenges.
     */
    
    public void placeStore(int location, int tenges) {
        if(location >= 0 && location <= length && tenges >= 0){
            Store s = new Store(location, tenges);
            String color = storeColors[storeColorIndex % storeColors.length];
            storeColorIndex++;
            s.setColor(color); 
            stores.add(s);
            s.makeVisible();
            lastOk = true;
        }else{
            lastOk = false;
        }
    }
    
    /**
     * Elimina una tienda de la ubicación dada, si existe.
     * 
     * @param location Ubicación de la tienda a eliminar.
     */
    
    public void removeStore(int location) {
        for (int i = 0; i <stores.size();i++) {
            Store s = stores.get(i);
            if (s.getLocation() == location) {
                s.makeInvisible();
                stores.remove(i);
                lastOk = true;
                return;
            }
        }
        lastOk= false;
    }
    
    /**
     * Reabastece todas las tiendas con recursos adicionales.
     */
    
    public void resupplyStores() {
        for (Store s : stores) {
            s.resupply(); 
        }
        lastOk = true;
    }

    // ---------- Métodos de Robots ----------
    
    /**
     * Coloca un robot en una ubicación específica con cierta cantidad de tenges.
     * 
     * @param location Ubicación inicial del robot (dentro del camino).
     * @param tenges Cantidad inicial de tenges del robot.
     */
    
    public void placeRobot(int location, int tenges) {
        if (location >= 0 && location <= length && tenges >= 0){
            Robot r = new Robot(location, tenges);
            String color = robotColors[robotColorIndex % robotColors.length];
            robotColorIndex++;
            r.setColor(color);
            robots.add(r);
            r.makeVisible();
            lastOk= true;
        }else{
            lastOk = false;
        }
    }

    /**
     * Elimina un robot que se encuentra en una ubicación específica.
     * 
     * @param location Ubicación del robot a eliminar.
     */
    public void removeRobot(int location) {
        for (int i = 0; i < robots.size(); i++) {
            Robot r = robots.get(i);
            if (r.getLocation() == location) {
                r.makeInvisible();
                robots.remove(i);
                lastOk = true;
                return;
            }
        }
        lastOk = false;
    }

    /**
     * Mueve un robot desde su ubicación actual una cierta cantidad de metros,
     * si la nueva ubicación está dentro de los límites del camino.
     * 
     * @param location Ubicación actual del robot.
     * @param meters Número de metros a mover (puede ser positivo o negativo).
     */
    public void moveRobot(int location, int meters) {
        for (Robot r : robots) {
            if (r.getLocation() == location) {
                    int newLocation = r.getLocation() + meters;
                    if (newLocation >= 0 && newLocation <= length) {
                        r.setLocation(newLocation);
                        lastOk = true;
            } else {
                lastOk = false;
            }
                return;
            }
        }
        lastOk = false;
    }
    
    /**
     * Reinicia completamente la simulación, eliminando todos los robots y tiendas,
     * y reinicia la barra de progreso.
     */
    public void reboot() {
        makeInvisible();
        robots.clear();
        stores.clear();
        progress = new ProgressBar();
        progress.makeVisible();
        lastOk = true;
    }

    /**
     * Ordena a todos los robots que regresen a su ubicación inicial.
     */
    public void returnRobots() {
        for (Robot r : robots) {
            r.returnRobots(); 
        }
        lastOk = true;
    }
    // ---------- Ganancias ----------
    /**
     * Método para obtener la ganancia total acumulada.
     */
    public int profit() {
        return 0;
    }
    

    // ---------- Listados ----------
    /**
     * Retorna un arreglo con la información de todas las tiendas: ubicación y tenges.
     * 
     * @return Arreglo de tiendas [[ubicación, tenges], ...]
     */
    public int[][] stores() {
        int[][] arr = new int[stores.size()][2];
        for (int i = 0; i < stores.size(); i++) {
            arr[i][0] = stores.get(i).getLocation();
            arr[i][1] = stores.get(i).getTenges();
        }
        return arr;
    }

    /**
     * Retorna un arreglo con la información de todos los robots: ubicación y tenges.
     * 
     * @return Arreglo de robots [[ubicación, tenges], ...]
     */
    public int[][] robots() {
        int[][] arr = new int[robots.size()][2];
        for (int i = 0; i < robots.size(); i++) {
            arr[i][0] = robots.get(i).getLocation();
            arr[i][1] = robots.get(i).getTenges();
        }
        return arr;
    }
    //Visibilidad
    /**
     * Hace visibles todos los elementos de la simulación (robots, tiendas y barra de progreso).
     */
    public void makeVisible() {
        for (Store s : stores){
            s.makeVisible();
        }
        for (Robot r : robots){
            r.makeVisible();
        }
        progress.makeVisible();
    }

    /**
     * Oculta todos los elementos de la simulación.
     */
    public void makeInvisible() {
        for (Store s : stores) s.makeInvisible();
        for (Robot r : robots) r.makeInvisible();
        progress.makeInvisible();
    }
    //terminacion
    /**
     * Finaliza la simulación ocultando todos los elementos.
     */
    public void finish(){
        makeInvisible();
    }
    //ok
    /**
     * Indica si la última operación realizada fue exitosa.
     * 
     * @return true si la última operación fue válida, false si ocurrió algún error.
     */
    public boolean ok(){
        return lastOk;
    }
    
}
