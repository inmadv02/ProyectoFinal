/**
 * 
 */
package com.salesianostriana.dam.cleoscatcafe.servicios.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author dominguez.vamar21
 * @version 1.0
 * @see 1.0
 */
@Service
public abstract class BaseService<T, ID, R extends JpaRepository<T, ID>> implements IBaseService<T, ID>{
	
	/**
	 * Atributo que extiende al repositorio JpaRepository y mediante el cua
	 * se produce la inyección de dependencias con la anotacion @Autowired
	 */
	@Autowired
	protected R repositorio;
	
	
	public BaseService(R repo) {
		this.repositorio = repo;
	}
	
	/**
	 * Guardamos una nueva entidad.
	 * @param t
	 * @return
	 */
	@Override
	public T save(T t) {
		return repositorio.save(t);
	}
	
	/**
	 * Encontramos a través del id su entidad correspondiente
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public T findById(ID id) {
		return repositorio.findById(id).orElse(null);
	}

	/**
	 * Encontramos todas las entidades de un tipo de entidad
	 * @return
	 */
	@Override
	public List<T> findAll() {
		return repositorio.findAll();
	}
	
	/**
	 * Editamos una instancia de una entidad.
	 * @param t
	 * @return
	 */
	@Override
	public T edit(T t) {
		return repositorio.save(t);
	}
	
	/**
	 * Eliminamos una instancia de una entidad
	 * @param t
	 */
	@Override
	public void delete(T t) {
		repositorio.delete(t);
	}
	
	/**
	 * Eliminamos una instancia a través de su ID
	 * @param id
	 */
	@Override
	public void deleteById(ID id) {
		repositorio.deleteById(id);
	}

}