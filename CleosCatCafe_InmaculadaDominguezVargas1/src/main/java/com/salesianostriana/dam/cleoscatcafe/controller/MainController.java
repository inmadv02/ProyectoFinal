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


/**
 * Clase de la página principal. Existe para cargar y mostrar los datos de la base de datos. Para
 * acceder a ella hay que escribir en el buscador localhost:9000/main/lista
 * 
 * @author dominguez.vamar21
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {
	
	/**
	 * Atributos final y anotación @RequiredArgsConstructor para la inyección de datos y las dependencias
	 */
	private final GatoServicio gs;
	private final ReservaServicio rs;

	/**
	 * Muestra la lista con los datos iniciales de la base de datos.
	 * 
	 * @param model
	 * @return listas con reservas y gatos.
	 */
	@GetMapping("/lista")
	public String index(Model model) {
		model.addAttribute("reservas", rs.findAll());
		model.addAttribute("gatos", gs.findAll());
		return "index";
	}
	
	
	

}
