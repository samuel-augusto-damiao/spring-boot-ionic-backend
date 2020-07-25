package com.samuel.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.samuel.cursomc.domain.Categoria;
import com.samuel.cursomc.repositories.CategoriaRepository;
import com.samuel.cursomc.services.exceptions.DataIntegrityException;
import com.samuel.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);

		return obj.orElseThrow( () -> new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName() ) );
	}

	public Categoria insert(Categoria obj) {
		
		obj.setId(null);
		return repo.save(obj);
	}

	
	public Categoria update(Categoria obj) {
	
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		
		find(id);
		try {
			repo.deleteById(id);			
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Nao e possivel excluir uma categoria que possui produtos");
		}
	}
	
	
}
