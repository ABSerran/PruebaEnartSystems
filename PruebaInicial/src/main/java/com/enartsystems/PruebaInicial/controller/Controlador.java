package com.enartsystems.PruebaInicial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enartsystems.PruebaInicial.interfaceService.IclienteService;
import com.enartsystems.PruebaInicial.model.Cliente;

@Controller
@RequestMapping
public class Controlador {
	@Autowired
	private IclienteService service;

	@GetMapping("/")
	public String listar(Model model, @Param("palabraClave") String palabraClave) {
		
		List<Cliente> clientes = service.listar(palabraClave);
		model.addAttribute("clientes", clientes);
		model.addAttribute("palabraClave", palabraClave);
		return "index";
	}

	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "form";
	}

	@PostMapping("/save")
	public String save(@Validated Cliente p, Model model) {
		service.save(p);
		return "redirect:/";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional <Cliente>cliente=service.listarId(id);
		model.addAttribute("cliente", cliente);
		return "form";
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/";
		
	}

}
