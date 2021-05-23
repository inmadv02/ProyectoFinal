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
 * Clase modelo Gato. Recoge los atributos de los gatos del Cat Café.
 * 
 * @author dominguez.vamar21
 * @version 1.0
 * @since 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Gato {
	
	/**
	 * Indicamos la clave primaria de la clase con la anotación Id
	 */
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
	
	/** 
	 * Establecemos la relación de las tablas con la anotación @OneToMany y el atributo con una lista de reservas, 
	 * ya que un gato puede tener muchas reservas y una reserva solo un gato.
	 */
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="gato")
	private List<Reserva> reservas = new ArrayList<>();

	
}
