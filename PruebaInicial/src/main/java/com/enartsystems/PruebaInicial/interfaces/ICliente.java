package com.enartsystems.PruebaInicial.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enartsystems.PruebaInicial.model.Cliente;

@Repository
public interface ICliente extends CrudRepository <Cliente, Integer>{
	
	@Query ("SELECT p FROM Cliente p WHERE " 
			+ "CONCAT (p.name, p.surname)"
			+ "LIKE %?1%")
	public List<Cliente> findAll(String palabraClave);

}
