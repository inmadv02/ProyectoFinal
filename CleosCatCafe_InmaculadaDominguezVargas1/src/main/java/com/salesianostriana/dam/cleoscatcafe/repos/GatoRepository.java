/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.cleoscatcafe.modelo.Gato;


/**
 * @author PC
 *
 */
public interface GatoRepository extends JpaRepository <Gato, Long>{
	
	
	long countFechaReservaAfter ();
	
	List <Gato> findByIdOrderByNombreAsc(Long id);
	

//  List <Gato> findByIdOrderByEdad(Long id);
	
	List <Gato> findByColorIgnoreCase (String color);
	
	

}
