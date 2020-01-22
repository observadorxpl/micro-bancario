package com.productbanking.app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productbanking.app.models.BankingProduct;
import com.productbanking.app.repository.IBankingProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class BankingProductServiceImpl implements IBankingProductService{

	@Autowired
	private IBankingProductRepository bankingProductRepo;
	
	@Override
	public Flux<BankingProduct> findAll() {
		return bankingProductRepo.findAll();
	}

	@Override
	public Mono<BankingProduct> finById(String id) {
		return bankingProductRepo.findById(id);
	}

	@Override
	public Mono<BankingProduct> save(BankingProduct t) {
		return bankingProductRepo.save(t);
	}

	@Override
	public Mono<Void> delete(BankingProduct t) {
		return bankingProductRepo.delete(t);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return bankingProductRepo.deleteById(id);
	}
	
	
}