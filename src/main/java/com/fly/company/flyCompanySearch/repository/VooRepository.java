package com.fly.company.flyCompanySearch.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.fly.company.flyCompanySearch.exception.VooException;
import com.fly.company.flyCompanySearch.model.Voo;

public interface VooRepository {
	 
	public List<Voo>  search(String origem, String  destino,LocalDateTime dataVoo) throws VooException;
}
