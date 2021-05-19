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
import com.salesianostriana.dam.cleoscatcafe.servicios.GatoServicio;
import com.salesianostriana.dam.cleoscatcafe.servicios.ReservaServicio;

import lombok.RequiredArgsConstructor;

/**
 * @author dominguez.vamar21
 *
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/gato")
public class GatoController {
	
	
	private final GatoServicio gs;
	private final ReservaServicio rs;
	
	@GetMapping("/lista")
	public String index(Model model) {
		
		model.addAttribute("gatos", gs.findAll());
		return "index";
	}
	
	@GetMapping("/admin/nuevo-gato")
	public String nuevoGato(Model model) {
		model.addAttribute("gato", new Gato());
		return "admin/agregar";
	}
	
	@PostMapping("/admin/nuevo-gato/submit")
	public String submitNuevoGato(@ModelAttribute("gato") Gato gato, Model model) {
		
		gs.save(gato);
		
		return "redirect:/gato/lista";
	}
	
	@GetMapping("/lista/{id}")
	public String mostrarGato(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("gato", gs.findById(id));
		
		return "redirect:/gato/lista";
	}
	
	@GetMapping("/admin/editar/{id}")
	public String editarGato(@PathVariable("id") Long id, Model model) {

		model.addAttribute("gato", gs.findById(id));

		return "admin/agregar";

	}
	
	
//	@GetMapping("/borrar/{id}")
//	public String borrarProducto(@PathVariable("id") Long id, Model model) {
//
//		Producto producto = productoService.findById(id);
//
//		if (producto != null) {
//			productoService.delete(producto);
//		}
//
//		return "redirect:/admin/producto/";
//
//	}
//	
	
}
