package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.entity.Candidato;
import com.example.demo.models.service.ICandidatoService;


@Controller

//@RequestMapping("/")
public class CandidatoController {

	@Autowired
	private ICandidatoService candidatoService;

	@GetMapping("/")
	public String listarClientes(Model model) {
		
		List<Candidato> listadoClientes = candidatoService.listarTodos();
		model.addAttribute("titulo","Lista de Candidatos");
		model.addAttribute("candidatos",listadoClientes);
		
		return "/views/candidato/listar";
	}
	
	@GetMapping("/create")
	public String crear(Model model) {
		
		Candidato cliente = new Candidato();
		model.addAttribute("titulo","Formulario: Nuevo Cliente");
		model.addAttribute("candidatos",cliente);
		return "/views/candidato/frmCrear";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Candidato cliente) {
		candidatoService.guardar(cliente);
		System.out.println("datos guardados");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long idCliente, Model model) {
		
		Candidato cliente = candidatoService.buscarPorId(idCliente);
		model.addAttribute("titulo","Formulario: Editar Cliente");
		model.addAttribute("candidatos",cliente);
		return "/views/candidato/frmCrear";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long idCandidato, Model model) {
		
		candidatoService.eliminar(idCandidato);
		return "redirect:/";
	}
}