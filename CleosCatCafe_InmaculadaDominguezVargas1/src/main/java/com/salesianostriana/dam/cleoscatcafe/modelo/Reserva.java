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
 * Clase modelo Reserva. Recoge los atributos de las reservas del Cat Café.
 * 
 * @author dominguez.vamar21
 * @version 1.0
 * @since 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reserva {
	
	/**
	 * Indicamos la clave primaria de la clase con la anotación Id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_reserva;
	
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;
	
	/**
	 * Especificamos el formato que van a tener las fechas en 
	 * nuestro proyecto.
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fecha;
	private int num_personas;
	
	/**
	 * Especificamos que el Enum sea String
	 */
	@Enumerated(EnumType.STRING)
	private Tipo tipo_reserva;
	
	/**
	 * Atributo que asocia las entidades Gato y Reserva.
	 * Solo se puede hacer una reserva de un gatito.
	 */
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne
	private Gato gato;
	
	private String metodo_pago;
	
	/**
	 * A continuación aparecen unos atributos
	 * que serán true o false dependiendo de la modalidad
	 * de reserva que el usuario ha escogido. 
	 * 
	 * La comida de gatos siempre estará disponible en todos
	 * los tipos de reserva.
	 */
	private final boolean comida_gatos = true;
	private boolean juguetes_gatos;
	private boolean bebida;
	private boolean foto_mural;
	private double precio_persona;
	
	/**
	 * Permitimos que la columna tiempo pueda ser null para
	 * que ahorrarnos errores en el programa, pues el formulario no
	 * hay un campo en el que el usuario pueda marcar el tiempo que 
	 * va a durar su reserva.
	 */
	@Column(nullable = true)
	private LocalTime tiempo;
	
	private double precio_final;
	
	
	/**
	 * Este es un método que, dependiendo del tipo de reserva, 
	 * va a settear como false unos atributos u otros. También
	 * calcula el precio para cada reserva. Sé que no está bien ponerlo
	 * aquí, pero como no tengo "Carrito" como en una página de compras, no
	 * me ha quedado otra.
	 * 
	 * @param reserva
	 * @return el precio final de la reserva.
	 */
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
			reserva.setFoto_mural(false);
			
			reserva.setPrecio_persona(hora);
			reserva.setPrecio_final(hora*reserva.getNum_personas()); 
			return reserva.getPrecio_final();
		}
		
		else {
			reserva.setTiempo(LocalTime.of(1, 30));
	
			reserva.setPrecio_persona(horaYMedia);
			reserva.setPrecio_final(horaYMedia*reserva.getNum_personas()); 
			return reserva.getPrecio_final();
		}
	}

}
