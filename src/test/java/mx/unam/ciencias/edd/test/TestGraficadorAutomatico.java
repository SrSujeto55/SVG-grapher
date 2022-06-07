package mx.unam.ciencias.edd.test;

import mx.unam.ciencias.edd.ArbolAVL;
import mx.unam.ciencias.edd.ArbolBinarioCompleto;
import mx.unam.ciencias.edd.ArbolBinarioOrdenado;
import mx.unam.ciencias.edd.ArbolRojinegro;
import mx.unam.ciencias.edd.proyecto2.EntradaE;
import mx.unam.ciencias.edd.proyecto2.SalidaE;
import mx.unam.ciencias.edd.proyecto2.GraphSVG.*;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class TestGraficadorAutomatico {

    @Test public void archLista(){
        EntradaE in = new EntradaE();
        SalidaE out = new SalidaE();
        GrafEstructura<Integer> lista = new GraficaLista<>(in.analiza(
            "src/test/java/mx/unam/ciencias/edd/test/Graficables/Lista.txt", false));
        try{
          out.escritura(
        "src/test/java/mx/unam/ciencias/edd/test/TestGraficados/ListaTest.svg", 
        lista.getGrafica());  

        }catch(IOException e){
            Assert.fail();
        }
    }

    @Test public void archArreglo(){
        EntradaE in = new EntradaE();
        SalidaE out = new SalidaE();
        GrafEstructura<Integer> array = new GraficaArreglo<>(in.analiza(
            "src/test/java/mx/unam/ciencias/edd/test/Graficables/Arreglo.txt", false));
        try{
          out.escritura(
        "src/test/java/mx/unam/ciencias/edd/test/TestGraficados/ArrayTest.svg", 
        array.getGrafica());  
        
        }catch(IOException e){
            Assert.fail();
        }
    }

    @Test public void archCola(){
        EntradaE in = new EntradaE();
        SalidaE out = new SalidaE();
        GrafEstructura<Integer> Cola = new GraficaMeteSaca<>(in.analiza(
            "src/test/java/mx/unam/ciencias/edd/test/Graficables/Cola.txt", false), 
            true);
        try{
          out.escritura(
        "src/test/java/mx/unam/ciencias/edd/test/TestGraficados/ColaTest.svg", 
        Cola.getGrafica());  
        
        }catch(IOException e){
            Assert.fail();
        }
    }

    @Test public void archPila(){
        EntradaE in = new EntradaE();
        SalidaE out = new SalidaE();
        GrafEstructura<Integer> Pila = new GraficaMeteSaca<>(in.analiza(
            "src/test/java/mx/unam/ciencias/edd/test/Graficables/Pila.txt", false), 
            false);
        try{
          out.escritura(
        "src/test/java/mx/unam/ciencias/edd/test/TestGraficados/PilaTest.svg", 
        Pila.getGrafica());  
        
        }catch(IOException e){
            Assert.fail();
        }
    }

    @Test public void archGrafica(){
        EntradaE in = new EntradaE();
        SalidaE out = new SalidaE();
        GrafEstructura<Integer> Graph = new GraficaGrafica<>(
            in.analiza("src/test/java/mx/unam/ciencias/edd/test/Graficables/Grafica.txt", false));
        try{
          out.escritura(
            "src/test/java/mx/unam/ciencias/edd/test/TestGraficados/GraficaTest.svg", 
        Graph.getGrafica());  
        
        }catch(IOException e){
            Assert.fail();
        }
    }

    /////////////////////////////////////Arboles///////////////////////////////////////
    @Test public void archAB_Completo(){
        EntradaE in = new EntradaE();
        SalidaE out = new SalidaE();
        GrafEstructura<Integer> AB = new GraficaABCompleto<>(
            new ArbolBinarioCompleto<>(
                in.analiza("src/test/java/mx/unam/ciencias/edd/test/Graficables/AB_Completo.txt",
                 false)),20);
        try{
          out.escritura(
            "src/test/java/mx/unam/ciencias/edd/test/TestGraficados/ABCompletoTest.svg", 
        AB.getGrafica());  
        
        }catch(IOException e){
            Assert.fail();
        }
    }

    @Test public void archAB_Ordenado(){
        EntradaE in = new EntradaE();
        SalidaE out = new SalidaE();
        GrafEstructura<Integer> AB = new GraficaABOrdenado<Integer>(new ArbolBinarioOrdenado<Integer>(
            in.analiza("src/test/java/mx/unam/ciencias/edd/test/Graficables/AB_Ordenado.txt", 
            false)
        ),20);
        try{
          out.escritura(
            "src/test/java/mx/unam/ciencias/edd/test/TestGraficados/ABOrdenadoTest.svg", 
        AB.getGrafica());  
        
        }catch(IOException e){
            Assert.fail();
        }
    }

    @Test public void archAB_Rojinegro(){
        EntradaE in = new EntradaE();
        SalidaE out = new SalidaE();
        GrafEstructura<Integer> AB = new GraficaABRojinegro<Integer>(new ArbolRojinegro<Integer>(
            in.analiza("src/test/java/mx/unam/ciencias/edd/test/Graficables/A_Rojinegro.txt", 
            false)
        ), 20);
        try{
          out.escritura(
            "src/test/java/mx/unam/ciencias/edd/test/TestGraficados/ARojinegroTest.svg", 
        AB.getGrafica());  
        
        }catch(IOException e){
            Assert.fail();
        }
    }

    @Test public void archAVL(){
        EntradaE in = new EntradaE();
        SalidaE out = new SalidaE();
        GrafEstructura<Integer> AB = new GraficaAVL<Integer>(new ArbolAVL<>(
            in.analiza("src/test/java/mx/unam/ciencias/edd/test/Graficables/AB_AVL.txt", 
            false)
        ),20);

        try{
          out.escritura(
            "src/test/java/mx/unam/ciencias/edd/test/TestGraficados/ABAVLTest.svg", 
        AB.getGrafica());  
        
        }catch(IOException e){
            Assert.fail();
        }
    }

    @Test public void archMM(){
        EntradaE in = new EntradaE();
        SalidaE out = new SalidaE();
        GrafEstructura<Integer> MM = new GraficaMonticuloM<>(
            in.analiza("src/test/java/mx/unam/ciencias/edd/test/Graficables/MonticuloMinimo.txt",
             false)
        );

        try{
          out.escritura(
            "src/test/java/mx/unam/ciencias/edd/test/TestGraficados/MonticuloMTest.svg", 
        MM.getGrafica());  
        
        }catch(IOException e){
            Assert.fail();
        }
    }
}
