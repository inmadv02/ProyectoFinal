/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.controller;

import java.time.LocalDate;
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
 * @author dominguez.vamar21
 *
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/gato")
public class GatoController {
	
	
	private final GatoServicio gs;
	private final ReservaServicio rs;
	
	@GetMapping("/")
	public String gatosContienenColor(Model model, 
			@RequestParam("q") Optional<String> consulta) {
		
		List<Gato> listadoGatos;
		
		if (consulta.isEmpty()) {
			listadoGatos = gs.findAll();
		}
		else {
			
			listadoGatos = gs.contienenColor(consulta.get());
		
		}

		model.addAttribute("gatos", listadoGatos);					

		return "index";
	}
	
	
	@GetMapping("/admin/nuevo-gato")
	public String nuevoGato(Model model) {
		model.addAttribute("gato", new Gato());
		return "admin/form-gato";
	}
	
	@PostMapping("/admin/nuevo-gato/submit")
	public String submitNuevoGato(@ModelAttribute("gato") Gato gato, Model model) {
		
		gato.setFecha_entrada(LocalDate.now());
		gs.save(gato);
		
		return "redirect:/main/lista";
	}
	
	@GetMapping("/gato/{id}") //después lo cambio
	public String showDetails(@PathVariable("id") Long id, Model model) {
		
		//Buscamos el producto por id
		Gato gato = gs.findById(id);
		
		model.addAttribute("gato", gato);
		return "detalle";
		
		
	}
	
	@GetMapping("/lista/{id}")
	public String mostrarGato(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("gato", gs.findById(id));
		
		return "redirect:/main/lista";
	}
	
	@GetMapping("/admin/editar/{id}")
	public String editarGato(@PathVariable("id") Long id, Model model) {

		Gato gato = gs.findById(id);

		if(gato != null) {
			model.addAttribute("gato", gato);
			
			return "admin/form-gato";
		} 
		else {
			return "redirect:/main/lista";
		}
	}
	
	

	@GetMapping("/admin/borrar/{id}")
	public String borrarGato(@PathVariable("id") Long id, Model model) {

		Gato gato = gs.findById(id);
		
			if (gato != null && gato.getReservas().isEmpty()) {
				gs.delete(gato);
			}
			else {
				return "redirect:/main/lista";
			}
		
		return "redirect:/main/lista";
		
		
		

	}
	
	@GetMapping("/nombreGato/{id}")
	public String todosLosGatos(Model model, @PathVariable("id") Long id) {
		
		model.addAttribute("gatos", gs.ordenadosPorNombre(id));			

		return "redirect:/main/lista";
	}
	
	
}
