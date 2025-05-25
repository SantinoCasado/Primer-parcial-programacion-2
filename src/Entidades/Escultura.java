package Entidades;

import java.util.Objects;

/**
Escultura (deriva de ObraArte, implementa IVendible):
Posee un único atributo propio de tipo material: MaterialEscultura, que será inicializado por su único
constructor.
MaterialEscultura es un enumerado que posee los siguientes valores: [MARMOL, BRONCE,
MADERA]


Métodos:
●getValorComercial(): método público y de instancia, que retorna un valor de tipo double,
representando el valor comercial estimado de la obra. Este valor será calculado a partir del valor base
de la obra, incrementado según el material, de acuerdo a las siguientes reglas:
● Si el material es MARMOL, se retorna el valor más un 50% adicional.
● Si el material es BRONCE, se retorna el valor más un 40% adicional.
● Si el material es MADERA, se retorna el valor más un 20% adicional.
Sobrescritura del método toString(). Retornará una cadena de caracteres conteniendo la información
completa de la escultura incluyendo su valor comercial.
Sobrescritura del método equals(), que retorna true, si el parámetro recibido es igual a la instancia
actual (ambas obras son iguales) y los materiales son iguales, false, caso contrario.
 */
public class Escultura extends ObraArte implements IVendible {
    private MaterialEscultura material;

    // Constructor que inicializa la escultura con título, valor, artista y material
    public Escultura(String titulo, double valor, Artista artista, MaterialEscultura material) {
        super(titulo, valor, artista);
        this.material = material;
    }


    // Implementación de getValorComercial()
    @Override
    public double getValorComercial() {
        if (this.material == MaterialEscultura.MARMOL) {
            return  super.valor * 1.5; // Incremento del 50%
        } else if (this.material == MaterialEscultura.BRONCE) {
            return super.valor * 1.4; // Incremento del 40%
        } else if (this.material == MaterialEscultura.MADERA) {
            return super.valor * 1.2; // Incremento del 20%
        }
        return super.valor; // En caso de no coincidir con ninguna técnica
    }
   
    // Sobrescritura de toString() para mostrar detalles de la escultura
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Material: ").append(material);
        sb.append(System.lineSeparator());
        sb.append("Valor Comercial: ").append(this.getValorComercial());
        sb.append(System.lineSeparator());
        return sb.toString();
    }

      //equals
    @Override
    public boolean equals(Object obj)
    {
        boolean esIgual = false;
        if(this == obj)
        {
            esIgual = true;
        }else if(obj != null && this.getClass() == obj.getClass())
        {
            Escultura otra = (Escultura)obj;
            if(mismaEscultura(otra))// metodo que encapsula el "if(ObraArte.sonIguales(this, escultura)&& this.material == escultura.material)" 
            {
                esIgual = true;
            }
        }
        return esIgual;
    }
    
    private boolean mismaEscultura(Escultura escultura)
    {
        boolean esIgual = false;
        if(ObraArte.sonIguales(this, escultura)&& this.material == escultura.material)
        {
            esIgual = true;
        }
        return esIgual;
    }
}
    
    