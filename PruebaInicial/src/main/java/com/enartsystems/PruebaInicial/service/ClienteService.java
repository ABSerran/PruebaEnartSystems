package com.enartsystems.PruebaInicial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enartsystems.PruebaInicial.interfaceService.IclienteService;
import com.enartsystems.PruebaInicial.interfaces.ICliente;
import com.enartsystems.PruebaInicial.model.Cliente;

@Service
public class ClienteService implements IclienteService {

	@Autowired
	private ICliente data;

	@Override
	public List<Cliente> listar(String palabraClave) {
		if(palabraClave!=null){
			return data.findAll(palabraClave);
		}
		return (List<Cliente>) data.findAll();
	}

	@Override
	public Optional<Cliente> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Cliente p) {
		int res = 0;
		Cliente cliente = data.save(p);
		if (!cliente.equals(null)) {
			res=1;
		}

		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);

	}

}
