/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
@Entity
public class Reserva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_reserva;
	
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;
	private LocalDate fecha;
	private String tipo_reserva;
	
	@ManyToOne
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
