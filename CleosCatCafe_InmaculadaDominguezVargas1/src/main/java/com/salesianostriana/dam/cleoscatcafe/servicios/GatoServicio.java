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
	
//	@Transactional
//	public long countReservaByAfterDiaDeHoy (long id) {
//		return repositorio
//				.findAll()
//				.stream()
//				.map(p -> p.getReservas().get((int)id).getFecha().isAfter(LocalDate.now()))
//				.count();
//	}
//	

	public List<Gato> ordenadosPorNombre (Long id){
		return this.repositorio.findByIdOrderByNombreAsc(id);
	}
	
	
}
