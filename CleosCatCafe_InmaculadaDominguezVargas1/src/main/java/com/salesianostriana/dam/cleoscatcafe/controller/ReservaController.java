/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.cleoscatcafe.modelo.Gato;
import com.salesianostriana.dam.cleoscatcafe.modelo.Reserva;
import com.salesianostriana.dam.cleoscatcafe.servicios.GatoServicio;
import com.salesianostriana.dam.cleoscatcafe.servicios.ReservaServicio;

import lombok.RequiredArgsConstructor;

/**
 * Clase para gestionar las reservas. 
 * @author dominguez.vamar21
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping("/reserva")
@RequiredArgsConstructor
public class ReservaController {
	
	/**
	 * Atributos final y anotación @RequiredArgsConstructor para la inyección de datos y las dependencias
	 */
	private final GatoServicio gs;
	private final ReservaServicio rs;
	
	/**
	 * Método de búsqueda por apellido 
	 * 
	 * @param model
	 * @param consulta
	 * @return una lista de reservas cuyo apellido coincida con el de la consulta en el index
	 */
	@GetMapping("/")
	public String gatosContienenColor(Model model, 
			@RequestParam("q") Optional<String> consulta) {
		
		List <Reserva> listadoReservas;
		
			
		listadoReservas = rs.contienenApellidos(consulta.get());
		

		model.addAttribute("reservas", listadoReservas);					

		return "index";
	}
	
	
	/**
	 * Método para crear una nueva reserva. Creamos una reserva vacía
	 * que luego vamos a rellenar en el formulario.
	 * Nos traemos los gatos debido a la asociación que hay entre ellos,
	 * la cual va a mostrarse en el formulario.
	 * 
	 * @param model
	 * @return formulario de reserva.
	 */
	
	@GetMapping("/nueva-reserva")
	public String nuevaReserva(Model model) {
		model.addAttribute("reserva", new Reserva());
		model.addAttribute("gatos", gs.findAll());
		return "admin/form-reserva";
	}
	
	/**
	 * Guardamos la reserva. Antes de guardarla, la "configuramos" con un método de la
	 * clase Reserva.
	 * 
	 * @param reserva
	 * @param model
	 * @return la página principal
	 */
	@PostMapping("/nueva-reserva/submit")
	public String submitNuevaReserva(@ModelAttribute("reserva") Reserva reserva, Model model) {
		
		reserva.configuracionReservas(reserva);
		rs.save(reserva);
		
		return "redirect:/main/lista";
		
	}
	
	
	
	
}
