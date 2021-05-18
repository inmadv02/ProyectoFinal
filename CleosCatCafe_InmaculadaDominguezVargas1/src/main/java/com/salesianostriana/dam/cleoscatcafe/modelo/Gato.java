/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author PC
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Gato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String foto;
	private String nombre;
	private String sexo;
	private int edad;
	private String color;
	private LocalDate fecha_entrada;
	private String informacion;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="gato")
	private List<Reserva> reservas = new ArrayList<>();

	public Gato(long id, String nombre, String sexo, int edad, String color, LocalDate fecha_entrada,
			String informacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
		this.color = color;
		this.fecha_entrada = fecha_entrada;
		this.informacion = informacion;
	}

	public Gato(long id, String foto, String nombre, String sexo, int edad, String color, LocalDate fecha_entrada,
			String informacion) {
		super();
		this.id = id;
		this.foto = foto;
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
		this.color = color;
		this.fecha_entrada = fecha_entrada;
		this.informacion = informacion;
	}
	
	
	
	

}
