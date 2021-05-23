/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.cleoscatcafe.modelo.Reserva;

/**
 * Repositorio de Reserva que extiende al JpaRepository
 * @author dominguez.vamar21
 * @version 1.0
 * @since 1.0
 */
public interface ReservaRepository extends JpaRepository <Reserva, Long>{
	
	/**
	 * Consulta que busca los clientes que hayan reservado cuyo apellido sea el mismo.
	 * @param apellidos
	 * @return lista de las reservas donde los clientes tienen el mismo apellido
	 */
	
	List <Reserva> findByApellidosContainsIgnoreCaseOrderByApellidosDesc (String apellidos);
	
	

}
