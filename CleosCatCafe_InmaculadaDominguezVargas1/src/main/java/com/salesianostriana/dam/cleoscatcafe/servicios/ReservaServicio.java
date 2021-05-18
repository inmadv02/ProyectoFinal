/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.servicios;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cleoscatcafe.modelo.Reserva;
import com.salesianostriana.dam.cleoscatcafe.repos.ReservaRepository;
import com.salesianostriana.dam.cleoscatcafe.servicios.base.BaseService;

/**
 * @author PC
 *
 */

@Service

public class ReservaServicio extends BaseService <Reserva, Long, ReservaRepository> {

	public ReservaServicio(ReservaRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	
	

}


