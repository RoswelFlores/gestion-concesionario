package com.desarrolloWeb.springboot.app.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.desarrolloWeb.springboot.app.entity.Vehiculo;
import com.desarrolloWeb.springboot.app.service.IVehiculoService;

@Controller
public class AppController {
	
	

	@Autowired
	private IVehiculoService vehiculoService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		dateformat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateformat, true));
	}
	
	@GetMapping({"/","index"})
	public String index(Model model) {
		List<Vehiculo> vehiculos = vehiculoService.listarVehiculos();
		model.addAttribute("vehiculos", vehiculos);
		return "index1";
	}

	@GetMapping("/login")
	public String Logeo() {
		return "index";
	}



	@GetMapping("/admin/index")
	public String admin(Model model) {
		List<Vehiculo> vehiculos = vehiculoService.listarVehiculos();
		model.addAttribute("vehiculos", vehiculos);
		return "admin";
	}
	
	

	@GetMapping("/agregar")
	public String agregar(Vehiculo vehiculos) {
		return "modificar";
	}

	@PostMapping("/guardar")
	public String guardar(@Valid Vehiculo vehiculos,BindingResult result) {
		if(result.hasErrors()) {
			return "modificar";
		}
		vehiculoService.guardarVehiculo(vehiculos);
		return "redirect:/admin/index";

	}

	@GetMapping("/editar/{id}")
	public String editar(Vehiculo vehiculos, Model model) {
		vehiculos = vehiculoService.encontrarVehiculo(vehiculos);
		model.addAttribute("vehiculo", vehiculos);

		return "modificar";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(Vehiculo vehiculos) {

		vehiculoService.eliminarVehiculo(vehiculos);
		return "redirect:/admin/index";

	}




}
