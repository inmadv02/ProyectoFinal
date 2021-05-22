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
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne
	private Gato gato;
	
	private String metodo_pago;
	private final boolean comida_gatos = true;
	private boolean juguetes_gatos;
	private boolean bebida;
	private boolean foto_mural;
	private double precio_persona;
	
	@Column(nullable = true)
	private LocalTime tiempo;
	
	private double precio_final;
	
	
	public double configuracionReservas (Reserva reserva) {
		
		double media = 3.5, hora = 4.5, horaYMedia = 5.5;
		
		if(reserva.tipo_reserva == Tipo.media) {
			reserva.setTiempo(LocalTime.of(0, 30));
			reserva.setBebida(false);
			reserva.setJuguetes_gatos(false);
			
			reserva.setFoto_mural(false);
			
			reserva.setPrecio_persona(media);
			reserva.setPrecio_final(media*reserva.getNum_personas()); 
			return reserva.getPrecio_final();
			
		}
		
		if(this.tipo_reserva == Tipo.hora) {
			reserva.setTiempo(LocalTime.of(1, 00));
			reserva.setBebida(true);
			reserva.setJuguetes_gatos(true);
		
			reserva.setFoto_mural(false);
			
			reserva.setPrecio_persona(hora);
			reserva.setPrecio_final(hora*reserva.getNum_personas()); 
			return reserva.getPrecio_final();
		}
		
		else {
			reserva.setTiempo(LocalTime.of(1, 30));
			reserva.setBebida(true);
			reserva.setJuguetes_gatos(true);
			
			reserva.setFoto_mural(true);
			
			reserva.setPrecio_persona(horaYMedia);
			reserva.setPrecio_final(horaYMedia*reserva.getNum_personas()); 
			return reserva.getPrecio_final();
		}
	}

}
