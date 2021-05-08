package com.cognizant.ormlearn.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

@Service
public class StockService {
	
	@Autowired
	private StockRepository stockRepository;
	
	@Transactional
	public List<Stock> getAllStocks(){
		
		return stockRepository.findAll();
	}
	
	@Transactional
	public List<Stock> findByCodeAndDateBetween(String code, Date start, Date end){
		return stockRepository.findByCodeAndDateBetween(code, start, end);
	}
	
	@Transactional
	public List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal close){
		return stockRepository.findByCodeAndCloseGreaterThan(code, close);
	}
	
	@Transactional
	public List<Stock> findTop3ByOrderByVolumeDesc(){
		return stockRepository.findTop3ByOrderByVolumeDesc();
	}
	
	@Transactional
	public List<Stock> findTop3ByCodeOrderByVolume(String code){
		return stockRepository.findTop3ByCodeOrderByVolume(code);
	}

}
