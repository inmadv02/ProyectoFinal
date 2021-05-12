/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.servicios.base;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author PC
 *
 */
public abstract class BaseService <T, ID, R extends JpaRepository <T, ID>> 
			implements IBaseService<T, ID> {

	
	protected R repositorio;
	
	
	public BaseService(R repo) {
		this.repositorio = repo;
	}
}
