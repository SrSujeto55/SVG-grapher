package mx.unam.ciencias.edd;

import java.util.Iterator;
import java.util.NoSuchElementException;

//import mx.unam.ciencias.edd.ArbolBinario.Vertice;

/**
 * Clase para gráficas. Una gráfica es un conjunto de vértices y aristas, tales
 * que las aristas son un subconjunto del producto cruz de los vértices.
 */
public class Grafica<T> implements Coleccion<T> {

    /* Clase interna privada para iteradores. */
    private class Iterador implements Iterator<T> {

        /* Iterador auxiliar. */
        private Iterator<Vertice> iterador;

        /* Construye un nuevo iterador, auxiliándose de la lista de vértices. */
        public Iterador() {
            // Aquí va su código.
            iterador = vertices.iterator();
        }

        /* Nos dice si hay un siguiente elemento. */
        @Override public boolean hasNext() {
            // Aquí va su código.
            return iterador.hasNext();
        }

        /* Regresa el siguiente elemento. */
        @Override public T next() {
            // Aquí va su código.
            return iterador.next().elemento;
        }
    }

    /* Clase interna privada para vértices. */
    private class Vertice implements VerticeGrafica<T> {

        /* El elemento del vértice. */
        private T elemento;
        /* El color del vértice. */
        private Color color;
        /* La lista de vecinos del vértice. */
        private Lista<Vertice> vecinos;

        /* Crea un nuevo vértice a partir de un elemento. */
        public Vertice(T elemento) {
            // Aquí va su código.
            this.elemento = elemento;
            this.color = Color.NINGUNO;
            vecinos = new Lista<Vertice>();
        }

        /* Regresa el elemento del vértice. */
        @Override public T get() {
            // Aquí va su código.
            return elemento;
        }

        /* Regresa el grado del vértice. */
        @Override public int getGrado() {
            // Aquí va su código.
            return vecinos.getElementos();
        }

        /* Regresa el color del vértice. */
        @Override public Color getColor() {
            // Aquí va su código.
            return color;
        }

        /* Regresa un iterable para los vecinos. */
        @Override public Iterable<? extends VerticeGrafica<T>> vecinos() {
            // Aquí va su código.
            return vecinos;
        }
    }

    /* Vértices. */
    private Lista<Vertice> vertices;
    /* Número de aristas. */
    private int aristas;

    /**
     * Constructor único.
     */
    public Grafica() {
        // Aquí va su código.
        vertices = new Lista<Vertice>();
    }

    /**
     * Regresa el número de elementos en la gráfica. El número de elementos es
     * igual al número de vértices.
     * @return el número de elementos en la gráfica.
     */
    @Override public int getElementos() {
        // Aquí va su código.
        return vertices.getElementos();
    }

    /**
     * Regresa el número de aristas.
     * @return el número de aristas.
     */
    public int getAristas() {
        // Aquí va su código.
        return aristas;
    }

    /**
     * Agrega un nuevo elemento a la gráfica.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si el elemento ya había sido agregado a
     *         la gráfica.
     */
    @Override public void agrega(T elemento) {
        // Aquí va su código.
        if(elemento == null)
            throw new IllegalArgumentException();
        
        if(contiene(elemento))
            throw new IllegalArgumentException();

        Vertice nuevo = new Vertice(elemento);

        vertices.agregaFinal(nuevo);
    }

    //Metodo auxilir para ver si un elemento a esta contenido en la grafica
    private Vertice contieneAux(Lista<Vertice> ls, T a){
        for(Vertice n : ls){
            if(n.elemento.equals(a))
                return n;
        }  
        return null;
    }

    /**
     * Conecta dos elementos de la gráfica. Los elementos deben estar en la
     * gráfica. El peso de la arista que conecte a los elementos será 1.
     * @param a el primer elemento a conectar.
     * @param b el segundo elemento a conectar.
     * @throws NoSuchElementException si a o b no son elementos de la gráfica.
     * @throws IllegalArgumentException si a o b ya están conectados, o si a es
     *         igual a b.
     */
    public void conecta(T a, T b) {
        // Aquí va su código.
        Vertice A = contieneAux(vertices, a);
        Vertice B = contieneAux(vertices, b); 
        if(A == null || B == null)
            throw new NoSuchElementException();

        if(a == b)
            throw new IllegalArgumentException();
        
        if(sonVecinos(a, b))
            throw new IllegalArgumentException();
        
        A.vecinos.agregaFinal(B);
        B.vecinos.agregaFinal(A);

        aristas++;
    }

    /**
     * Desconecta dos elementos de la gráfica. Los elementos deben estar en la
     * gráfica y estar conectados entre ellos.
     * @param a el primer elemento a desconectar.
     * @param b el segundo elemento a desconectar.
     * @throws NoSuchElementException si a o b no son elementos de la gráfica.
     * @throws IllegalArgumentException si a o b no están conectados.
     */
    public void desconecta(T a, T b) {
        // Aquí va su código.
        Vertice A = contieneAux(vertices, a);
        Vertice B = contieneAux(vertices, b); 

        if(A == null || B == null)
            throw new NoSuchElementException();

        if(!sonVecinos(a, b))
            throw new IllegalArgumentException();

        B.vecinos.elimina(A);
        A.vecinos.elimina(B);

        aristas--;
    }

    /**
     * Nos dice si el elemento está contenido en la gráfica.
     * @return <code>true</code> si el elemento está contenido en la gráfica,
     *         <code>false</code> en otro caso.
     */
    @Override public boolean contiene(T elemento) {
        // Aquí va su código.
        for(Vertice n : vertices){
            if(n.elemento.equals(elemento))
                return true;
        }
        return false;
    }

    /**
     * Elimina un elemento de la gráfica. El elemento tiene que estar contenido
     * en la gráfica.
     * @param elemento el elemento a eliminar.
     * @throws NoSuchElementException si el elemento no está contenido en la
     *         gráfica.
     */
    @Override public void elimina(T elemento) {
        // Aquí va su código.
        Vertice A = contieneAux(vertices, elemento);

        if(A == null)
            throw new NoSuchElementException();
        
        vertices.elimina(A);

        for(Vertice n : A.vecinos){
            n.vecinos.elimina(A);
            aristas--;
        }
    }

    /**
     * Nos dice si dos elementos de la gráfica están conectados. Los elementos
     * deben estar en la gráfica.
     * @param a el primer elemento.
     * @param b el segundo elemento.
     * @return <code>true</code> si a y b son vecinos, <code>false</code> en otro caso.
     * @throws NoSuchElementException si a o b no son elementos de la gráfica.
     */
    public boolean sonVecinos(T a, T b) {
        // Aquí va su código.
        Vertice A = contieneAux(vertices, a);
        Vertice B = contieneAux(vertices, b);

        if(A == null || B == null)
            throw new NoSuchElementException();
        
        return A.vecinos.contiene(B) && B.vecinos.contiene(A);
    }   

    /**
     * Regresa el vértice correspondiente el elemento recibido.
     * @param elemento el elemento del que queremos el vértice.
     * @throws NoSuchElementException si elemento no es elemento de la gráfica.
     * @return el vértice correspondiente el elemento recibido.
     */
    public VerticeGrafica<T> vertice(T elemento) {
        // Aquí va su código.
        Vertice E = contieneAux(vertices, elemento);

        if(E == null)
            throw new NoSuchElementException();
        
        VerticeGrafica<T> Vertice = E;

        return Vertice;
    }

    /**
     * Define el color del vértice recibido.
     * @param vertice el vértice al que queremos definirle el color.
     * @param color el nuevo color del vértice.
     * @throws IllegalArgumentException si el vértice no es válido.
     */
    public void setColor(VerticeGrafica<T> vertice, Color color) {
        // Aquí va su código.
        if(vertice.getClass() != Vertice.class)
            throw new IllegalArgumentException();

        Vertice verticeV = (Vertice)vertice;

        verticeV.color = color;
    }

    /**
     * Nos dice si la gráfica es conexa.
     * @return <code>true</code> si la gráfica es conexa, <code>false</code> en
     *         otro caso.
     */
    public boolean esConexa() {
        // Aquí va su código.
        paraCadaVertice((n) -> setColor(n, Color.ROJO)); //Coloreamos todos los vertices de Rojo
        Cola<Vertice> q = new Cola<Vertice>();

        Vertice primero = vertices.getPrimero();

        q.mete(primero);
        setColor(primero, Color.NEGRO);

        while(!q.esVacia()){
            Vertice v = q.saca();
            for(Vertice n : v.vecinos){
                if(n.color == Color.ROJO){
                   setColor(n, Color.NEGRO);
                   q.mete(n); 
                }
            }
        }

        for(Vertice n : vertices){
            if(n.color == Color.ROJO)
                return false;
        }
        return true;
    }

    /**
     * Realiza la acción recibida en cada uno de los vértices de la gráfica, en
     * el orden en que fueron agregados.
     * @param accion la acción a realizar.
     */
    public void paraCadaVertice(AccionVerticeGrafica<T> accion) {
        // Aquí va su código.
        for(Vertice n : vertices){
            accion.actua(n);
        }
    }

    /**
     * Realiza la acción recibida en todos los vértices de la gráfica, en el
     * orden determinado por BFS, comenzando por el vértice correspondiente al
     * elemento recibido. Al terminar el método, todos los vértices tendrán
     * color {@link Color#NINGUNO}.
     * @param elemento el elemento sobre cuyo vértice queremos comenzar el
     *        recorrido.
     * @param accion la acción a realizar.
     * @throws NoSuchElementException si el elemento no está en la gráfica.
     */
    public void bfs(T elemento, AccionVerticeGrafica<T> accion) {
        // Aquí va su código.
        Vertice A = contieneAux(vertices, elemento);
        
        if(A == null)
            throw new NoSuchElementException();
            
        paraCadaVertice((n) -> setColor(n, Color.ROJO)); //Coloreamos todos los vertices de Rojo
        
        Cola<Vertice> q = new Cola<Vertice>();
        q.mete(A);
        setColor(A, Color.NEGRO);

        while(!q.esVacia()){
            Vertice v = q.saca();
            accion.actua(v);

            for(Vertice n : v.vecinos){
                if(n.color == Color.ROJO){
                    q.mete(n);
                    setColor(n, Color.NEGRO);
                }
            }
        }

        paraCadaVertice((n) -> setColor(n, Color.NINGUNO));
    }

    /**
     * Realiza la acción recibida en todos los vértices de la gráfica, en el
     * orden determinado por DFS, comenzando por el vértice correspondiente al
     * elemento recibido. Al terminar el método, todos los vértices tendrán
     * color {@link Color#NINGUNO}.
     * @param elemento el elemento sobre cuyo vértice queremos comenzar el
     *        recorrido.
     * @param accion la acción a realizar.
     * @throws NoSuchElementException si el elemento no está en la gráfica.
     */
    public void dfs(T elemento, AccionVerticeGrafica<T> accion) {
        // Aquí va su código.
        Vertice B = contieneAux(vertices, elemento);
        
        if(B == null)
            throw new NoSuchElementException();
            
        paraCadaVertice((n) -> setColor(n, Color.ROJO)); //Coloreamos todos los vertices de Rojo
        
        Pila<Vertice> p = new Pila<Vertice>();
        p.mete(B);
        setColor(B, Color.NEGRO);

        while(!p.esVacia()){
            Vertice v = p.saca();
            accion.actua(v);

            for(Vertice n : v.vecinos){
                if(n.color == Color.ROJO){
                    p.mete(n);
                    setColor(n, Color.NEGRO);
                }
            }
        }

        paraCadaVertice((n) -> setColor(n, Color.NINGUNO));
    }

    /**
     * Nos dice si la gráfica es vacía.
     * @return <code>true</code> si la gráfica es vacía, <code>false</code> en
     *         otro caso.
     */
    @Override public boolean esVacia() {
        // Aquí va su código.
        return vertices.esVacia();
    }

    /**
     * Limpia la gráfica de vértices y aristas, dejándola vacía.
     */
    @Override public void limpia() {
        // Aquí va su código.
        vertices.limpia();
        aristas = 0;
    }

    /**
     * Regresa una representación en cadena de la gráfica.
     * @return una representación en cadena de la gráfica.
     */
    @Override public String toString() {
        // Aquí va su código.
        String s = "{";

        for(Vertice n : vertices)
            s += String.format("%s, ", n.elemento);
        
        s += "}, {";

        paraCadaVertice((n) -> setColor(n, Color.ROJO));
        for(Vertice v : vertices){
            for(Vertice n : v.vecinos){
                if(n.color == Color.ROJO)
                s += String.format("(%s, %s), ", v.elemento, n.elemento);
            }
            setColor(v, Color.NEGRO);
        }
        s += "}";
        return s;
    }

    /**
     * Nos dice si la gráfica es igual al objeto recibido.
     * @param objeto el objeto con el que hay que comparar.
     * @return <code>true</code> si la gráfica es igual al objeto recibido;
     *         <code>false</code> en otro caso.
     */
    @Override public boolean equals(Object objeto) {
        if (objeto == null || getClass() != objeto.getClass())
            return false;
        @SuppressWarnings("unchecked") Grafica<T> grafica = (Grafica<T>)objeto;
        // Aquí va su código.
        if(getElementos() != grafica.getElementos())
            return false;
        if(getAristas() != grafica.getAristas())
            return false;

        for(Vertice n : vertices){
            if(!grafica.contiene(n.elemento))
                return false;
        }

        for(Vertice n : vertices){
            for(Vertice v : n.vecinos){
                if(!grafica.sonVecinos(n.elemento, v.elemento))
                    return false;
            }
        }

        return true;
    }

    /**
     * Regresa un iterador para iterar la gráfica. La gráfica se itera en el
     * orden en que fueron agregados sus elementos.
     * @return un iterador para iterar la gráfica.
     */
    @Override public Iterator<T> iterator() {
        return new Iterador();
    }
}
