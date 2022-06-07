package mx.unam.ciencias.edd.proyecto2.GraphSVG;


import mx.unam.ciencias.edd.ArbolBinarioCompleto;
import mx.unam.ciencias.edd.Coleccion;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.MonticuloMinimo;

/**
 * Clase para graficar un Monticulo Minimo con SVG, 
 */
public class GraficaMonticuloM<T extends Comparable<T>> extends GrafEstructura<T>{
    /**El arbol completo  graficar */
    private ArbolBinarioCompleto<T> AB_MM;
    /**El arreglo correspondiente al monticulo */
    private Lista<T> MM = new Lista<>();
    /**graficadores de arbol y arreglo respectivamente */
    private GrafEstructura<T> graficadorAB; 
    private GrafEstructura<T> graficadorAR;
    /**Dimensiones del SVG */
    private int ancho;
    private int largo;
    /**Strings de SVG */
    private String Arbol = "";
    private String Arreglo = "";


    public GraficaMonticuloM(Coleccion<T> data){
        AB_MM = new ArbolBinarioCompleto<>(MonticuloMinimo.heapSort(data)); 
    }

    @Override
    protected boolean esVacia() {
        return AB_MM.esVacia();
    }

    private void Calcula(){
        for(T elemento : AB_MM)
            MM.agregaFinal(elemento); 
        graficadorAB = new GraficaABCompleto<>(AB_MM, 80);
        graficadorAR = new GraficaArreglo<>(MM);
        Arbol = graficadorAB.getCuerpoOnly();
        Arreglo = graficadorAR.getCuerpoOnly();
        largo = graficadorAB.getAltura();
        ancho = graficadorAR.getAncho();
    }
    
    @Override
    protected String graficaT() {
        Calcula();
        return SVGraph.declaracionXML() + "\n" +
               SVGraph.empienzaSVG(ancho, largo) + "\n" +
               Arbol + "\n" +
               Arreglo + "\n" +
               SVGraph.finalizaSVG();
        
    }

    @Override
    protected String graficaTCuerpoOnly() {
        return Arbol + "\n" +
               Arreglo;
    }

    
}
