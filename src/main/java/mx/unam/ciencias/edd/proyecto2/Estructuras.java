package mx.unam.ciencias.edd.proyecto2;
/**
 * Clase enumeracion para cosiderar todas las estructuras graficables
 */

public enum Estructuras {
    /**Arbol Binario Completo */
    AB_COMPLETO,
    /**Arbol Binario Ordenado */
    AB_ORDENADO,
    /**Arbol Binario Rojinegro */
    AB_ROJINEGRO,
    /**Arbol BInario AVL */
    AB_AVL,
    /**Cola (Graficable)*/
    COLA,
    /**Pila (Graficable)*/
    PILA,
    /**Grafica */
    GRAFICA,
    /**Lista (Graficable)*/
    LISTA,
    /**Monticulo Minimo */
    M_MINIMO,
    /**Arreglo (Graficable)*/
    ARREGLO,

    /**Valor invalido para una estructura no graficable, no seguir si se 
     * recibe este valor
     */
    INVALIDO;

    /**
     * Metodo que recibe una representacion en cadena de la estructura y la convierte a la
     * enumeracion correspondiente, regresa INVALIDO si la representacion en cadena no corresponde 
     * a alguna de las Estructuras de la enumeracion
     * @param estructura La representacion en cadena de la estructura
     * @return La enumeracion correspondiente a la Estructura
     */
    public static Estructuras getEnum(String estructura){
        switch(estructura){
            case "ArbolCompleto": return AB_COMPLETO;
            case "ArbolOrdenado": return AB_ORDENADO;
            case "ArbolRojinegro": return AB_ROJINEGRO;
            case "ArbolAVL": return AB_AVL;
            case "Cola": return COLA;
            case "Pila": return PILA;
            case "Grafica": return GRAFICA;
            case "Lista": return LISTA;
            case "MonticuloMinimo": return M_MINIMO;
            case "Arreglo" : return ARREGLO;
            default: return INVALIDO;
        }
    }


}
