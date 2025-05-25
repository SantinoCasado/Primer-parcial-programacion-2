package Entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
Dicha clase posee dos atributos, ambos privados. Uno indicará la capacidad máxima que tendrá el
museo para almacenar obras (capacidad: int). El otro es una colección de tipo ObraArte “obras” (Elegir
la colección que crean correspondiente).
El constructor por defecto sin parámetros será el único que inicializará la colección de obras y
establecerá la capacidad máxima en 3 obras, la sobrecarga recibirá un entero con la capacidad.

Métodos de instancia:
● sonIguales(ObraArte), retornará true, si es que la obra ya se encuentra en el museo, false, caso
contrario.
● agregar(ObraArte), si el museo posee capacidad de almacenar al menos una obra más y dicha obra
no se encuentra en el museo, la agrega a la colección, caso contrario, informará lo acontecido.
● Método privado y de instancia getValor(TipoValor), retornará el valor de las obras del museo de
acuerdo con el enumerado que recibe como parámetro.
● Método público ordenar(), no retornará nada. Internamente ordenará su colección de obras según el
orden natural de las mismas.

Métodos públicos y de instancia:
● getValorDePinturas(): retorna valor de tipo double que representa el valor total de todas las
pinturas.
● getValorDeEsculturas(): retorna valor de tipo double que representa el valor total de todas las
esculturas.
● getValorTotal() , retorna valor de tipo double que representa el valor total de todas las obras del
museo.
El método público de clase mostrar(Museo), retorna un String con toda la información del museo que
recibe cómo parámetro, incluyendo la cantidad y el detalle de cada una de sus obras.
 */

public class Museo {
    //Atributos
    private int capacidad;
    private List<ObraArte> obras;
    
    //Constructores
    public Museo(){
        this.capacidad = 3;
        this.obras = new ArrayList<>();
    }
    
    public Museo(int capacidad) {
        this();
        this.capacidad = capacidad;
    }
    
    
    //Metodo sonIguales
    public boolean sonIguales(ObraArte obra) {
        return obras.contains(obra);
    }
    
    
    //Metodo agregar
    public void agregar(ObraArte obra) {
        if (obras.size() >= capacidad) {
            System.out.println("El museo está lleno, no se puede agregar: " + obra.getTitulo());
        }
        if (sonIguales(obra)) {
            System.out.println("Ya está en el museo: " + obra.getTitulo());
        } else {
            obras.add(obra);
            System.out.println("Obra agregada: " + obra.getTitulo());
        }
    }

    public void ordenar() {
        Collections.sort(obras);
    }
    
    //Metodo getValorDePinturas()
    public double getValorDePinturas() {
        double total = 0;
        
        for (ObraArte obra : obras) {
            if (obra instanceof Pintura) {
                total += ((Pintura) obra).getValorComercial();
            }
        }
        return total;
    }
    
    //Metodo getValorDeEsculturas
    public double getValorDeEsculturas() {
        double total = 0;
        
        for (ObraArte obra : obras) {
            if (obra instanceof Escultura) {
                total += ((Escultura) obra).getValorComercial();
            }
        }
        return total;
    }
    
   //Metodo getValorTotal
    public double getValorTotal() {
        double total = 0;
        
        for (ObraArte obra : obras) {
            total += ((IVendible) obra).getValorComercial();
        }
        return total;
    }
    
    //Metodo mostrar
    public static String mostrar(Museo museo) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Museo con capacidad: " ).append(museo.capacidad);
        sb.append(System.lineSeparator());
        
        sb.append("Obras: " );
        for (ObraArte obra : museo.obras) {
            sb.append(obra.toString());
            sb.append(System.lineSeparator()); 
        }
        
        sb.append("Valor total de pinturas: $").append(museo.getValorDePinturas());
        sb.append(System.lineSeparator());
        sb.append("Valor total de esculturas: $").append(museo.getValorDeEsculturas());
        sb.append(System.lineSeparator());
        sb.append("Valor total del museo: $").append(museo.getValorTotal());
        sb.append(System.lineSeparator());
        
        return sb.toString();
    }


}

