/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.modelo;

/**
 * Enum que se usa para guardar los tipos de reservas que hay. 
 * He pensado que es la solución más conveniente, ya estas modalidades
 * no son tan diferentes de Reserva como para hacer una herencia.
 * 
 * @author dominguez.vamar21
 * @version 1.0
 * @since 1.0
 *
 */
public enum Tipo {
	
	media("Media Hora"), hora("Una hora"), horaYMedia("Hora y media");
	
	
	 private final String texto;
	    
	 /**
	   * Constructor para poder mostrar el texto de cada Enum en el formulario
	   * de reserva.
	   */
	 
	    private Tipo(String texto) {
	        this.texto = texto;
	    }
	    
	    public String getTexto() {
	        return texto;
	    }

}
