/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.cleoscatcafe.modelo.Gato;


/**
 * @author PC
 *
 */
public interface GatoRepository extends JpaRepository <Gato, Long>{
	
//	public long countReservaByAfterDiaDeHoy (long id);
	
	public List <Gato> findByIdOrderByNombreAsc(Long id);
	

	
	

}
