package com.fly.company.flyCompanySearch.service;

import java.time.LocalDateTime;
import java.util.List;

import com.fly.company.flyCompanySearch.model.Voo;


public interface VooService {

	List<Voo> search(String origem, String destino, LocalDateTime dataVoo);
}
