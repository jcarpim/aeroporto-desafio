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
import com.desafio.aeroporto.model.Viagem;
import com.desafio.aeroporto.service.AeroportoService;
import com.desafio.aeroporto.service.ViagemService;

@RestController
@RequestMapping("/api/vl/voos")
public class ViagemController {
	@Autowired
	private ViagemService viagemService;
	@Autowired
	private AeroportoService aeroportoService;

	@PostMapping(path = "/procurar", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Viagem> search(@RequestBody PesquisaVooRequest request) {
		return ResponseEntity.ok()
				.body(viagemService.procurar(request.getOrigem(), request.getDestino(), request.getDataVoo()));
	}

	@GetMapping(path = "/aeroportos",  produces = "application/json")
	public ResponseEntity<List<Aeroporto>> carregarTodosAeroportos() {
		return ResponseEntity.ok().body(aeroportoService.carregarTodos());
	}

}
