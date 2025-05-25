package Entidades;

/**
Pintura (deriva de ObraArte, implementa IVendible):
Posee un único atributo tecnica: TecnicaPintura, que será inicializado por su único constructor.

Métodos:
●getValorComercial(): método público y de instancia, que retorna un valor de tipo double,
representando el valor comercial estimado de la obra. Este valor será calculado a partir del valor base
de la obra, incrementado según la técnica, de acuerdo a las siguientes reglas:
● Si la técnica es OLEO, se retorna el valor más un 30% adicional.
● Si la técnica es ACRILICO, se retorna el valor más un 20% adicional.
● Si la técnica es ACUARELA, se retorna el valor más un 10% adicional.
Sobrescritura del método toString(). Retornará una cadena de caracteres conteniendo la información
completa de la pintura incluyendo su valor comercial.
Sobrescritura del método equals(), que retorna true, si el parámetro recibido es igual a la instancia
actual (ambas obras son iguales) y las técnicas son iguales, false, caso contrario.
 */

public class Pintura extends ObraArte implements IVendible {
    private TecnicaPintura tecnica;

    // Constructor que inicializa la pintura con título, valor, artista y técnica
    public Pintura(String titulo, double valor, String nombre, String apellido, TecnicaPintura tecnica) {
        super(titulo, valor, nombre, apellido);
        this.tecnica = tecnica;
    }
    
    //getValorComercial
    @Override
    public double getValorComercial() {
        if (this.tecnica == TecnicaPintura.OLEO) {
            return super.valor * 1.3; // Incremento del 30%
        } else if (this.tecnica == TecnicaPintura.ACRILICO) {
            return super.valor * 1.2; // Incremento del 20%
        } else if (this.tecnica == TecnicaPintura.ACUARELA) {
            return super.valor * 1.1; // Incremento del 10%
        }
        return super.valor; // En caso de no coincidir con ninguna técnica
    }

    // Sobrescritura de toString() usando StringBuilder para mostrar detalles de la pintura
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Tecnica: ").append(this.tecnica);
        sb.append(System.lineSeparator());
        sb.append("Valor Comercial: ").append(this.getValorComercial());
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    
    // Sobrescritura de equals() para comparar pinturas por título, artista y técnica
    @Override
    public boolean equals(Object obj)
    {
        boolean esIgual = false;
        if(this == obj)
        {
            esIgual = true;
        }else if(obj != null && this.getClass() == obj.getClass())
        {
            Pintura otra = (Pintura)obj;
            if(mismaPintura(otra)) // metodo que encapsula el "if(ObraArte.sonIguales(this, pintura)&& this.tecnica == pintura.tecnica)" 
            {
                esIgual = true;
            }
        }
        return esIgual;
    }
    
    private boolean mismaPintura(Pintura pintura){
        boolean esIgual = false;
        if(ObraArte.sonIguales(this, pintura)&& this.tecnica == pintura.tecnica)
        {
            esIgual = true;
        }
        return esIgual;
    }

}    