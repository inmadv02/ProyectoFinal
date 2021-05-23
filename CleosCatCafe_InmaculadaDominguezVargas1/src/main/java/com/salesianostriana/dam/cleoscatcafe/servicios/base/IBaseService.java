package com.salesianostriana.dam.cleoscatcafe.servicios.base;

import java.util.List;

/**
 * Interfaz donde están los métodos principales del proyecto (editar, borrar, guardar, etc.)
 * 
 * @author dominguez.vamar21
 * @version 1.0
 * @param <T>
 * @param <ID>
 */

public interface IBaseService<T, ID> {

	/**
	 * Guardamos una nueva entidad.
	 * @param t
	 * @return 
	 */
	T save(T t);

	/**
	 * Encontramos a través del id su entidad correspondiente
	 * 
	 * @param id
	 * @return
	 */
	T findById(ID id);

	/**
	 * Encontramos todas las entidades de un tipo de entidad
	 * @return
	 */
	List<T> findAll();

	/**
	 * Editamos una instancia de una entidad.
	 * @param t
	 * @return
	 */
	T edit(T t);

	/**
	 * Eliminamos una instancia de una entidad
	 * @param t
	 */
	void delete(T t);

	/**
	 * Eliminamos una instancia a través de su ID
	 * @param id
	 */
	void deleteById(ID id);

}