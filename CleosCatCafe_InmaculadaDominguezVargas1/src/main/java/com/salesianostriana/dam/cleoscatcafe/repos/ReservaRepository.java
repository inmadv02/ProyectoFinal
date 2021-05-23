/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.cleoscatcafe.modelo.Reserva;

/**
 * Repositorio de Reserva que extiende al JpaRepository
 * @author dominguez.vamar21
 * @version 1.0
 * @since 1.0
 */
public interface ReservaRepository extends JpaRepository <Reserva, Long>{
	
	List <Reserva> findByApellidosContainsIgnoreCase (String apellidos);

}
