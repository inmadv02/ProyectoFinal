/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.cleoscatcafe.modelo.Gato;


/**
 * Repositorio de Gato que extiende al JpaRepository
 * 
 * @author dominguez.vamar21
 * @version 1.0
 * @since 1.0
 *
 */
public interface GatoRepository extends JpaRepository <Gato, Long>{
	
	
	/**
	 * Consulta que obtiene los gatos que sean del mismo color.
	 * @param color
	 * @return lista de gatos.
	 */
	List <Gato> findByColorContainsIgnoreCase (String color);
	
	

}
