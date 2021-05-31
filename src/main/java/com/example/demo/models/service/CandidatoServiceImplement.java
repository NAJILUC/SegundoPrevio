package com.example.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.entity.Candidato;
import com.example.demo.models.repository.CandidatoRepository;


@Service
public class CandidatoServiceImplement implements ICandidatoService {

	@Autowired
	private CandidatoRepository candidatoRepository;
	@Override
	public List<Candidato> listarTodos() {
		// TODO Auto-generated method stub
		return (List<Candidato>) candidatoRepository.findAll();
	}

	@Override
	public void guardar(Candidato modelo) {
		candidatoRepository.save(modelo);

	}

	@Override
	public Candidato buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return candidatoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		candidatoRepository.deleteById(id);

	}

}
