package mx.unam.ciencias.edd.test;

import mx.unam.ciencias.edd.ArbolAVL;
import mx.unam.ciencias.edd.ArbolBinarioCompleto;
import mx.unam.ciencias.edd.ArbolBinarioOrdenado;
import mx.unam.ciencias.edd.ArbolRojinegro;
import mx.unam.ciencias.edd.proyecto2.EntradaE;
import mx.unam.ciencias.edd.proyecto2.GraphSVG.*;
import org.junit.Test;

public class TestGraficadorAutomatico {

    @Test public void archLista(){
        EntradaE in = new EntradaE();
        GrafEstructura<Integer> lista = new GraficaLista<>(in.analiza(
            "src/test/java/mx/unam/ciencias/edd/test/Graficables/Lista.txt", false));
            System.out.println(lista.getGrafica());
    }

    @Test public void archArreglo(){
        EntradaE in = new EntradaE();
        GrafEstructura<Integer> array = new GraficaArreglo<>(in.analiza(
            "src/test/java/mx/unam/ciencias/edd/test/Graficables/Arreglo.txt", false));
        System.out.println(array.getGrafica());
    }

    @Test public void archCola(){
        EntradaE in = new EntradaE();
        GrafEstructura<Integer> Cola = new GraficaMeteSaca<>(in.analiza(
            "src/test/java/mx/unam/ciencias/edd/test/Graficables/Cola.txt", false), 
            true);
        System.out.println(Cola.getGrafica());
    }

    @Test public void archPila(){
        EntradaE in = new EntradaE();
        GrafEstructura<Integer> Pila = new GraficaMeteSaca<>(in.analiza(
            "src/test/java/mx/unam/ciencias/edd/test/Graficables/Pila.txt", false), 
            false);
        System.out.println(Pila.getGrafica());
    }

    @Test public void archGrafica(){
        EntradaE in = new EntradaE();
        GrafEstructura<Integer> Graph = new GraficaGrafica<>(
            in.analiza("src/test/java/mx/unam/ciencias/edd/test/Graficables/Grafica.txt", false));
        System.out.println(Graph.getGrafica());
    }

    /////////////////////////////////////Arboles///////////////////////////////////////
    @Test public void archAB_Completo(){
        EntradaE in = new EntradaE();
        GrafEstructura<Integer> AB = new GraficaABCompleto<>(
            new ArbolBinarioCompleto<>(
                in.analiza("src/test/java/mx/unam/ciencias/edd/test/Graficables/AB_Completo.txt",
                 false)),20);
        System.out.println(AB.getGrafica());
    }

    @Test public void archAB_Ordenado(){
        EntradaE in = new EntradaE();
        GrafEstructura<Integer> AB = new GraficaABOrdenado<Integer>(new ArbolBinarioOrdenado<Integer>(
            in.analiza("src/test/java/mx/unam/ciencias/edd/test/Graficables/AB_Ordenado.txt", 
            false)
        ),20);
        System.out.println(AB.getGrafica());
    }

    @Test public void archAB_Rojinegro(){
        EntradaE in = new EntradaE();
        GrafEstructura<Integer> AB = new GraficaABRojinegro<Integer>(new ArbolRojinegro<Integer>(
            in.analiza("src/test/java/mx/unam/ciencias/edd/test/Graficables/A_Rojinegro.txt", 
            false)
        ), 20);
        System.out.println(AB.getGrafica());
    }

    @Test public void archAVL(){
        EntradaE in = new EntradaE();
        GrafEstructura<Integer> AB = new GraficaAVL<Integer>(new ArbolAVL<>(
            in.analiza("src/test/java/mx/unam/ciencias/edd/test/Graficables/AB_AVL.txt", 
            false)
        ),20);
        System.out.println(AB.getGrafica());
    }

    @Test public void archMM(){
        EntradaE in = new EntradaE();
        GrafEstructura<Integer> MM = new GraficaMonticuloM<>(
            in.analiza("src/test/java/mx/unam/ciencias/edd/test/Graficables/MonticuloMinimo.txt",
             false)
        );
        System.out.println(MM.getGrafica());
    }
}
