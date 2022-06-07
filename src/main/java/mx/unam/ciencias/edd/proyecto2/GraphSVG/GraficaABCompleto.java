package mx.unam.ciencias.edd.proyecto2.GraphSVG;

import mx.unam.ciencias.edd.ArbolBinarioCompleto;

/**
 * Clase para graficar arboles completos con SVG, extende a GraficaArbol
 */
public class GraficaABCompleto<T> extends GraficaArbol<T>{

    /**
     * Constructor unico que recibe un arbol Binario Completo.
     * @param arbol el Arbol binario completo a graficar
     */
    public GraficaABCompleto(ArbolBinarioCompleto<T> arbol, int borde) {
        super(arbol, borde);
        
    }
        
}
