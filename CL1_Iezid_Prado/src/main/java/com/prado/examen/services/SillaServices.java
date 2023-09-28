package com.prado.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prado.examen.entity.Silla;
import com.prado.examen.repository.SillaRepository;

@Service
public class SillaServices {
	
	@Autowired
	private SillaRepository repo;
	
	public void registrar(Silla sil)
{
		 repo.save(sil);
}
	
	public void actualizar(Silla sil) {
		repo.save(sil);
	}
	
	public Silla buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<Silla> listarTodos(){
		return repo.findAll();
	}

}
