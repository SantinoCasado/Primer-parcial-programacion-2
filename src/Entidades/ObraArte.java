package Entidades;
import java.util.Objects;
import java.util.Random;

/**
ObraArte:
Esta clase no podrá instanciarse y todos sus atributos son protegidos:
    ● artista: Artista.
    ● cantidadDeElementos: int.
    ● titulo: String.
    ● valor: double.
    ● generadorDeElementos: Random (atributo de clase)

Posee un bloque estático (que inicializará el atributo generadorDeElementos) y constructores de instancia para inicializar los siguientes atributos:
    ● (titulo, valor, artista)
    ● (titulo, valor, nombre, apellido)

Cómo métodos tendrá:
    ● getCantidadDeElementos(), retornará el valor correspondiente del atributo cantidadDeElementos,
que se inicializará en dicha propiedad, si y sólo si, su valor es cero. Para inicializar dicho atributo,
se utilizará el atributo estático generadorDeElementos(valores aleatorios entre 1 y 10).
    ● El método privado y de clase mostrar(ObraArte), retorna una cadena detallando todos los
atributos del parámetro de tipo ObraArte que recibe.
    ● sonIguales(ObraArte, ObraArte), método de clase que retorna true, si al comparar dos objetos de
tipo ObraArte, los títulos y artistas son iguales, false, caso contrario.
    ● Implementar interface Comparable<T> tal que la clase implemente su método compareTo(T): int
que permitirá definir como orden natural de comparación el título de las obras.
    ● Sobrescritura del método equals(), que retorna true, si al comparar dos objetos de tipo ObraArte,
los títulos y artistas son iguales, false, caso contrario.
    ● Sobrescritura del método toString(), retornará el detalle del título, artista y cantidad de elementos
de la obra.
 */
public class ObraArte implements Comparable<ObraArte>{
    //Atributos
    protected Artista artista;
    protected int cantidadDeElementos;
    protected String titulo;
    protected double valor;
    protected static Random generadorDeElementos;
    
    //Bloque estatico para inicializar el random
    static {
        generadorDeElementos = new Random(); 
    }
    
    //Constructor con Artista como objeto
    public ObraArte(String titulo, double valor, Artista artista) {
        this.titulo = titulo;
        this.valor = valor;
        this.artista = artista;
    }
    
    // Constructor con nombre y apellido, reutilizando el primero
    public ObraArte(String titulo, double valor, String nombre, String apellido) {
        this(titulo, valor, new Artista(nombre, apellido)); // Reutiliza el otro constructor
    }
    
    //getCantidadDeElementos()
    public int getCantidadDeElementos(){
        if (cantidadDeElementos == 0) {
           cantidadDeElementos = generadorDeElementos.nextInt(10) + 1;      //Sumo uno para incluir el 10
        }
        return cantidadDeElementos;
    }
    
    //mostrar(ObraArte)
    public String mostrar(ObraArte obraArte) {
        StringBuilder sb = new StringBuilder();
        sb.append("Titulo: ").append(obraArte.titulo);
        sb.append(System.lineSeparator());
        sb.append("Artista: ").append(obraArte.artista);
        sb.append(System.lineSeparator());
        sb.append("Cantidad de Elementos: ").append(obraArte.cantidadDeElementos);
        sb.append(System.lineSeparator());
        
        return sb.toString();
    }
    
    //sonIguales
    public static boolean sonIguales(ObraArte o1, ObraArte o2){
        boolean esIgual = false;
        if(Artista.sonIguales(o1.artista, o2.artista) && o1.titulo.equals(o2.titulo))
        {
            esIgual = true;
        }
        return esIgual;
    }
    
     //compareTo
    @Override
    public int compareTo(ObraArte obraArte) {
        return this.titulo.compareTo(obraArte.titulo);
    }
     
    //equals
    @Override
    public boolean equals(Object obj){
        boolean esIgual = false;
        if(this == obj)
        {
            esIgual = true;
        }else if(obj != null && this.getClass() == obj.getClass())
        {
            ObraArte otra = (ObraArte)obj;
            //if(this.titulo.equals(otra.titulo) && Artista.sonIguales(this.artista, otra.artista))
            if(ObraArte.sonIguales(this,otra))
            {
                esIgual = true;
            }
        }
        return esIgual;
    }
    
    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ObraArte");
        sb.append(System.lineSeparator());
        sb.append("  - Artista: ").append(artista.getNombreApellido());
        sb.append(System.lineSeparator());
        sb.append("  - cantidadDeElementos: ").append(cantidadDeElementos);
        sb.append(System.lineSeparator());
        sb.append("  - titulo: ").append(titulo);
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    public String getTitulo() {
        return titulo;
    }
    
}
    
