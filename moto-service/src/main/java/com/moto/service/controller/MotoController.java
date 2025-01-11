package com.moto.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moto.service.entidades.Moto;
import com.moto.service.servicios.MotoService;

@RestController
@RequestMapping("/moto")
public class MotoController {
	
	@Autowired
	private MotoService motoService;
	
	@GetMapping
	public ResponseEntity<List<Moto>> listarMoto (){
		List<Moto> carros = motoService.getAll();
		if(carros.isEmpty()) return ResponseEntity.noContent().build();
		return ResponseEntity.ok(carros);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Moto> obtenerMoto (@PathVariable int id){
		Moto carro = motoService.getCarroById(id);
		if(carro == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(carro);
	}
	
	@PostMapping
	public ResponseEntity<Moto> guardarMoto (@RequestBody Moto moto){
		Moto nuevoCarro = motoService.save(moto);
		return ResponseEntity.ok(nuevoCarro);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Moto>> listarMotosPorUsuarioId (@PathVariable int usuarioId){
		List<Moto> carros = motoService.byUsuarioId(usuarioId);
		if(carros.isEmpty()) return ResponseEntity.noContent().build();
		return ResponseEntity.ok(carros);
	}

}
