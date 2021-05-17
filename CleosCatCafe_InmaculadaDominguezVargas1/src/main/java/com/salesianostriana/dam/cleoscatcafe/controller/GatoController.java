/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.cleoscatcafe.modelo.Gato;
import com.salesianostriana.dam.cleoscatcafe.servicios.GatoServicio;
import com.salesianostriana.dam.cleoscatcafe.servicios.ReservaServicio;

import lombok.RequiredArgsConstructor;

/**
 * @author dominguez.vamar21
 *
 */
@Controller
@RequiredArgsConstructor

public class GatoController {
	
	private final GatoServicio gs;

	private final ReservaServicio rs;
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("gatos", gs.findAll());
		return "index";
	}
	
	@GetMapping("/admin/nuevo-gato")
	public String nuevaCategoria(Model model) {
		model.addAttribute("gato", new Gato());
		return "agregar";
	}
	
	@PostMapping("/admin/nuevo-gato/submit")
	public String submitNuevaCategoria(@ModelAttribute("gato") Gato gato, Model model) {
		
		gs.save(gato);
		
		return "redirect:/index";
	}
	
	
	
	
}
