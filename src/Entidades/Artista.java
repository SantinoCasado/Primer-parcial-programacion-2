package Entidades;

/**
Artista:
Posee todos sus atributos privados nombre: String y apellido: String.

- Un único constructor que inicializa dichos atributos y métodos:
- sonIguales(Artista , Artista): Retornará true, si los nombres y los apellidos son iguales, false, caso contrario. Este método será público y estático.
- getNombreApellido(): Este método público y de instancia, retornará una cadena de caracteres 
que contenga el nombre y apellido del artista, separados por guiones medios. Ej.: Pablo - Picasso.
 */
public class Artista {
    //Atributos
    private String nombre;
    private String apellido;
    
    //Constructor
    public Artista(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    //sonIguales
    public static boolean sonIguales(Artista artista1, Artista artista2){
        return artista1.nombre.equals(artista2.nombre) &&                       //Si tanto los nombres y apellidos de las dos clases de artistas son iguales son iguales o no
               artista1.apellido.equalsIgnoreCase(artista2.apellido);
    }
    
    //Getters
    public String getNombreApellido(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(this.getNombre()).append(" - ");
        sb.append("Apellido: ").append(this.getApellido());
        sb.append(System.lineSeparator());
        
        return sb.toString();
    }
    
    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

}
