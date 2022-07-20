package com.desarrolloWeb.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desarrolloWeb.springboot.app.repository.IVehiculoDao;
import com.desarrolloWeb.springboot.app.entity.Vehiculo;

@Service
public class VehiculoServiceImpl implements IVehiculoService {
	
	@Autowired
	private IVehiculoDao vehiculoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Vehiculo> listarVehiculos() {
		
		return (List<Vehiculo>) vehiculoDao.findAll();
	}

	@Override
	@Transactional()
	public void guardarVehiculo(Vehiculo vehiculo) {
		
		vehiculoDao.save(vehiculo);
	}

	@Override
	@Transactional()
	public void eliminarVehiculo(Vehiculo vehiculo) {
		vehiculoDao.delete(vehiculo);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Vehiculo encontrarVehiculo(Vehiculo vehiculo) {
		
		return vehiculoDao.findById(vehiculo.getId()).orElse(null);
	}

}
