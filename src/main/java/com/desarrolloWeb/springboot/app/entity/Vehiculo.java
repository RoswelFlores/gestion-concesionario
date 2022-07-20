package com.desarrolloWeb.springboot.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name = "vehiculos")
public class Vehiculo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long stock;

	private String marca;

	private String modelo;

	private String color;
	

	
	@Column(name = "fecha_entrega", columnDefinition = "DATE")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private String Fecha_entrega;

	public Vehiculo() {
		
	}
	



	public Vehiculo(long id, long stock, String marca, String modelo, String color, String fecha_entrega) {
		super();
		this.id = id;
		this.stock = stock;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		Fecha_entrega = fecha_entrega;
	}




	public String getFecha_entrega() {
		return Fecha_entrega;
	}



	public void setFecha_entrega(String fecha_entrega) {
		Fecha_entrega = fecha_entrega;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
}
