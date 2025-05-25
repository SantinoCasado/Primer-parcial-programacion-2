package Entidades;

/**
TecnicaPintura es un enumerado que posee los siguientes valores: [OLEO, ACRILICO, ACUARELA]
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
public enum TecnicaPintura {
    //Elementos
    OLEO, 
    ACRILICO, 
    ACUARELA;
    
}

