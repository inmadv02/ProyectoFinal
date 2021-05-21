/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fecha;
	private int num_personas;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo_reserva;
	
	@ManyToOne
	private Gato gato;
	
	private String metodo_pago;
	private boolean comida_gatos;
	private boolean juguetes_gatos;
	private boolean bebida;
	private boolean foto_mural;
	private double precio_persona;
	
	@Column(nullable = true)
	private LocalTime tiempo;
	
	private double precio_final;
	
	
	public double configuracionReservas () {
		
		double media = 3.5, hora = 4.5, horaYMedia = 5.5;
		
		if(this.tipo_reserva == Tipo.media) {
			this.tiempo = LocalTime.of(0, 30);
			this.bebida = false;
			this.juguetes_gatos = false;
			this.foto_mural = false;
			
			this.precio_persona = media;
			this.precio_final = media*this.num_personas;
			return this.precio_final;
		}
		
		if(this.tipo_reserva == Tipo.hora) {
			this.tiempo = LocalTime.of(1, 0);
			this.foto_mural = false;
			this.precio_persona = hora;
			
			
			this.precio_final = hora*this.num_personas;
			return this.precio_final;
		}
		
		else {
			this.tiempo = LocalTime.of(1, 30);
			this.precio_persona = horaYMedia;
			
			
			this.precio_final = this.precio_persona*this.num_personas;
			return this.precio_final;
		}
	}

}
