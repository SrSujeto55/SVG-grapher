package mx.unam.ciencias.edd.proyecto2.GraphSVG;

import mx.unam.ciencias.edd.Cola;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.Pila;
import mx.unam.ciencias.edd.MeteSaca;

/**
 * Clase para graficar Colas en SVG, la clase implementa los metodos faltantes de
 * @link{GrafEstructura}
 */
public class GraficaMeteSaca<T> extends GrafEstructura<T> {

    /**Boolean para saber si trabajamos con Q o con S */
    boolean Q;
    private MeteSaca<T> M;
    /**Las dimensiones horiontales de la cola */
    private int xDim = 100;
    /**Las dimensiones verticales de la pila */
    private int yDim = 100;
    /**Variable para conocer el tamano de la pila/cola */
    private int elementos;
    /**Variable String para guardar las lineas SVG */
    private String lineas = "";
    /**Variable String para guardar los rectangulos SVG */
    private String rectangulos = "";
    /**Variable String para guardar el texto SVG */
    private String texto = "";
    /**esplazamiento vertica u horizontal usado como offset */
    private int desplazamientoXY = 20;

    /**
     * Constructor unico para la clase GraficaMeteSaca
     * @param data una lista con los elementos de la pila/cola
     * @param Q un booeano que nos dice si se quiere graficar una cola, false para una pila
     */
    public GraficaMeteSaca(Lista<T> data, boolean Q){
        this.Q = Q;
        M = Q ? new Cola<T>() : new Pila<>();

        for(T val : data)
            M.mete(val);
        elementos = data.getElementos();
    }

    /**
     * Nos dice si la cola esta vacia
     */
    @Override
    protected boolean esVacia() {
        return M.esVacia();
    }

    /**
     * Regresa un String representacion de la cola o pila para su graficacion en SVG
     */
    @Override
    protected String graficaT() {
        if(Q)
            CalculosCola();
        else
            CalculosPila();

        return SVGraph.declaracionXML() + "\n" +
                   SVGraph.empienzaSVG(xDim, yDim) + "\n" +
                   lineas + "\n" +
                   rectangulos + "\n" +
                   texto + "\n" +
                   SVGraph.finalizaSVG();
        
    }

    /**
     * Regresa un String representacion de la cola o pila para su graficacion en SVG
     * (Cuerpo Only) Este metodo unicamente debe ejecutrse si se quiere obtener SOLO el cuerpo
     */
    @Override
    protected String graficaTCuerpoOnly() {
        if(Q)
            CalculosCola();
        else
            CalculosPila();

        return lineas + "\n" +
                   rectangulos + "\n" +
                   texto;
    }

    /**
     * Hace los calculos necesarios para un SVG de Pila
     */
    private void CalculosPila(){
        yDim = 40 + (elementos)*20 + ((elementos)-1)*10;

        lineas += SVGraph.creaLinea(25, 18, 25, yDim-18, 4, "#007172");
        lineas += SVGraph.creaLinea(75, 18, 75, yDim-18, 4, "#007172");
        lineas += SVGraph.creaLinea(23, yDim-18, 77, yDim-18, 4, "#007172");


        while(!M.esVacia()){
            T elem = M.saca();
            
            rectangulos += SVGraph.creaRectacngulo(35, desplazamientoXY, 30, 
            20, "#D94F04", "#F29325");

            texto += SVGraph.creaTexto(elem.toString(), "#000000", 4,
            50, desplazamientoXY+11);

        desplazamientoXY+= 30;
        }
    }

    /**
     * Hace los calculos necesarios para un SVG de Cola
     */
    private void CalculosCola(){
        xDim = 40 + (elementos)*30 + ((elementos)-1)*20;

        lineas += SVGraph.creaLinea(18, 30, xDim - 18, 30, 4, "#007172");
        lineas += SVGraph.creaLinea(18, 70, xDim - 18, 70, 4, "#007172");

        while(!M.esVacia()){
            T elem = M.saca();
            
            rectangulos += SVGraph.creaRectacngulo(desplazamientoXY, 40, 30, 
            20, "#D94F04", "#F29325");

            texto += SVGraph.creaTexto(elem.toString(), "#000000", 4,
            desplazamientoXY+15, 51);

        desplazamientoXY+= 50;
        }
                
    
    }
    
}
