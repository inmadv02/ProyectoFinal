package com.salesianostriana.dam.cleoscatcafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.salesianostriana.dam.cleoscatcafe.servicios.GatoServicio;
import com.salesianostriana.dam.cleoscatcafe.servicios.ReservaServicio;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	
	private final GatoServicio gs;
	private final ReservaServicio rs;
	
//	public String mostrarPagina(Model model) {
//		
//		model.addAttribute("gatos", gs.findAll());
//		model.addAttribute("reservas", rs.findAll());
//	}

}
