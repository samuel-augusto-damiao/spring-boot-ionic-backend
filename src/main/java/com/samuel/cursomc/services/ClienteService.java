package com.samuel.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuel.cursomc.domain.Cliente;
import com.samuel.cursomc.repositories.ClienteRepository;
import com.samuel.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);

		return obj.orElseThrow( () -> new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName() ) );
	}
	
}
