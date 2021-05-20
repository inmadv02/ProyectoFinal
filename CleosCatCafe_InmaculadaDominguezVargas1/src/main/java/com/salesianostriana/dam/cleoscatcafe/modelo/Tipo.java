/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.modelo;

/**
 * @author PC
 *
 */
public enum Tipo {
	
	media("Media Hora"), hora("Una hora"), horaYMedia("Hora y media");
	
	 private final String texto;
	    
	    private Tipo(String texto) {
	        this.texto = texto;
	    }
	    
	    public String getTexto() {
	        return texto;
	    }

}
