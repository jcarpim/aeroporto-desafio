package com.fly.company.flyCompanySearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fly.company.flyCompanySearch.model.PesquisaVooRequest;
import com.fly.company.flyCompanySearch.model.Voo;
import com.fly.company.flyCompanySearch.service.VooService;

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

}
