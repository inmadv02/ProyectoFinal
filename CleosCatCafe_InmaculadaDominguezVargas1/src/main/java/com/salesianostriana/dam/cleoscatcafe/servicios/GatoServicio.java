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
 * @author PC
 *
 */

@Service

public class GatoServicio extends BaseService <Gato, Long, GatoRepository> {

	public GatoServicio(GatoRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	
	

	public List<Gato> ordenadosPorNombre (Long id){
		return this.repositorio.findByIdOrderByNombreAsc(id);
	}
	
//	public List<Gato> ordenadosPorEdad (Long id){
//		return this.repositorio.findByIdOrderByEdad(id);
//	}
	
	public List<Gato> contienenColor (String color){
		return this.repositorio.findByColorContainsIgnoreCase(color);
	}
	
}
