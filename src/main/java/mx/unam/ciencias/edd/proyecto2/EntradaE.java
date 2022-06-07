package mx.unam.ciencias.edd.proyecto2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import mx.unam.ciencias.edd.Lista;

/**
 * Clase para leer y escribir sobre la entrada estandar
 */

public class EntradaE {

    /**La estructura leida*/
    private String Estructura;
    /**
     * constructor unico sin parametros
     */
    public EntradaE(){}

    /**regresa la Estructura */
    public String getEstructura(){
        return Estructura;
    }

/**
     * Lectura de un archivo
     * @param archivo el archivo a leer
     * @return Una lista con todas las lineas
     */
    private String lecturaArch(String nombreArchivo){

    String OrdenLinea = "";
    File doc = new File(nombreArchivo);
    BufferedReader in;

        if(doc.exists()){
            try{
                in = new BufferedReader(new FileReader(doc));
                try{
                    OrdenLinea = carga(in);
                in.close();
                }catch(IOException e){
                    throw new FileNotFoundException("Ocurrio un error al intentar leer el archivo");
                }
            }catch(FileNotFoundException F){
                System.err.printf("cannot read: \"%s\": No such path or directory.\n",
                nombreArchivo);
                System.exit(1);
            }
            return OrdenLinea;
        }

        try {
            FileInputStream fileIn = new FileInputStream(nombreArchivo);
            InputStreamReader isIn = new InputStreamReader(fileIn);
            in = new BufferedReader(isIn);

            OrdenLinea = carga(in);
            in.close();
        } catch (IOException IEe) {
            System.err.printf("cannot read: \"%s\": No such file or directory.\n",
                              nombreArchivo);
            System.exit(1);
        }
          return OrdenLinea;
    }

    private String lecturaEstandar(){
        String linea = "";
        try{
          BufferedReader br = new BufferedReader(
                          new InputStreamReader(System.in));
          linea = carga(br);
        } catch(IOException e){}

        return linea;
    }

    /**
     * Carga linea por linea dentro de una lista todas las lineas del flujo de lectura recibido
     * @param in El flujo de lectura recibido
     * @return una Lista con todas las lineas del archivo leido
     * @throws IOException
     */
    private static String carga(BufferedReader in) 
    throws IOException{
    
    String s = "";
        String linea;
        while( (linea = in.readLine()) != null){
            linea.strip();
            if(linea.contains("#"))
                continue;
            s += linea.strip() + " ";
        }
        return s.strip();
    } 

    /**
     * Analiza la entrada recibida y la convierte a una lista
     * NO incluye el nombre de la Estructura, pero si inicializa la variable 
     * @link Estructura a el String correspondiente en la entrada 1;
     * @param nombreArchivo El nombre del archivo a leer
     * @param E Un booleano que nos dice si se trata de lectura estandar o no;
     * @return La lista con los valores de la estructura
     */
    public Lista<Integer> analiza(String nombreArchivo, boolean E){
        Lista<Integer> datos = new Lista<>();
        String linea = E ? lecturaEstandar() : lecturaArch(nombreArchivo);
        String[] parts = linea.split(" ");

        try{
            for(int i=1; i<parts.length; i++){
                datos.agregaFinal(Integer.parseInt(parts[i]));
            }
            Estructura = parts[0];
        }catch(NumberFormatException e){
            System.err.println("Se ha violado el formato de entrada, por favor, introduce valores enteros: \n" + 
            "<Nombre de Estructura> Valor1 Valor2 Valor3 ... Valor n");
            System.exit(1);
        }
        
        return datos;
    }

    // No hay escritura.
}
