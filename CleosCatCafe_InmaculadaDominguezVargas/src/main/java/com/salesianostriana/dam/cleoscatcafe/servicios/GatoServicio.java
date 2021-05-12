/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.servicios;

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
	
	
	public GatoServicio (GatoRepository gr) {
		super(gr);
	}
}
