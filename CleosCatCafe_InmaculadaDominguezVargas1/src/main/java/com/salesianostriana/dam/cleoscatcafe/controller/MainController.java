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
	
//	public String mostrarPagina(Model model) {
//		
//		model.addAttribute("gatos", gs.findAll());
//		model.addAttribute("reservas", rs.findAll());
//	}
	
	@GetMapping("/gato/{id}")
	public String showDetails(@PathVariable("id") Long id, Model model) {
		
		//Buscamos el producto por id
		Gato gato = gs.findById(id);
		
		model.addAttribute("gato", gato);
		return "detalle";
		
		
	}

}
