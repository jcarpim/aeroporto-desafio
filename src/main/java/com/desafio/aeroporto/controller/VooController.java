package com.desafio.aeroporto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.aeroporto.model.Aeroporto;
import com.desafio.aeroporto.model.PesquisaVooRequest;
import com.desafio.aeroporto.model.Voo;
import com.desafio.aeroporto.service.AeroportoService;
import com.desafio.aeroporto.service.VooService;

@RestController
@RequestMapping("/api/vl/voos")
public class VooController {
	@Autowired
	private VooService vooService;

	@PostMapping(path = "/search", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<Voo>> search(@RequestBody PesquisaVooRequest request) {
		return ResponseEntity.ok()
				.body(vooService.search(request.getOrigem(), request.getDestino(), request.getDataVoo()));
	}
	
	@Autowired 
	private AeroportoService aeroportoService;
	
	@GetMapping(path = "/aeroportos", produces = "application/json")
	public ResponseEntity<List<Aeroporto>> carregarTodos() {
		return ResponseEntity.ok().body(aeroportoService.carregarTodos());
	}

}
