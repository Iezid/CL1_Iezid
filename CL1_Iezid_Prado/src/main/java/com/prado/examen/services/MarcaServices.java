package com.prado.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prado.examen.entity.Marca;
import com.prado.examen.repository.MarcaRepository;

@Service
public class MarcaServices {
	@Autowired
	private MarcaRepository repo;
	
	public List<Marca> listarTodos(){
		return repo.findAll();
	}

}
