/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.cleoscatcafe.modelo.Gato;
import com.salesianostriana.dam.cleoscatcafe.modelo.Reserva;
import com.salesianostriana.dam.cleoscatcafe.servicios.GatoServicio;
import com.salesianostriana.dam.cleoscatcafe.servicios.ReservaServicio;

import lombok.RequiredArgsConstructor;

/**
 * @author dominguez.vamar21
 *
 */
@Controller
@RequestMapping("/reserva")
@RequiredArgsConstructor
public class ReservaController {
	
	private final GatoServicio gs;
	private final ReservaServicio rs;
	

	@GetMapping("/nueva-reserva")
	public String nuevaReserva(Model model) {
		model.addAttribute("reserva", new Reserva());
		model.addAttribute("gatos", gs.findAll());
		return "admin/form-reserva";
	}
	
	@PostMapping("/nueva-reserva/submit")
	public String submitNuevaReserva(@ModelAttribute("reserva") Reserva reserva, Model model) {
		
		reserva.configuracionReservas(reserva);
		rs.save(reserva);
		
		return "redirect:/main/lista";
		
	}
	
	
}
