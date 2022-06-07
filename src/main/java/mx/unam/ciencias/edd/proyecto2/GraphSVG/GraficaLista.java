package mx.unam.ciencias.edd.proyecto2.GraphSVG;


import mx.unam.ciencias.edd.Lista;

/**
 * Clase para graficar una lista con SVG, la clase implementa los metodos faltantes de
 * @GrafEstructura
 */
public class GraficaLista<T> extends GrafEstructura<T>{

    /**La lista a graficar */
    private Lista<T> listaGraficable;
    /**La cantidad de pixeles en el eje X */
    private int xDim;
    /**String con las flechas */
    private String lineas = "";
    /**String con los rectangulos */
    private String rectangulos = "";
    /**String con el texto */
    private String texto = "";
    /**DEsplazamiento horizontal usado como offset */
    private int desplazamientoX = 20;
    /**el numero de elementos en la lista para evitar mandar a llamar al metodo n veces*/
    private int elementos;

    /**
     * constructor unico para pasar una lista a graficar
     * @param lista La lista a graficar
     */
    public GraficaLista(Lista<T> lista){
        listaGraficable = lista;
        elementos = listaGraficable.getElementos();
    }

    @Override
    protected boolean esVacia() {
        return listaGraficable.esVacia();
    }

    /**
     * Metodo para regresar la cadena constructora SVG
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
     * Metodo para regresar la cadena constructora SVG
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
        xDim = 40 + (listaGraficable.getElementos())*30 + ((listaGraficable.getElementos())-1)*20;
        int i = 1;
        for(T obj : listaGraficable){
                if(i == elementos){
                rectangulos += SVGraph.creaRectacngulo(desplazamientoX, 40, 30, 
                20, "#D94F04", "#F29325");

                texto += SVGraph.creaTexto(obj.toString(), "#000000", 4,
                desplazamientoX+15, 51);
            }
            else{
                lineas += SVGraph.creaFlecha(desplazamientoX+35, 50, desplazamientoX+45, 
                "#007172", true);
                
                rectangulos += SVGraph.creaRectacngulo(desplazamientoX, 40, 30, 
                20, "#D94F04", "#F29325");

                texto += SVGraph.creaTexto(obj.toString(), "#000000", 4,
                desplazamientoX+15, 51);
                i++;
            }

            desplazamientoX+= 50;
        }
    }
}
