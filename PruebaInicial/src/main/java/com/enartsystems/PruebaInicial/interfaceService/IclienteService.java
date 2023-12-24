package com.enartsystems.PruebaInicial.interfaceService;

import java.util.List;
import java.util.Optional;

import com.enartsystems.PruebaInicial.model.Cliente;

public interface IclienteService {
	public List <Cliente>listar(String palabraClave);
	public Optional <Cliente>listarId(int id);
	public int save(Cliente p);
	public void delete (int id);
	

}
