/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.servicios;


import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cleoscatcafe.modelo.Gato;
import com.salesianostriana.dam.cleoscatcafe.repos.GatoRepository;
import com.salesianostriana.dam.cleoscatcafe.servicios.base.BaseService;

/**
 * Clase servicio de Gato que extiende a la interfaz donde tenemos todos los métodos que ponemos en uso en el controller.
 * @author dominguez.vamar21
 * @version 1.0
 * @since 1.0
 */

@Service

public class GatoServicio extends BaseService <Gato, Long, GatoRepository> {

	public GatoServicio(GatoRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Método que contiene a la consulta que hemos hecho en el GatoRepository
	 * @param color
	 * @return lista de gatos que son del mismo color
	 */
	public List<Gato> contienenColor (String color){
		return this.repositorio.findByColorContainsIgnoreCase(color);
	}
	
}
