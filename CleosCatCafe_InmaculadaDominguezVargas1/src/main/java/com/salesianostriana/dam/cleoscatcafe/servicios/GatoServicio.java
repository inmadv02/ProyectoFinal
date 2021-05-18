/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.servicios;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cleoscatcafe.modelo.Gato;
import com.salesianostriana.dam.cleoscatcafe.repos.GatoRepository;
import com.salesianostriana.dam.cleoscatcafe.servicios.base.BaseService;

import lombok.RequiredArgsConstructor;

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
	
	
}
