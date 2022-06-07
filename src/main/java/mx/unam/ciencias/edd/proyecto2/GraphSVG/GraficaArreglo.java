package mx.unam.ciencias.edd.proyecto2.GraphSVG;

import mx.unam.ciencias.edd.Lista;

/**Clase para graficar un arreglo en SVG, la clase implementa los metodos faltantes de
 * @GrafEstructura, la clase sera generica aunque no podamos realmente implementar
 * arreglos genericos (Supondremos que los arreglos son de tipo entero).
 */
public class GraficaArreglo<T> extends GrafEstructura<T>{

    /**El arreglo del arreglo */
    private Lista<T> array;
    /**La String que contiene todas las lineas del SVG */
    private String lineas = "";
    /**La String que contiene todos los rectangulos del SVG */
    private String rectangulos = "";
    /**La String que cotiene todos los textos del SVG */
    private String texto = "";
    /**La componente con las dimensiones de largo del archivo */
    private int xDim = 70;
    /**El desplazamiento horizontal que sera usado como offset */
    private int desplazamientoX = 20;

    /**Haciendo arreglos... con LISTAS! para evitar tener que hacer instrucciones de
     *  mas al convertir la lista a arreglo... igual esta estructura nisiquiera la implementamos 
     * como tal*/
    public GraficaArreglo(Lista<T> array){
        this.array = array;
    }

    /**
     * Sobreescribe el metodo para saber si el "arreglo" es vacio
     */
    @Override
    protected boolean esVacia() {
        return array.esVacia();
    }

    /**
     * metodo sobreescrito para devolver el graficado SVG del "Arreglo"
     */
    @Override
    protected String graficaT() {
        Calculos();
        
        return SVGraph.declaracionXML() + "\n" + 
             SVGraph.empienzaSVG(xDim, 100) + "\n" + 
             lineas + "\n" + 
             rectangulos + "\n" + 
             texto + "\n" + 
             SVGraph.finalizaSVG();
    }

    /**
     * metodo sobreescrito para devolver el graficado SVG del "Arreglo"
     * (Cuerpo Only) Este metodo unicamente debe ejecutrse si se quiere obtener SOLO el cuerpo
     */
    @Override
    protected String graficaTCuerpoOnly() {
        Calculos();

      return lineas + "\n" + 
             rectangulos + "\n" + 
             texto;
    }

    /**
     * Metodo para realizar los calculos necesarios e iniciar las variables String con sus 
     * respectivos valores
     */
    private void Calculos(){
        xDim = 40 + (array.getElementos())*30 + ((array.getElementos())-1)*20;
        int i = 1;
        for(T obj : array){
                if(i == array.getElementos()){
                rectangulos += SVGraph.creaRectacngulo(desplazamientoX, 40, 30, 
                20, "#D94F04", "#F29325");

                texto += SVGraph.creaTexto(obj.toString(), "#000000", 4,
                desplazamientoX+15, 51);
            }
            else{
                lineas += SVGraph.creaLinea(desplazamientoX + 30, 50, desplazamientoX + 50,
                 50, 2, "#007172");
                
                rectangulos += SVGraph.creaRectacngulo(desplazamientoX, 40, 30, 
                20, "#D94F04", "#F29325");

                texto += SVGraph.creaTexto(obj.toString(), "#000000", 4,
                desplazamientoX+15, 51);
                i++;
            }

            desplazamientoX+= 50;
        }
    }

    /**
     * Sobreescritura del metodo getAncho de GrafEstructura para su uso posterior en monticulos
     */
    @Override
    public int getAncho(){
        return xDim;
    }
    
    
}
