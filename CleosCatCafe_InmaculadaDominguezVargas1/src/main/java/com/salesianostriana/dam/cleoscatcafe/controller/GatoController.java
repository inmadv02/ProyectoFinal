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
 * 
 * Clase para gestionar los gatos del Cat Café. Aquí podemos añadir nuevos gatos, borrarlos, editarlos, etc.
 * @author dominguez.vamar21
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/gato")
public class GatoController {
	
	/**
	 * Atributos final y anotación @RequiredArgsConstructor para la inyección de datos y las dependencias.
	 */
	private final GatoServicio gs;
	private final ReservaServicio rs;
	
	/**
	 * Método de búsqueda por color 
	 * 
	 * @param model
	 * @param consulta
	 * @return una lista de gatos cuyo color coincida con el de la consulta en el index
	 */
	@GetMapping("/")
	public String gatosContienenColor(Model model, 
			@RequestParam("q") Optional<String> consulta) {
		
		List<Gato> listadoGatos;
		
	
		listadoGatos = gs.contienenColor(consulta.get());
			

		model.addAttribute("gatos", listadoGatos);					

		return "main/lista";
	}
	

	/**
	 * Creamos un gato vacío que posteriormente vamos a rellenar dentro del formulario.
	 * Establecemos que la fecha de entrada siempre sea la fecha actual.
	 * @param model
	 * @return página web del formulario
	 */
	@GetMapping("/admin/nuevo-gato")
	public String nuevoGato(Model model) {
		model.addAttribute("gato", new Gato());
		return "admin/form-gato";
	}
	
	/**
	 * Guardamos el gato que hemos rellenado en el formulario
	 * 
	 * @param gato
	 * @param model
	 * @return nos devuelve a la principal
	 */
	@PostMapping("/admin/nuevo-gato/submit")
	public String submitNuevoGato(@ModelAttribute("gato") Gato gato, Model model) {
		
		gato.setFecha_entrada(LocalDate.now());
		gs.save(gato);
		
		return "redirect:/main/lista";
	}
	
	/**
	 * Método para ver los detalles de un gato en específico.
	 * @param id del gato
	 * @param model
	 * @return la plantilla con los detalles del gato.
	 */
	
	@GetMapping("/gato/{id}")
	public String showDetails(@PathVariable("id") Long id, Model model) {
	
		Gato gato = gs.findById(id);
		
		model.addAttribute("gato", gato);
		return "detalle";
		
		
	}
	
	/**
	 * Editamos el gato usando el formulario que hemos usado para agregar.
	 * Comprobamos si el id del gato es null.
	 * 
	 * @param id del gato
	 * @param model
	 * @return el formulario con los datos ya cargados, o los redirige a la página principal
	 */
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
	
	/**
	 * Borramos un gato usando su id. Comprobamos antes que este no sea nulo y que 
	 * el gato en cuestión no tenga reservas asociadas.
	 * 
	 * @param id
	 * @param model
	 * @return nos redirige a la página principal
	 */

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
	

	
	
}
