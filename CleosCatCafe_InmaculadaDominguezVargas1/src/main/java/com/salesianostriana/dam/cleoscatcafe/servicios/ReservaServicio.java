/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cleoscatcafe.modelo.Gato;
import com.salesianostriana.dam.cleoscatcafe.modelo.Reserva;
import com.salesianostriana.dam.cleoscatcafe.repos.ReservaRepository;
import com.salesianostriana.dam.cleoscatcafe.servicios.base.BaseService;

/**
 * @author dominguez.vamar21
 *
 */

@Service

public class ReservaServicio extends BaseService <Reserva, Long, ReservaRepository> {

	public ReservaServicio(ReservaRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	
	public List <Reserva> contienenApellidos (String apellidos){
		return repositorio.findByApellidosContainsIgnoreCaseOrderByApellidosDesc(apellidos);
	}
	
	


}


