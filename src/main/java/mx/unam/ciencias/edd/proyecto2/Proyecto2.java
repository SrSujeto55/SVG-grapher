package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.ArbolAVL;
import mx.unam.ciencias.edd.ArbolBinarioCompleto;
import mx.unam.ciencias.edd.ArbolBinarioOrdenado;
import mx.unam.ciencias.edd.ArbolRojinegro;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.proyecto2.GraphSVG.GrafEstructura;
import mx.unam.ciencias.edd.proyecto2.GraphSVG.GraficaABCompleto;
import mx.unam.ciencias.edd.proyecto2.GraphSVG.GraficaABOrdenado;
import mx.unam.ciencias.edd.proyecto2.GraphSVG.GraficaABRojinegro;
import mx.unam.ciencias.edd.proyecto2.GraphSVG.GraficaAVL;
import mx.unam.ciencias.edd.proyecto2.GraphSVG.GraficaArreglo;
import mx.unam.ciencias.edd.proyecto2.GraphSVG.GraficaGrafica;
import mx.unam.ciencias.edd.proyecto2.GraphSVG.GraficaLista;
import mx.unam.ciencias.edd.proyecto2.GraphSVG.GraficaMeteSaca;
import mx.unam.ciencias.edd.proyecto2.GraphSVG.GraficaMonticuloM;


/**
 * Clase principal para el proyecto 2 de EDD: Graficador de estructuras
 */
public class Proyecto2 {  
    public static void uso(){
        System.out.println("Uso: java -jar target/proyecto2 [<Nombre de archivo> | Entrada estandar]");
        System.out.println("        Formato de entrada: \n" + 
            "<Nombre de Estructura> Valor1 Valor2 Valor3 ... Valor n");
        System.exit(1);

    }

    public static void main(String[] args) {
        String nombreArcivo;
        Estructuras Estructura;
        Lista<Integer> datos;
        GrafEstructura<Integer> graficador;

        if(args.length == 1){
            EntradaE in = new EntradaE();
            nombreArcivo = args[0];
            datos = in.analiza(nombreArcivo, false);
            Estructura = Estructuras.getEnum(in.getEstructura());
        }
        else{
            EntradaE in = new EntradaE();
            datos = in.analiza("", true);
            Estructura = Estructuras.getEnum(in.getEstructura());
        }
    
        if(Estructura == Estructuras.INVALIDO){
            System.err.println("        Estructura invalida!");
        }
            

        switch(Estructura){
            case AB_COMPLETO: graficador = new GraficaABCompleto<>(new ArbolBinarioCompleto<>(datos), 20);
                break;
            case AB_ORDENADO: graficador = new GraficaABOrdenado<>(new ArbolBinarioOrdenado<>(datos), 20);
                break;
            case AB_ROJINEGRO: graficador = new GraficaABRojinegro<>(new ArbolRojinegro<>(datos), 20);
                break;
            case AB_AVL: graficador = new GraficaAVL<>(new ArbolAVL<>(datos), 20); 
                break;
            case COLA: graficador = new GraficaMeteSaca<>(datos, true);
                break;
            case PILA: graficador = new GraficaMeteSaca<>(datos, false); 
                break;
            case GRAFICA: graficador = new GraficaGrafica<>(datos);  
                break;
            case LISTA: graficador = new GraficaLista<>(datos);
                break;
            case M_MINIMO: graficador = new GraficaMonticuloM<>(datos); 
                break;
            case ARREGLO: graficador = new GraficaArreglo<>(datos); 
                 break;
            default: graficador = null;
        }

        if(graficador == null)
            uso();
        else
            System.out.println(graficador.getGrafica());   
    }
}
