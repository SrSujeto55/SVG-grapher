package mx.unam.ciencias.edd.proyecto2.GraphSVG;
import mx.unam.ciencias.edd.ArbolBinarioOrdenado;

/**
 * Clase para graficar arboles binarios ordenados como SVG, extende a GraficaArbol
 */
public class GraficaABOrdenado<T extends Comparable<T>> extends GraficaArbol<T> {

    /**
     * Constructor unico para ArbolOrdenado
     * @param arbol el arbol que sera graficado
     */
    public GraficaABOrdenado(ArbolBinarioOrdenado<T> arbol, int borde) {
        super(arbol, borde);
    }
    
}
