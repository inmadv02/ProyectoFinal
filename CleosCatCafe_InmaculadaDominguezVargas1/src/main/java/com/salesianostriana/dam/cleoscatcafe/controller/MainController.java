package com.salesianostriana.dam.cleoscatcafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.cleoscatcafe.modelo.Gato;
import com.salesianostriana.dam.cleoscatcafe.servicios.GatoServicio;
import com.salesianostriana.dam.cleoscatcafe.servicios.ReservaServicio;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {
	
	
	
	private final GatoServicio gs;
	private final ReservaServicio rs;

	@GetMapping("/lista")
	public String index(Model model) {
		model.addAttribute("reservas", rs.findAll());
		model.addAttribute("gatos", gs.findAll());
		return "index";
	}
	
	@GetMapping("/lista/nombreGato/{id}")
	public String todosLosGato(Model model, 
			@PathVariable("id") Long id) {
		
		model.addAttribute("alumnos", gs.ordenadosPorNombre(id));			

		return "main/lista";
	}
	

}
