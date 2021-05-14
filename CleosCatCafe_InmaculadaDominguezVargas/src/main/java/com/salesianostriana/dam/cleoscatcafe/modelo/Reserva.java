/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.modelo;

import java.time.LocalDate;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PC
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
	
	@Id
	@GeneratedValue
	private long id_reserva;
	
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;
	private LocalDate fecha;
	private String tipo_reserva;
	private Gato gato;
	private String metodo_pago;
	private boolean comida_gatos;
	private boolean juguetes_gatos;
	private boolean bebida;
	private boolean foto_mural;
	private double precio_persona;
	private int tiempo;
	private double precio_final;

}
