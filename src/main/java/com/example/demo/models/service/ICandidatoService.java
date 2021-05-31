package com.example.demo.models.service;

import java.util.List;

import com.example.demo.models.entity.Candidato;
public interface ICandidatoService {

	 public List<Candidato> listarTodos();
	 public void guardar(Candidato modelo);
	 public Candidato buscarPorId(Long id);
	 public void eliminar(Long id);
	
}
