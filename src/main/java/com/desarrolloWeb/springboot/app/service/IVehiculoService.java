package com.desarrolloWeb.springboot.app.service;

import java.util.List;

import com.desarrolloWeb.springboot.app.entity.Vehiculo;

public interface IVehiculoService {
	public List<Vehiculo> listarVehiculos();

	public void guardarVehiculo(Vehiculo vehiculo);

	public void eliminarVehiculo(Vehiculo vehiculo);

	public Vehiculo encontrarVehiculo(Vehiculo vehiculo);
}
