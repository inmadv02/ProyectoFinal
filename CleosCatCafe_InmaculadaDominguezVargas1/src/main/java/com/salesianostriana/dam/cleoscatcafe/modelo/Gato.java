/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.modelo;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Gato {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String foto;
	private String nombre;
	private String sexo;
	private int edad;
	private String color;
	private LocalDate fecha_entrada;
	private String informacion;
	
	@OneToMany
	private int id_reserva;

}
