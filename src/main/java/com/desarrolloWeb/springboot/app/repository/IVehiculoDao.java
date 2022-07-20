package com.desarrolloWeb.springboot.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.desarrolloWeb.springboot.app.entity.Vehiculo;

public interface IVehiculoDao extends CrudRepository<Vehiculo, Long>{
	
}
